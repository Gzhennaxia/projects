package com.gzhennaxia.demo;


import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author bo li
 * @date 2020-09-21 16:54
 */
public class GenericStack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * 因为 elements 是私有的，并且没有提供外界可访问的方法，
     * 外界无法改变 elements 的类型，elements中的类型就是
     * push 方法添加进来的类型 E，故这里的类型转换一定不会出现异常
     */
    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
//        if (size == 0)
//            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

//    // Corrected version of pop method (Page 27)
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // Eliminate obsolete reference
//        return result;
//    }

    public static void main(String[] args) {
        GenericStack stack = new GenericStack();

        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());

    }
}