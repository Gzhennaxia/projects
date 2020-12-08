package com.gzhennaxia.demo.design_pattern.singleton;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
