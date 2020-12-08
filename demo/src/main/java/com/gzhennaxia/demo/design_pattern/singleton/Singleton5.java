package com.gzhennaxia.demo.design_pattern.singleton;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public class Singleton5 {

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static Singleton5 instance = new Singleton5();
    }
}