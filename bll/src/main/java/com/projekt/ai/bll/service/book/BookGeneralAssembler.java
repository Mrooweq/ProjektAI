package com.projekt.ai.bll.service.book;

import com.projekt.ai.bll.model.book.BookGeneralDto;
import com.projekt.ai.bll.service.MainAssembler;
import com.projekt.ai.dal.domain.book.Book;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class BookGeneralAssembler extends MainAssembler<Book, BookGeneralDto> {

    @Override
    public BookGeneralDto toDto(Book book) {
        return BookGeneralDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .category(book.getCategory())
                .title(book.getTitle())
                .numberOfAvailablePieces(book.getStock().getNumberOfPieces())
                .price(book.getPrice())
                .build();
    }
}
