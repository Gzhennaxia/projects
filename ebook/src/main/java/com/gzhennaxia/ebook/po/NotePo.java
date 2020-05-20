package com.gzhennaxia.ebook.po;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author bo li
 * @date 2020-05-20 11:51
 */
@Data
public class NotePo {

    private Integer id;
    private Integer bookId;
    private Integer chapterId;
    private Integer type;
    private String selectedText;
    private String representativeText;
    private String location;
    private Integer commentId;
    private Integer color;
    private Date createTime;

    public NotePo() {

    }

    public NotePo(AnnotationPo annotationPo) {
        BeanUtils.copyProperties(annotationPo, this);
        this.color = annotationPo.getStyleType();
        this.createTime = annotationPo.getCreateTime();
    }

}
