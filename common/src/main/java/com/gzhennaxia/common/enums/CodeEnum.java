package com.gzhennaxia.common.enums;

import lombok.Getter;

/**
 * @author bo li
 * @date 2020-05-06 19:40
 */
@Getter
public enum CodeEnum {

    SUCCESS(2000, "SUCCESS");

    private Integer code;

    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
