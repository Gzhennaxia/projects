package com.gzhennaxia.ebook.entity;

import lombok.Data;

/**
 * @author bo li
 * @date 2020-04-29 12:30
 */
@Data
public class Quote {

    private Integer id;
    private Integer bookId;
    private Integer type;
    private String selectedText;
    private String representativeText;
    private String location;
    private Integer commentId;
    private Integer color;

}
