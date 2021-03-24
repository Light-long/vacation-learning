package com.tx.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建3个线程，分别打印5次A,10次B,15次C
 * 线程1--> 线程2 --> 线程3的顺序
 *
 * - 线程操作（资源类中可以调用的方法）资源类
 * - 判断-干活-唤醒
 * - 多个线程交互，判断需要用while
 * - 顺序-->标志位
 */

class ShareResource {
    // 标志位
    private int flag = 1;
    // 锁
    private Lock lock = new ReentrantLock();
    // 需要3个condition(同一个锁的)
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    // 打印5次A
    public void printA() {
        lock.lock();
        try {
            // 判断
            if (flag != 1) {
                condition1.await();
            }
            // 干活
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+":"+"A");
            }
            // 唤醒 顺序的下一个
            // 标志位改为2
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            if (flag != 2) {
                condition2.await();
            }
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+":"+"B");
            }
            // 修改标志位，唤醒下一个
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            if (flag != 3) {
                condition3.await();
            }
            for (int i = 15; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+":"+"C");
            }
            // 修改标志位，唤醒下一个
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ConditionTest {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();

        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                sr.printA();
            }
        },"线程1").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                sr.printB();
            }
        },"线程2").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                sr.printC();
            }
        },"线程3").start();
    }
}
