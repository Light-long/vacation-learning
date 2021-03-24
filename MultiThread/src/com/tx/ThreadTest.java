package com.tx;

/**
 * 创建多线程的方法 1：继承Thread类
 * 1. 继承Thread类
 * 2. 重写run()方法
 * 3. 创建Thread类的子类对象
 * 4. 调用start（启动该线程，执行run方法）
 * tips:如果直接调用run方法，不会创建多线程
 *      一个线程对象只能start一次；
 */

// 继承Thread类
class MyThread extends Thread{
    // 重写run方法
    @Override
    public void run() {
        for (int i=0;i<=100;i++) {
            System.out.println(i+Thread.currentThread().getName());
        }
    }
}
public class ThreadTest {

    public static void main(String[] args) {
        // 创建Thread类的子类对象
        // 调用start方法
        new MyThread().start();

        // 主线程方法
        for (int i=0;i<=100;i++) {
            System.out.println(i+Thread.currentThread().getName());
        }
    }
}
