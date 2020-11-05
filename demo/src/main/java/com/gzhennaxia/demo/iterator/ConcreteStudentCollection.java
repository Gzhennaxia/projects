package com.gzhennaxia.demo.iterator;

/**
 * @author bo li
 * @date 2020-11-04 17:40
 */
public class ConcreteStudentCollection extends StudentCollection {
    private Student[] students;

    public ConcreteStudentCollection(Student[] students) {
        this.students = students;
    }

    @Override
    StudentIterator createIterator() {
        return new ConcreteStudentIterator(students);
    }
}
