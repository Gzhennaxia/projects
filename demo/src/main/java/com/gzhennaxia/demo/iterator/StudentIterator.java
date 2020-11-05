package com.gzhennaxia.demo.iterator;

/**
 * @author bo li
 * @date 2020-11-04 17:36
 */
public interface StudentIterator {
    boolean hashNext();

    Student next();

    int getPosition();
}
