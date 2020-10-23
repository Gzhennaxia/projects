package com.gzhennaxia.demo.singleton;

import java.io.Serializable;

/**
 * @author bo li
 * @date 2020-10-22 16:29
 */
public class Singleton1 implements Serializable {

    private static Singleton1 instance = new Singleton1();

    private static boolean invokedCons = false;

    private Singleton1() {
        if (invokedCons)
            throw new RuntimeException("单例构造器只能被调用一次！");
        invokedCons = true;
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}
