package com.tx.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：写时只能有一个线程，读时可以有多个线程
 */
// 资源类
class MyCache {
    private volatile Map<String, String> map = new HashMap<>();
    // 创建读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String value) {
        // 写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始写入数据------"+key);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入数据成功-------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始读取数据");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取数据成功"+s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        // 写操作
        for(int i=1;i<=5;i++) {
            final int temp = i;
            new Thread(()->{
                cache.put(String.valueOf(temp),String.valueOf(temp));
            },String.valueOf(i)).start();
        }
        // 读操作
        for(int i=1;i<=5;i++) {
            final int temp = i;
            new Thread(()->{
                cache.get(String.valueOf(temp));
            },String.valueOf(i)).start();
        }


    }
}
