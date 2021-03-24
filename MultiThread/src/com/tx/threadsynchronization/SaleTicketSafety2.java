package com.tx.threadsynchronization;

/**
 * extents Thread 创建线程
 * 同步方法解决线程安全问题
 */
class Window3 extends Thread{
    // 总票数为100
    private static int ticketNumber = 100;
    @Override
    public void run() {
        while (ticketNumber != 0) {
            saleTicket();
        }
    }
    // 同步方法（同步监视器为Window3.class类对象）
    private static synchronized void saleTicket() {
        if (ticketNumber > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖出第"+ticketNumber+"张票");
            ticketNumber--;
        }
    }
}
public class SaleTicketSafety2 {
    public static void main(String[] args) {
        // 创建3个买票线程
        Window3 window1 = new Window3();
        Window3 window2 = new Window3();
        Window3 window3 = new Window3();

        // 给线程设置名字
        window1.setName("买票窗口1");
        window2.setName("买票窗口2");
        window3.setName("买票窗口3");

        // 启动买票线程
        window1.start();
        window2.start();
        window3.start();
    }
}
