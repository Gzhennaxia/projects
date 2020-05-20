package com.gzhennaxia.ebook.mapper.annotation;

import com.gzhennaxia.ebook.po.AnnotationPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-20 12:10
 */
@SpringBootTest
class AnnotationMapperTest {

    @Autowired
    private AnnotationMapper annotationMapper;

    @Test
    public void selectAll() {
        List<AnnotationPo> annotationPos = annotationMapper.selectAll("25C7C06ED5541277296864DA036BA88A");
        System.out.println(annotationPos);
    }
}