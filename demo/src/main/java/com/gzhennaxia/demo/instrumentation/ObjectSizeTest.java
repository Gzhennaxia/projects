package com.gzhennaxia.demo.instrumentation;

/**
 * @author bo li
 * @date 2020-09-17 14:03
 */
public class ObjectSizeTest {

    private int i1;
    private int i2;
    private byte b1;
    private byte b2;
    private byte b3;
    private String s;
    private Object obj;

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(ObjectShallowSize.sizeOf(new ObjectSizeTest()));
    }
}