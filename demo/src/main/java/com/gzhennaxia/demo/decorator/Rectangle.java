package com.gzhennaxia.demo.decorator;

/**
 * @author bo li
 * @date 2020-11-03 19:23
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.print("Shape: rectangle\t");
    }
}
