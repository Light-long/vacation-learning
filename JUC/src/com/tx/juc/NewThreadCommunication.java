package com.tx.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信：
 * Lock---synchronized
 * condition.await()---this.wait()
 * condition.signal()---this.notify()
 * condition.signalAll()---this.notifyAll()
 */
class Number1 {
    private int number = 0;
    // 创建锁对象
    private final Lock lock = new ReentrantLock();
    // 创建condition对象
    private final Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                // 等待 this.wait()
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName()+":"+number);
            // 唤醒 this.notifyAll()
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrease() {
        lock.lock();
        try {
            // 判断
            while (number == 0) {
                // 等待 this.wait()
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName()+":"+number);
            // 唤醒 this.notifyAll()
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class NewThreadCommunication {
    public static void main(String[] args) {
        Number1 number = new Number1();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                number.increase();
            }
        },"生产者1").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                number.decrease();
            }
        },"消费者1").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                number.increase();
            }
        },"生产者2").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                number.decrease();
            }
        },"消费者2").start();
    }
}
