package com.tx.threadsynchronization;

import javafx.beans.binding.When;
import javafx.stage.Window;

/**
 * 三个线程卖100张票-->Runnable
 * 问题：出现重票，错票-->线程不安全
 * 原因：当一个线程操作车票的过程中，尚未操作完成，其他线程参与进来，也同时操作
 * 解决办法：加锁，当线程a操作车票时，其他线程不能参与进来，知道线程a执行结束，即使线程a阻塞
 * 方式一：同步代码块
 *      synchronized(同步监视器) {
 *          // 需要被同步的代码
 *      }
 *      tips: 1. 操作共享数据的代码，为需要被同步的代码
 *            2. 共享数据：多个线程共同操作的变量，例如：ticket
 *            3. 同步监视器：锁，任何一个类的对象都可以充当锁
 *            4. 多个线程用同一个锁
 *            5. 建议使用当前对象
 *            6. 如果是extents Thread实现，则需要一个private static Object obj = new Object();
 *            7. 如果是extents Thread实现，也可以是synchronized(Window.class)，类对象是唯一的
 * 方式二：同步方法
 */

class SaleTicketWindow implements Runnable {
    private int ticketNumber = 100;
    // 多个线程必须共用同一个锁
//    final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 因为只有一个window对象，所以可以用this
            synchronized (this) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticketNumber >0) {
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticketNumber+"张票");
                    ticketNumber--;
                } else {
                    break;
                }
            }
        }
    }
}

public class SaleTicketSafety {
    public static void main(String[] args) {
        SaleTicketWindow window = new SaleTicketWindow();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        // 设置线程名
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
