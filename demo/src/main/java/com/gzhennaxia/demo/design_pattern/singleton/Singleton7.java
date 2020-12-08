package com.gzhennaxia.demo.design_pattern.singleton;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public enum Singleton7 {
    INSTANCE;


    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        return INSTANCE;
    }

}