package com.gzhennaxia.common.utils;

import com.gzhennaxia.common.enums.ResultEnum;
import lombok.Data;

/**
 * @author bo li
 * @date 2020-05-06 19:34
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result(ResultEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public static Result success() {
        return new Result(ResultEnum.SUCCESS);
    }
}
