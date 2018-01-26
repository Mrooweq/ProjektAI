package com.projekt.ai.api.controller;

import com.projekt.ai.bll.model.book.BookDetailedDto;
import com.projekt.ai.bll.model.book.BookGeneralDto;
import com.projekt.ai.bll.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET)
    public BookDetailedDto getBook(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<BookGeneralDto> getBooks() {
        return bookService.getBooks();
    }
}
