package com.gzhennaxia.ebook.service.impl;

import com.gzhennaxia.ebook.dto.NoteDto;
import com.gzhennaxia.ebook.entity.Book;
import com.gzhennaxia.ebook.mapper.annotation.AnnotationMapper;
import com.gzhennaxia.ebook.mapper.primary.NoteMapper;
import com.gzhennaxia.ebook.service.BookService;
import com.gzhennaxia.ebook.service.NoteService;
import com.gzhennaxia.ebook.vo.ChapterNoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bo li
 * @date 2020-05-08 12:14
 */
@Service
public class QuoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private AnnotationMapper annotationMapper;

    @Autowired
    private BookService bookService;

    @Override
    public void sync(String assetId) {
        Book book = bookService.selectByAssetId(assetId);
        if (book == null) {
            book = bookService.sync(assetId);
        }
        // todo
    }

    @Override
    public List<ChapterNoteVo> getNotes(Integer bookId) {
        List<NoteDto> noteDtos = noteMapper.selectAll(bookId);
        return null;
    }
}
