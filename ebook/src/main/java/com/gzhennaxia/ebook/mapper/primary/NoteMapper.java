package com.gzhennaxia.ebook.mapper.primary;

import com.gzhennaxia.ebook.dto.NoteDto;
import com.gzhennaxia.ebook.po.NotePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-08 12:19
 */
public interface NoteMapper {
    List<NoteDto> selectAll(Integer bookId);

    int insert(List<NotePo> notePos);

    /**
     * 查找是否已经存在
     *
     * @param notePo
     * @return existNotePo
     * @author bli@skystartrade.com
     * @date 2020-05-20 14:03
     */
    NotePo select(@Param("notePo") NotePo notePo);
}
