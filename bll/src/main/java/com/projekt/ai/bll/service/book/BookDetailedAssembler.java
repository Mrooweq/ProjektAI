package com.projekt.ai.bll.service.book;

import com.projekt.ai.bll.model.book.BookDetailedDto;
import com.projekt.ai.bll.service.MainAssembler;
import com.projekt.ai.dal.domain.book.Book;
import com.projekt.ai.dal.domain.book.Stock;
import com.projekt.ai.dal.domain.enums.TypeOfCoverEnum;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class BookDetailedAssembler extends MainAssembler<Book, BookDetailedDto> {

    @Override
    public BookDetailedDto toDto(Book book) {
        return BookDetailedDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .category(book.getCategory().getCategoryName())
                .title(book.getTitle())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .placeOfPublish(book.getPlaceOfPublish())
                .yearOfPublish(book.getYearOfPublish())
                .publisher(book.getPublisher())
                .typeOfCover(book.getTypeOfCover().getName())
                .numberOfAvailablePieces(book.getStock().getNumberOfPieces())
                .price(book.getPrice())
                .build();
    }

    @Override
    public Book fromDto(BookDetailedDto input) {
        TypeOfCoverEnum typeOfCoverByName = TypeOfCoverEnum.getTypeOfCoverByName(input.getTypeOfCover());

        return Book.builder()
                .author(input.getAuthor())
                .category(null)
                .title(input.getTitle())
                .description(input.getDescription())
                .isbn(input.getIsbn())
                .placeOfPublish(input.getPlaceOfPublish())
                .yearOfPublish(input.getYearOfPublish())
                .publisher(input.getPublisher())
                .typeOfCover(typeOfCoverByName)
                .stock(null)
                .price(input.getPrice())
                .build();
    }
}
