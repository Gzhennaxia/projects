package com.gzhennaxia.ebook.vo;

import lombok.Data;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-19 17:30
 */
@Data
public class ChapterNoteVo {

    private String chapterName;

    private List<NoteVo> notes;

}
