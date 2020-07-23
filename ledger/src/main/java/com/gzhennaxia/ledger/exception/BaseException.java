package com.gzhennaxia.ledger.exception;

/**
 * @author bo li
 * @date 2020-07-22 14:41
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super("[LEDGER]" + message);
    }
}
