package com.gzhennaxia.demo.decorator;

/**
 * @author bo li
 * @date 2020-11-03 19:29
 */
public class Client {
    public static void main(String[] args) {
        Shape shape = new RedShapeDecorator(new Rectangle());
        shape.draw();

        shape = new GreenShapeDecorator(new Rectangle());
        shape.draw();

        shape = new RedShapeDecorator(new Circle());
        shape.draw();

        shape = new GreenShapeDecorator(new Circle());
        shape.draw();
    }
}
