package com.gzhennaxia.demo.design_pattern.singleton;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public class Singleton4 {

    private volatile static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}