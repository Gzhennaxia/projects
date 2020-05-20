package com.gzhennaxia.ebook.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author bo li
 * @date 2020-05-19 17:58
 */
@Data
public class NoteDto {

    private Integer id;
    private Integer type;
    private String selectedText;
    private String representativeText;
    private String location;
    private Integer color;
    private String comment;
    private Date createTime;

    private Integer chapterId;
    private Integer chapterParentId;
    private Integer chapterName;
}
