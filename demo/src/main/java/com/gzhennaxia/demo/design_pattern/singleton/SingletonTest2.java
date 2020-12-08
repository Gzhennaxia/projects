package com.gzhennaxia.demo.design_pattern.singleton;

import java.io.*;

/**
 * @author bo li
 * @date 2020-10-22 17:01
 */
public class SingletonTest2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton1 instance = Singleton1.getInstance();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(instance);
        byte[] bytes = outputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Singleton1 instance1 = (Singleton1) objectInputStream.readObject();

        System.out.println(instance == instance1);
    }

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Singleton6 instance = Singleton6.INSTANCE;
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(instance);
//        byte[] bytes = outputStream.toByteArray();
//
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        Singleton6 instance1 = (Singleton6) objectInputStream.readObject();
//
//        System.out.println(instance == instance1);
//    }


//    public enum Fruit {
//        APPLE, BANANA, WATERMELON;
//        private int value;
//
//        private Fruit() {//默认构造器
//            this.value = 0;
//        }
//
//        private Fruit(int value) {//带参数的构造器
//            this.value = value;
//        }
//    }


//    public final class Fruit extends Enum {
//        //3个枚举成员实例
//        public static final Fruit APPLE;
//        public static final Fruit BANANA;
//        public static final Fruit WATERMELON;
//        private int value;
//        //普通变量
//        private static final Fruit ENUM$VALUES[];//存储枚举常量的枚举数组
//
//        static {
//            //静态域，初始化枚举常量，枚举数组
//            APPLE = new Fruit("APPLE", 0);
//            BANANA = new Fruit("BANANA", 1);
//            WATERMELON = new Fruit("WATERMELON", 2);
//            ENUM$VALUES = (new Fruit[]{APPLE, BANANA, WATERMELON});
//        }
//
//        private Fruit(String s, int i) {
//            //编译器改造了默认构造器
//            super(s, i);
//            value = 0;
//        }
//
//        private Fruit(String s, int i, int value) {
//            //编译器改造了带参数的构造器
//            super(s, i);
//            this.value = value;
//        }
//
//        public static Fruit[] values() {
//            //编译器添加了静态方法values()
//            Fruit afruit[];
//            int i;
//            Fruit afruit1[];
//            System.arraycopy(afruit = ENUM$VALUES, 0, afruit1 = new Fruit[i = afruit.length], 0, i);
//            return afruit1;
//        }
//
//        public static Fruit valueOf(String s) {
//            //编译器添加了静态方法valueOf()
//            return (Fruit) Enum.valueOf(Test_2018_1_16 / Fruit, s);
//        }
//    }
}
