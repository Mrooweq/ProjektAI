package com.projekt.ai.bll.service.cart;

import com.projekt.ai.bll.model.cart.CartPositionDto;
import com.projekt.ai.bll.model.cart.CartPositionIdDto;
import com.projekt.ai.bll.model.invoice.InvoiceDto;
import com.projekt.ai.dal.domain.book.Book;
import com.projekt.ai.dal.domain.book.BookRepository;
import com.projekt.ai.dal.domain.cart.CartPosition;
import com.projekt.ai.dal.domain.cart.CartPositionId;
import com.projekt.ai.dal.domain.cart.CartRepository;
import com.projekt.ai.dal.domain.invoice.Invoice;
import com.projekt.ai.dal.domain.invoice.InvoicePosition;
import com.projekt.ai.dal.domain.invoice.InvoicePositionRepository;
import com.projekt.ai.dal.domain.invoice.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartPositionIdAssembler cartPositionIdAssembler;

    @Autowired
    private CartPositionAssembler cartPositionAssembler;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoicePositionRepository invoicePositionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InvoiceAssembler invoiceAssembler;

    public void updateCart(CartPositionIdDto cartPositionIdDto, Integer quantity){
        CartPositionId cartPositionId = cartPositionIdAssembler.toDto(cartPositionIdDto);
        CartPosition cartPosition = cartRepository.findByCartPositionId(cartPositionId);

        Book byId = bookRepository.findById(cartPositionIdDto.getBookId());
        Integer currentNumberOfBooksInStock = byId.getStock().getNumberOfPieces();

        if(cartPosition == null){
            int difference = currentNumberOfBooksInStock - quantity;
            byId.getStock().setNumberOfPieces(difference);

            cartRepository.save( new CartPosition(cartPositionId, quantity) );
        }
        else if(quantity == 0){
            int oldQuantity = cartPosition.getQuantity();
            int sum = currentNumberOfBooksInStock + oldQuantity;
            byId.getStock().setNumberOfPieces(sum);

            cartRepository.delete(cartPosition);
        }
        else{
            int oldQuantity = cartPosition.getQuantity();
            int difference = quantity - oldQuantity;
            currentNumberOfBooksInStock = currentNumberOfBooksInStock - difference;
            byId.getStock().setNumberOfPieces(currentNumberOfBooksInStock);

            cartPosition.setQuantity(quantity);
            cartRepository.save(cartPosition);
        }

        bookRepository.save(byId);
    }

    public List<CartPositionDto> getCart(Long userId){
        List<CartPosition> cartPositionPositionList = cartRepository.getCartPositionsByUserId(userId);
        return cartPositionAssembler.toDtoList(cartPositionPositionList);
    }

    public InvoiceDto buy(Long userId){
        List<CartPosition> cartPositionList = cartRepository.getCartPositionsByUserId(userId);

        List<InvoicePosition> invoicePositionList = new ArrayList<>();

        for (CartPosition cartPosition : cartPositionList) {
            InvoicePosition invoicePosition = new InvoicePosition();
            invoicePosition.setBook(cartPosition.getCartPositionId().getBook());
            invoicePosition.setQuantity(cartPosition.getQuantity());
            invoicePosition.setPriceOfPosition(cartPosition.getCartPositionId().getBook().getPrice());
            invoicePositionList.add(invoicePosition);
        }

        double sumOfPrice = invoicePositionList.stream()
                .mapToDouble(x -> x.getPriceOfPosition() * x.getQuantity())
                .sum();

        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(new Date());
        invoice.setInvoiceValue(sumOfPrice);
        invoice.setUserId(userId);
        invoice.setInvoicePositionList(invoicePositionList);

        Invoice save = invoiceRepository.save(invoice);
        invoicePositionList.forEach(x -> x.setInvoice(save));
        invoicePositionRepository.save(invoicePositionList);
        cartRepository.delete(cartPositionList);

        return invoiceAssembler.toDto(save);
    }
}
