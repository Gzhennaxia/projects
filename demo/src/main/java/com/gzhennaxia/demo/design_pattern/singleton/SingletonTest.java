package com.gzhennaxia.demo.design_pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author bo li
 * @date 2020-10-22 17:01
 */
public class SingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test66();
//        test7();

    }

    private static void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton1 instance = Singleton1.getInstance();

        Constructor<Singleton1> declaredConstructor = Singleton1.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton1 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }

    private static void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton2 instance = Singleton2.getInstance();

        Constructor<Singleton2> declaredConstructor = Singleton2.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton2 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }

    private static void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton3 instance = Singleton3.getInstance();

        Constructor<Singleton3> declaredConstructor = Singleton3.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton3 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }

    private static void test4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton4 instance = Singleton4.getInstance();

        Constructor<Singleton4> declaredConstructor = Singleton4.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton4 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }

    private static void test5() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton5 instance = Singleton5.getInstance();

        Constructor<Singleton5> declaredConstructor = Singleton5.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton5 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }

    private static void test6() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton6 instance = Singleton6.INSTANCE;

        Constructor<Singleton6> declaredConstructor = Singleton6.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton6 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }

    private static void test66() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton6 instance = Singleton6.INSTANCE;

        Constructor<Singleton6> declaredConstructor = Singleton6.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Singleton6 instance2 = declaredConstructor.newInstance("", 0);
        System.out.println(instance == instance2);
    }

    private static void test7() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton7 instance = Singleton7.getInstance();

        Constructor<Singleton7> declaredConstructor = Singleton7.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton7 instance2 = declaredConstructor.newInstance();
        System.out.println(instance == instance2);
    }
}
