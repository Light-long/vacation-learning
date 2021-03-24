package com.tx.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * * CyclicBarrier的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，
 *  * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 *  * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。
 *  * 线程进入屏障通过CyclicBarrier的await()方法
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        Runnable barrierAction;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,
                ()-> System.out.println("*****召唤神龙******"));
        for (int i=1;i<=7;i++) {
            // lambda表达式中使用循环中的变量需要定义为final
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了第"+temp+"颗龙珠");
                try {
                    // 每await一次，计数器加一，到7的时候，执行定义好的方法
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
