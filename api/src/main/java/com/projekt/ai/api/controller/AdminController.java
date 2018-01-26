package com.projekt.ai.api.controller;

import com.projekt.ai.api.auth.Secured;
import com.projekt.ai.bll.model.book.BookDetailedDto;
import com.projekt.ai.bll.service.book.BookService;
import com.projekt.ai.dal.domain.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private BookService bookService;

    @Secured(Role.ADMIN)
    @RequestMapping(value = "/addBooks", method = RequestMethod.POST)
    public void addBooks(@RequestBody List<BookDetailedDto> bookDetailedDtoList) {
        bookService.addBooks(bookDetailedDtoList);
    }
}
