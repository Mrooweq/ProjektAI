package com.projekt.ai.bll.service.cart;

import com.projekt.ai.bll.model.cart.CartPositionIdDto;
import com.projekt.ai.bll.service.MainAssembler;
import com.projekt.ai.dal.domain.book.Book;
import com.projekt.ai.dal.domain.cart.CartPositionId;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class CartPositionIdAssembler extends MainAssembler<CartPositionIdDto, CartPositionId> {

    @Override
    public CartPositionId toDto(CartPositionIdDto cartPositionIdDto) {
        Book book = new Book();
        book.setId(cartPositionIdDto.getBookId());

        return CartPositionId.builder()
                .book(book)
                .userId(cartPositionIdDto.getUserId())
                .build();
    }

    @Override
    public CartPositionIdDto fromDto(CartPositionId cartPositionId) {
        return CartPositionIdDto.builder()
                .bookId(cartPositionId.getBook().getId())
                .userId(cartPositionId.getUserId())
                .build();
    }
}
