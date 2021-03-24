package com.tx.juc.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTack extends RecursiveTask<Integer> {

    // 小于10时计算
    private static final Integer ADJUST_VALUE = 10;

    private int begin;
    private int end;
    private int result;

    public MyTack(int begin,int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end-begin) <= ADJUST_VALUE) {
            for(int i=begin;i<=end;i++) {
                result += i;
            }
        } else {
            int middle = (begin+end)/2;
            MyTack task1 = new MyTack(begin,middle);
            MyTack task2 = new MyTack(middle+1,end);
            // 开始执行任务
            task1.fork();
            task2.fork();
            // 合并结果
            result = task1.join()+task2.join();
        }
        return result;
    }
}
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTack tack = new MyTack(0,100);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 提交任务
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(tack);
        // 获取结果
        Integer integer = forkJoinTask.get();
        System.out.println(integer);
        // 关闭池子
        forkJoinPool.shutdown();
    }
}
