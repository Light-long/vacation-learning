package com.tx.juc.util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  在信号量上我们定义两种操作：
 *  * acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），
 *  * 要么一直等下去，直到有线程释放信号量，或超时。
 *  * release（释放）实际上会将信号量的值加1，然后 唤醒等待的线程。
 *  * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 同一时间只允许进来3个
        Semaphore semaphore = new Semaphore(3);

        for (int i=1;i<=6;i++) {
            new Thread(()->{
                try {
                    // 首先获取信号量
                    semaphore.acquire();
                    // 执行操作
                    System.out.println(Thread.currentThread().getName()+"抢占了停车位");
                    TimeUnit.SECONDS.sleep(3);
                    // 释放信号量
                    System.out.println(Thread.currentThread().getName()+"离开了停车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 出现异常也要释放信号量
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
