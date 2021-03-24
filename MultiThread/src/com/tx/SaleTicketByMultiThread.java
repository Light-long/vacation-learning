package com.tx;

/**
 * 创建3个买票线程，总票数100张，使用继承Thread类的方法
 * 此类只实现了多线程买票，但是没有解决线程同步问题(重票)
 * tips:线程安全问题待解决
 */

class SaleTicket extends Thread{
    // 总票数为100
    private static int ticketNumber = 100;
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
public class SaleTicketByMultiThread {
    public static void main(String[] args) {
        // 创建3个买票线程
        SaleTicket window1 = new SaleTicket();
        SaleTicket window2 = new SaleTicket();
        SaleTicket window3 = new SaleTicket();

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
