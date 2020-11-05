package com.gzhennaxia.demo.decorator;

/**
 * @author bo li
 * @date 2020-11-03 19:23
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.print("Shape: circle\t");
    }
}
