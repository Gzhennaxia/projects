package com.gzhennaxia.ebook.mapper.library;

import com.gzhennaxia.ebook.entity.Book;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-29 11:49
 */
@SpringBootTest
class LibraryMapperTest {

    @Autowired
    private LibraryMapper libraryMapper;

    @Test
    public void selectAll() {
        List<Book> books = libraryMapper.selectAll();
        System.out.println(JSONValue.toJSONString(books));
    }

}