package com.gzhennaxia.ebook.mapper.primary;

import com.gzhennaxia.ebook.dto.NoteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-20 09:24
 */
@SpringBootTest
class NoteMapperTest {

    @Autowired
    private NoteMapper noteMapper;

    @Test
    public void selectAll() {
        List<NoteDto> noteDtos = noteMapper.selectAll(1);
        System.out.println(noteDtos);
    }

}