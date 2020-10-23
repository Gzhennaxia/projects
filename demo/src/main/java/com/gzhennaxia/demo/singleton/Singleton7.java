package com.gzhennaxia.demo.singleton;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public enum Singleton7 {
    INSTANCE;

    private static int aaa;

    private Singleton7() {
        aaa = 1;
    }

    public static Singleton7 getInstance() {
        return INSTANCE;
    }

}