package com.gzhennaxia.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bo li
 * @date 2020-10-13 15:13
 */
public class ZhenLockTest {

    int value;

//    Lock lock = new ReentrantLock();
    Lock lock = new ZhenLock();


    public void inc() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZhenLockTest zhenLockTest = new ZhenLockTest();
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        zhenLockTest.inc();
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(zhenLockTest.value);
    }
}
