package com.gzhennaxia.ebook.service;

import com.gzhennaxia.ebook.vo.ChapterNoteVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-20 10:38
 */
@SpringBootTest
class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Test
    public void getNotes() {
        List<ChapterNoteVo> notes = noteService.getNotes(1);
        System.out.println(notes);
    }

    @Test
    public void sync() {
        noteService.sync("25C7C06ED5541277296864DA036BA88A");
    }

}