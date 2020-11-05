package com.gzhennaxia.demo.decorator;

/**
 * @author bo li
 * @date 2020-11-03 19:26
 */
public class GreenShapeDecorator extends ShapeDecorator {
    public GreenShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        System.out.println("Color: green");
    }
}
