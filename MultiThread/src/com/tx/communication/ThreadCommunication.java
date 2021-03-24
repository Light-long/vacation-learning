package com.tx.communication;

/**
 * 线程通信：两个线程交替打印1-100的数字
 * 涉及到的方法：
 * 1. wait(): 当前线程进入阻塞状态，自动释放锁
 * 2. notify(): 唤醒被wait()的一个线程
 * 3. notifyAll(): 唤醒所有线程
 *
 * tips:
 * 1. wait(),notify(),notifyAll()，这三个方法只能用在同步代码块或同步方法中
 * 2. wait(),notify(),notifyAll(),三个方法的调用者，必须是同步代码块或同步方法中的同步监视器
 * 3. wait(),notify(),notifyAll(),定义在java.lang.Object类中
 *
 * 面试题：sleep()和wait()的异同：
 * 同: 1. 一旦执行方法，都可以让线程进入阻塞状态
 * 异：1. 两个方法的声明位置不同：sleep()在Thread中声明，wait()在Object中声明
 *    2. 两个方法调用的要求不同：sleep()可以在任何需要的场景中调用，wait()必须在同步代码块或方法中调用
 *    3. 都用在同步代码块中，sleep()不释放同步监视器，wait()释放同步监视器
 */

class Number1 implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized (this) {

                // 唤醒另一个线程
                this.notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                } else {
                    break;
                }

                // 线程等待
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        Number1 number = new Number1();

        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();
    }
}
