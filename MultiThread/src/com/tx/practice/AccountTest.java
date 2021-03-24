package com.tx.practice;

import java.util.concurrent.locks.ReentrantLock;

class Account {
    private double balance;

    private final ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    // 这个synchronized的同步监视器为this（account对象）
    // public synchronized void saveMoney(double atm)
    public void saveMoney(double atm) {
        if (atm > 0) {
            try {
                lock.lock();
                balance+=atm;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"存了1000，余额为"+balance);
            } finally {
                lock.unlock();
            }
        }
    }
}

class Customer implements Runnable{
    private Account account;
    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0;i<3;i++) {
            account.saveMoney(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        // 创建账户对象
        Account account = new Account(0d);
        // 创建用户实现类
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        // 创建线程
        Thread thread1 = new Thread(c1);
        Thread thread2 = new Thread(c2);
        // 设置名字
        thread1.setName("甲");
        thread2.setName("乙");
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
