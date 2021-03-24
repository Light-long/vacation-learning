package com.tx;

/**
 * 创建3个买票线程，总票数100张，使用实现Runnable接口的方法
 * 此类只实现了多线程买票，但是没有解决线程同步问题(重票)
 * tips:线程安全问题待解决
 */

class Window implements Runnable {
    private int ticketNumber = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNumber > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出第"+ticketNumber+"张票");
                ticketNumber--;
            } else {
                break;
            }
        }
    }
}

public class SaleTicketByMultiThread1 {
    public static void main(String[] args) {
        // 创建一个实现类对象
        Window window = new Window();

        // 创建3个线程,共用同一个实现类对象
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        // 给3个线程设置名字
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
