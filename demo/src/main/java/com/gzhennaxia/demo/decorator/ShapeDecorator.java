package com.gzhennaxia.demo.decorator;

/**
 * @author bo li
 * @date 2020-11-03 19:25
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }
}
