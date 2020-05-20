package com.gzhennaxia.ebook.vo;

import com.gzhennaxia.ebook.dto.NoteDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author bo li
 * @date 2020-05-19 17:47
 */
@Data
public class NoteVo {

    private Integer id;
    private String contentBefore;
    private String contentMiddle;
    private String contentAfter;
    private Integer type;
    private Integer color;
    private Date createTime;
    private String position;
    private String comment;

    public NoteVo(NoteDto noteDto) {
        BeanUtils.copyProperties(noteDto, this);
        String selectedText = noteDto.getSelectedText();
        String representativeText = noteDto.getRepresentativeText();
        int index = representativeText.indexOf(selectedText);
        this.contentBefore = representativeText.substring(0, index);
        this.contentMiddle = representativeText.substring(index, index + selectedText.length());
        this.contentAfter = representativeText.substring(index + selectedText.length());
        this.position = noteDto.getLocation();
    }

}
