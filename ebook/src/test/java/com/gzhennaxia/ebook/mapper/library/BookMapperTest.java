package com.gzhennaxia.ebook.mapper.library;

import com.gzhennaxia.ebook.entity.Book;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bo li
 * @date 2020-04-29 11:49
 */
@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void selectAll() {
        List<Book> books = bookMapper.selectAll();
        System.out.println(JSONValue.toJSONString(books));
    }

}