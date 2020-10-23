package com.gzhennaxia.demo.singleton;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}