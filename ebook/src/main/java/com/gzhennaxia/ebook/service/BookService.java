package com.gzhennaxia.ebook.service;

import com.gzhennaxia.ebook.entity.Book;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-29 10:31
 */
public interface BookService {

    /**
     * 同步图书信息
     *
     * @author bli@skystartrade.com
     * @date 2020-05-06 09:43
     */
    void syncBooks();

    List<Book> selectAll();

    Book selectByAssetId(String assetId);

    Book sync(String assetId);
}
