package com.gzhennaxia.ebook.service;

import com.gzhennaxia.ebook.vo.ChapterNoteVo;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-08 12:13
 */
public interface NoteService {
    void sync(String assetId);

    List<ChapterNoteVo> getNotes(Integer bookId);
}
