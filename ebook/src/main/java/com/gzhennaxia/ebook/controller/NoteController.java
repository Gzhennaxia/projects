package com.gzhennaxia.ebook.controller;

import com.gzhennaxia.common.utils.Result;
import com.gzhennaxia.ebook.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bo li
 * @date 2020-05-08 12:14
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/sync/{assetId}")
    public Result sync(@PathVariable String assetId) {
        noteService.sync(assetId);
        return Result.success();
    }

    @GetMapping("/all/{bookId}")
    public Result getNotes(@PathVariable Integer bookId) {
        return Result.success(noteService.getNotes(bookId));
    }
}
