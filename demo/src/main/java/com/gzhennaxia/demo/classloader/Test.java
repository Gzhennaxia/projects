package com.gzhennaxia.demo.classloader;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;
import java.util.HashMap;

/**
 * @author bo li
 * @date 2020-11-02 10:59
 */
public class Test {

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
            new HashMap<>();
        }
    }
}
