package com.tx.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程套路+模板
 * 1. 高内聚低耦合情况下，线程---操作（对外暴露的方法）---资源类
 */

class Ticket {
    private int ticketNum = 30;
    public int getTicketNum() {
        return ticketNum;
    }

    private Lock lock = new ReentrantLock();

    // 静态方法
    // public synchronized void saleTicket() {
    public void saleTicket() {
        // 加锁
        lock.lock();
        try {
            if (ticketNum > 0) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+
                        "卖出了第"+ticketNum--+"张票，还剩"+ticketNum+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}
public class SaleTicket1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            while (ticket.getTicketNum() > 0) {
                ticket.saleTicket();
            }
        },"A").start();
        new Thread(()->{
            while (ticket.getTicketNum() > 0) {
                ticket.saleTicket();
            }
        },"B").start();
        new Thread(()->{
            while (ticket.getTicketNum() > 0) {
                ticket.saleTicket();
            }
        },"C").start();
    }
}
