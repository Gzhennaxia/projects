package com.gzhennaxia.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author bo li
 * @date 2020-10-13 19:30
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + finalI + "执行结束");
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
            System.out.println("主线程等待10个线程执行完后再往下执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
