package com.gzhennaxia.demo.iterator;

/**
 * @author bo li
 * @date 2020-11-04 17:58
 */
public class Client {
    public static void main(String[] args) {
        StudentCollection studentCollection = new ConcreteStudentCollection(new Student[]{new Student("张三"), new Student("李四")});
        StudentIterator iterator = studentCollection.createIterator();
        while (iterator.hashNext()) {
            Student student = iterator.next();
            System.out.println("我是" + iterator.getPosition() + "号：" + student.getName());
        }
    }
}
