package com.gzhennaxia.ebook.mapper.annotation;

import com.gzhennaxia.ebook.po.AnnotationPo;

import java.util.List;

/**
 * @author bo li
 * @date 2020-04-29 10:35
 */
public interface AnnotationMapper {

    /**
     * 查找指定 book 的所有笔记
     *
     * @param assetId book key in iBook.
     * @return notes.
     * @author bli@skystartrade.com
     * @date 2020-05-20 12:13
     */
    List<AnnotationPo> selectAll(String assetId);
}
