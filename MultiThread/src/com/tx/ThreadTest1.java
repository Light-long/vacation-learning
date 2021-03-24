package com.tx;

/**
 * 创建线程的方式2：实现Runnable接口
 * 1. 创建一个类实现Runnable接口
 * 2. 重写Runnable接口的run()方法
 * 3. 创建实现类对象
 * 4. 将实现类对象传递到Thread类的构造器中，创建Thread类对象
 * 5. 执行start()方法
 * tips: start()方法->启动线程；调用当前线程的run方法-->调用Runnable类型的target的run
 *
 * 两种线程创建方式的比较：
 * 开发中，优先选择：实现Runnable接口的方式
 * 原因 1. 实现的方式没有Java类单继承的局限性
 *     2. 实现的方式更适合处理多个线程有共享数据的情况
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run()方法，将线程要声明的逻辑写在run()中
 */

// 1. 创建一个类实现Runnable接口
class MThread implements Runnable {
    // 2. 重写Runnable接口的run()方法
    @Override
    public void run() {
        for (int i = 100; i > 0; i--) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        // 3. 创建实现类对象
        MThread mThread = new MThread();
        // 4. 将实现类对象传递到Thread类的构造器中，创建Thread类对象
        // 5. 通过Thread类的对象执行start()方法
        new Thread(mThread).start();

        // 再创建一个线程执行(共用一个Runnable接口的实现类)
        new Thread(mThread).start();
    }
}
