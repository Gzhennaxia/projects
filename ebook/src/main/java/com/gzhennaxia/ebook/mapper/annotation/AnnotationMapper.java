package com.gzhennaxia.ebook.mapper.annotation;

import com.gzhennaxia.ebook.entity.Quote;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-29 10:35
 */
public interface AnnotationMapper {

    List<Quote> selectAll();
}
