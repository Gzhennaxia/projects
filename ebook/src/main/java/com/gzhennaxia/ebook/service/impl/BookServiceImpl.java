package com.gzhennaxia.ebook.service.impl;

import com.gzhennaxia.ebook.entity.Book;
import com.gzhennaxia.ebook.mapper.library.LibraryMapper;
import com.gzhennaxia.ebook.mapper.primary.BookMapper;
import com.gzhennaxia.ebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-29 10:31
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private LibraryMapper libraryMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void syncBooks() {
        List<Book> books = libraryMapper.selectAll();
        List<Book> existBooks = bookMapper.selectAll();

        for (Book existBook : existBooks) {
            books.removeIf(book -> existBook.getAssetId().equals(book.getAssetId()));
        }

        add(books);
    }

    private void add(List<Book> books) {
        if (!CollectionUtils.isEmpty(books))
            bookMapper.insert(books);
    }
}
