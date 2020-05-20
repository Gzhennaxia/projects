package com.gzhennaxia.ebook.po;

import lombok.Data;

/**
 * @author bo li
 * @date 2020-05-20 11:35
 */
@Data
public class CommentPo {
    private Integer id;
    private String comment;

    public CommentPo(String comment) {
        this.comment = comment;
    }

}
