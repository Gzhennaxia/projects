package com.gzhennaxia.ebook.mapper.primary;

import com.gzhennaxia.ebook.dto.NoteDto;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-08 12:19
 */
public interface NoteMapper {
    List<NoteDto> selectAll(Integer bookId);
}
