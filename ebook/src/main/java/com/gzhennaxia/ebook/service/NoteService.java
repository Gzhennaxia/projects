package com.gzhennaxia.ebook.service;

import com.gzhennaxia.ebook.vo.ChapterNoteVo;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-08 12:13
 */
public interface NoteService {

    /**
     * 同步笔记信息
     *
     * @param assetId book id in iBook.
     * @author bli@skystartrade.com
     * @date 2020-05-20 10:44
     */
    void sync(String assetId);

    /**
     * 获取指定 book 的笔记，按章节归类
     *
     * @param bookId book key.
     * @return notes
     * @author bli@skystartrade.com
     * @date 2020-05-20 14:45
     */
    List<ChapterNoteVo> getNotes(Integer bookId);
}
