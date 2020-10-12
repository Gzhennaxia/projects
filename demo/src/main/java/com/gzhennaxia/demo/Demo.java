package com.gzhennaxia.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author bo li
 * @date 2020-10-12 16:44
 */
public class Demo {

    private int value;
    private static Unsafe unsafe;
    private static long offset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            offset = unsafe.objectFieldOffset(Demo.class.getDeclaredField("value"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void inc() {
        value++;
    }

    public void incCAS() {
        int current;
        do {
            current = unsafe.getIntVolatile(this, offset);
        } while (!unsafe.compareAndSwapInt(this, offset, current, current + 1));
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo10 = new Demo();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
//                    demo10.inc();
                    demo10.incCAS();
                }
            }).start();
        }
        Thread.sleep(2000L);
        System.out.println(demo10.value);
    }
}
