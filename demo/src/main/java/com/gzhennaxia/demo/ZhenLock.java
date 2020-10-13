package com.gzhennaxia.demo;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author bo li
 * @date 2020-10-13 15:09
 */
public class ZhenLock implements Lock {

    volatile AtomicReference<Thread> owner = new AtomicReference<>();

    LinkedBlockingQueue<Thread> waiter = new LinkedBlockingQueue<Thread>();

    @Override
    public void lock() {
        boolean needAdd = true;
        while (!tryLock()) {
            if (needAdd) {
                waiter.offer(Thread.currentThread());
                needAdd = false;
            }
            LockSupport.park();
        }
        waiter.remove(Thread.currentThread());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return owner.compareAndSet(null, Thread.currentThread());
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        while (owner.compareAndSet(Thread.currentThread(), null)) { // 释放成功
            // 通知等待者
            for (Thread thread : waiter) {
                LockSupport.unpark(thread);
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
