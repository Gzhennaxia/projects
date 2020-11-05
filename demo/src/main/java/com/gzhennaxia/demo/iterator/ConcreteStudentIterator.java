package com.gzhennaxia.demo.iterator;

/**
 * @author bo li
 * @date 2020-11-04 17:53
 */
public class ConcreteStudentIterator implements StudentIterator {

    private Student[] students;
    private int position = 0;

    public ConcreteStudentIterator(Student[] students) {
        this.students = students;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public boolean hashNext() {
        return position < students.length;
    }

    @Override
    public Student next() {
        return students[position++];
    }
}
