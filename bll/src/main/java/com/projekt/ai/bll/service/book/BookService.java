package com.projekt.ai.bll.service.book;

import com.projekt.ai.bll.model.book.BookDetailedDto;
import com.projekt.ai.bll.model.book.BookGeneralDto;
import com.projekt.ai.dal.domain.book.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookGeneralAssembler bookGeneralAssembler;

    @Autowired
    private BookDetailedAssembler bookDetailedAssembler;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StockRepository stockRepository;

    public List<BookGeneralDto> getBooks(){
        List<Book> all = bookRepository.findAll();
        return bookGeneralAssembler.toDtoList(all);
    }

    public BookDetailedDto getBook(Long id){
        Book byId = bookRepository.findById(id);
        return bookDetailedAssembler.toDto(byId);
    }

    public void addBooks(List<BookDetailedDto> bookDetailedDtoList) {
        for (BookDetailedDto bookDetailedDto : bookDetailedDtoList) {
            Category category = categoryRepository.findByCategoryName(bookDetailedDto.getCategory());

            Book book = bookDetailedAssembler.fromDto(bookDetailedDto);
            book.setCategory(category);

            Book savedBook = bookRepository.save(book);

            Stock stock = new Stock();
            stock.setNumberOfPieces(bookDetailedDto.getNumberOfAvailablePieces());
            stock.setId(savedBook.getId());

            stockRepository.save(stock);
        }
    }
}
