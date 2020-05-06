package com.gzhennaxia.ebook.service.impl;

import com.gzhennaxia.ebook.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author bo li
 * @date 2020-05-06 10:14
 */
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void syncBooks() {
        bookService.syncBooks();
    }
}