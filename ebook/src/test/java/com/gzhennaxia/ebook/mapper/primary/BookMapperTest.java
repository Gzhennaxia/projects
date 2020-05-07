package com.gzhennaxia.ebook.mapper.primary;

import com.gzhennaxia.ebook.entity.Book;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-07 09:19
 */
@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void test() {
        List<Book> books = bookMapper.selectAll();
        System.out.println("###### " + JSONValue.toJSONString(books));
    }

}