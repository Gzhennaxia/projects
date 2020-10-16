package com.gzhennaxia.demo.fork_join;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * @author bo li
 * @date 2020-10-16 10:37
 */
public class Demo {

    public static void main(String[] args) {
        // 创建200000000个随机数组成的数组:
        long[] ints = new long[200000000];
        Random random = new Random();
        long sum = 0;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(200000000);
        }
        long l = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(l1);

        System.out.println("for sum: result = " + sum + " in " + (l1 - l) + "ms");


    }

    class SumTask extends RecursiveTask<Long> {

        int THRESHOLD = 500;
        long[] array;
        int start;
        int end;

        public SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start < THRESHOLD) {
                long result = 0;
                for (int i = start; i < end; i++) {
                    result += array[i];
                }
                return result;
            }

            int m = (start + end) / 2;
            SumTask sumTask = new SumTask(array, 0, m);
            SumTask sumTask1 = new SumTask(array, m + 1, end);
            invokeAll(sumTask, sumTask1);
            Long join = sumTask.join();
            Long join1 = sumTask1.join();
            return join + join1;
        }
    }
}
