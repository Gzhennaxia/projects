package com.gzhennaxia.ebook.mapper.primary;

import com.gzhennaxia.ebook.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-28 09:22
 */
public interface BookMapper {

    List<Book> selectAll();

    void insert(@Param("books") List<Book> books);
}
