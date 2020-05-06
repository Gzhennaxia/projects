package com.gzhennaxia.ebook.controller;

import com.gzhennaxia.common.utils.Result;
import com.gzhennaxia.ebook.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bo li
 * @date 2020-05-06 19:24
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/syncBooks")
    public Result syncBooks() {
        bookService.syncBooks();
        return Result.success();
    }
}
