package com.tx.juc;

/**
 * 线程通信：
 * - 线程操作资源类
 * - 判断（wait）-->干活-->通知
 * - 多线程交互中，防止多线程虚假唤醒（判断要用while，而不是if）
 * tips: wait被唤醒后，继续执行后面的代码，不进行判断了
 */

class Number {
    private int number = 0;

    public synchronized void increase() {
        // 判断
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName()+":"+number);
        // 唤醒
        this.notifyAll();
    }

    public synchronized void decrease() {
        // 判断(没有东西的时候需要等待)
        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName()+":"+number);
        // 唤醒
        this.notifyAll();
    }
}
public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        Number n = new Number();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                n.increase();
            }
        },"生产者1").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                n.decrease();
            }
        },"消费者1").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                n.increase();
            }
        },"生产者2").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                n.decrease();
            }
        },"消费者2").start();
    }
}
