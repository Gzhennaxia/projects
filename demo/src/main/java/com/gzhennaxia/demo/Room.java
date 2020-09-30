package com.gzhennaxia.demo;


/**
 * @author bo li
 * @date 2020-09-22 17:52
 */
// An autocloseable class using a cleaner as a safety net (Page 32)
class Room {

    public static final String[] name = new String[2];

    public Room() {

    }

    public void fun(){
        name[0]="ss";
        name[2]="ss";
    }
}