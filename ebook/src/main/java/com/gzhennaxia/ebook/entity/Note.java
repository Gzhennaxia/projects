package com.gzhennaxia.ebook.entity;

import lombok.Data;

/**
 * @author bo li
 * @date 2020-05-20 10:51
 */
@Data
public class Note {

    private Integer id;
    private Integer bookId;
    private Integer type;
    private String selectedText;
    private String representativeText;
    private String location;
    private Integer commentId;
    private Integer color;
}
