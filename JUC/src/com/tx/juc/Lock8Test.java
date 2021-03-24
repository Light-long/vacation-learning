package com.tx.juc;

/**
 * 总结：
 * - 普通同步方法 public synchronized void sendEmail(),锁的是当前对象this
 * - 静态同步方法 public static synchronized void sendEmail(),锁的是当前类Phone.class
 * - 对象锁和类锁，互不影响（类锁锁不了普通方法）
 */
public class Lock8Test {
}
