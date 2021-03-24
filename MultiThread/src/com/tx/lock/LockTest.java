package com.tx.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全方式三：Lock锁
 *
 * synchronized 和 Lock的异同：
 * 同：都可以解决线程安全问题
 * 异：1. synchronized 在执行完相应的代码后，是自动的释放锁
 *       Lock需要手动启动同步（lock），手动释放锁（unlock）
 */

class Window4 implements Runnable {
    private int ticketNum = 100;

    // 创建一个锁对象
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                // 锁
                lock.lock();
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName()+"卖出了第："+ticketNum+"张票");
                    ticketNum--;
                } else {
                    break;
                }
            } finally {
                // 解锁
                lock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window4 window = new Window4();

        new Thread(window).start();
        new Thread(window).start();
    }
}
