package com.gzhennaxia.ebook.service.impl;

import com.gzhennaxia.ebook.dto.NoteDto;
import com.gzhennaxia.ebook.entity.Book;
import com.gzhennaxia.ebook.mapper.annotation.AnnotationMapper;
import com.gzhennaxia.ebook.mapper.primary.CommentMapper;
import com.gzhennaxia.ebook.mapper.primary.NoteMapper;
import com.gzhennaxia.ebook.po.AnnotationPo;
import com.gzhennaxia.ebook.po.CommentPo;
import com.gzhennaxia.ebook.po.NotePo;
import com.gzhennaxia.ebook.service.BookService;
import com.gzhennaxia.ebook.service.NoteService;
import com.gzhennaxia.ebook.utils.BeanConverter;
import com.gzhennaxia.ebook.vo.ChapterNoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bo li
 * @date 2020-05-08 12:14
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private AnnotationMapper annotationMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void sync(String assetId) {
        Book book = bookService.selectByAssetId(assetId);
        List<AnnotationPo> annotationPos = annotationMapper.selectAll(assetId);
        List<NotePo> needInsertList = new ArrayList<>(annotationPos.size());
        for (AnnotationPo annotationPo : annotationPos) {
            NotePo notePo = new NotePo(annotationPo);
            notePo.setId(null);
            notePo.setBookId(book.getId());
            if (!StringUtils.isEmpty(annotationPo.getNote())) {
                CommentPo commentPo = new CommentPo(annotationPo.getNote());
                commentMapper.insert(commentPo);
                notePo.setCommentId(commentPo.getId());
            }
            NotePo existNotePo = noteMapper.select(notePo);
            if (existNotePo == null) needInsertList.add(notePo);
        }
        if (!CollectionUtils.isEmpty(needInsertList)) noteMapper.insert(needInsertList);
    }

    @Override
    public List<ChapterNoteVo> getNotes(Integer bookId) {
        List<NoteDto> noteDtos = noteMapper.selectAll(bookId);
        return BeanConverter.toChapterNoteVo(noteDtos);
    }
}
