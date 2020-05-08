package com.gzhennaxia.ebook.service.impl;

import com.gzhennaxia.ebook.entity.Book;
import com.gzhennaxia.ebook.mapper.annotation.AnnotationMapper;
import com.gzhennaxia.ebook.mapper.primary.QuoteMapper;
import com.gzhennaxia.ebook.service.BookService;
import com.gzhennaxia.ebook.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bo li
 * @date 2020-05-08 12:14
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteMapper quoteMapper;

    @Autowired
    private AnnotationMapper annotationMapper;

    @Autowired
    private BookService bookService;

    @Override
    public void sync(String assetId) {
        Book book = bookService.selectByAssetId(assetId);
        if (book == null) {
            book = bookService.sync(assetId);
        }
        // todo
    }
}
