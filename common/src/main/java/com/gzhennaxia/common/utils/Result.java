package com.gzhennaxia.common.utils;

import com.gzhennaxia.common.enums.CodeEnum;
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

    private Result(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public static Result success() {
        return new Result(CodeEnum.SUCCESS);
    }

    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }
}
