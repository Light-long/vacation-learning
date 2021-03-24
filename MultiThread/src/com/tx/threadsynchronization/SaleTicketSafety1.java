package com.tx.threadsynchronization;

/**
 * 实现Runnable接口
 * 使用同步方法解决线程安全问题'
 *
 * 关于同步方法的总结：
 * 1. 同步方法任然用到同步监视器，只是不需要我们显示声明
 * 2. 非静态的同步方法，同步监视器-->this
 *    静态同步方法，同步监视器-->当前类本身(Window.class)
 */
class Window2 implements Runnable {
    private int ticketNumber = 100;
    @Override
    public void run() {
        while (ticketNumber != 0) {
            saleTicket();
        }
    }
    // 卖票的同步方法(同步监视器其实是-->this)
    private synchronized void saleTicket() {
        if (ticketNumber > 0) {
            System.out.println(Thread.currentThread().getName()+"卖出第"+ticketNumber+"张票");
            ticketNumber--;
        }
    }
}

public class SaleTicketSafety1 {
    public static void main(String[] args) {
        // 创建一个实现类对象
        Window2 window = new Window2();

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
