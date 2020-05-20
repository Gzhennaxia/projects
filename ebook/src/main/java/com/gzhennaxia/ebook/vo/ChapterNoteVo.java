package com.gzhennaxia.ebook.vo;

import com.gzhennaxia.ebook.dto.NoteDto;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bo li
 * @date 2020-05-19 17:30
 */
@Data
public class ChapterNoteVo {

    private Integer chapterId;

    private Integer chapterParentId;

    private String chapterName;

    private List<NoteVo> notes;

    public void addNote(NoteDto noteDto) {
        if (CollectionUtils.isEmpty(this.notes)) this.notes = new ArrayList<>();
        this.notes.add(new NoteVo(noteDto));
    }
}
