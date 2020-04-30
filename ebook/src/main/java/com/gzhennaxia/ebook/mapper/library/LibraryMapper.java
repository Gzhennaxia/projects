package com.gzhennaxia.ebook.mapper.library;

import com.gzhennaxia.ebook.entity.Book;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-29 10:37
 */
public interface LibraryMapper {

    List<Book> selectAll();
}
