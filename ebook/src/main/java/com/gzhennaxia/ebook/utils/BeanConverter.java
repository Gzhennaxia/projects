package com.gzhennaxia.ebook.utils;

import com.gzhennaxia.ebook.dto.NoteDto;
import com.gzhennaxia.ebook.vo.ChapterNoteVo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bo li
 * @date 2020-05-20 09:33
 */
public class BeanConverter {

    public static List<ChapterNoteVo> toChapterNoteVo(List<NoteDto> noteDtos) {
        if (CollectionUtils.isEmpty(noteDtos)) return null;
        Map<Integer, ChapterNoteVo> map = new HashMap<>(8);
        for (NoteDto noteDto : noteDtos) {
            Integer chapterId = noteDto.getChapterId();
            ChapterNoteVo chapterNoteVo = map.get(chapterId);
            if (chapterNoteVo == null) {
                chapterNoteVo = new ChapterNoteVo();
                BeanUtils.copyProperties(noteDto, chapterNoteVo);
                map.put(chapterId, chapterNoteVo);
            }
            chapterNoteVo.addNote(noteDto);
        }
        return new ArrayList<>(map.values());
    }
}
