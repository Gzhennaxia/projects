package com.gzhennaxia.demo;


import com.sun.tools.javac.util.List;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author bo li
 * @date 2020-09-29 16:26
 */
public class Test {

    public static void main(String[] args) {
//        GenericStack<String> stack = new GenericStack();
//
//        Object[] elements = stack.getElements();
//        elements = new Integer[]{0};
//
////        for (String arg : args)
////            stack.push(arg);
//
//        String s = stack.pop();
//
////        while (true)
////            System.err.println(stack.pop());

//        GenericStack2 a = new GenericStack2<String>();

//        String[] attributes = pickTwo("Good", "Fast", "Cheaf");

        Object[] objects = {"b"};
        String[] strings = {"a"};
//
        strings = (String[]) objects;
//
        objects = strings;

    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    static <T> T[] toArray(T... args) {
        return args;
    }
}
