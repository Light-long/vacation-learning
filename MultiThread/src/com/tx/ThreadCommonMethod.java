package com.tx;

/**
 * 测试Thread中的常用方法：
 * 1. start(): 启动当前线程，并调用run方法
 * 2. run(): 重写Thread中的run方法，将线程执行的操作声明在这
 * 3. currentThread(): 静态方法，返回执行当前执行的线程
 * 4. getName(): 获取当前线程的名字
 * 5. setName(): 设置当前线程的名字
 * 6. yield(): 主动释放CPU执行权，让所有线程重新抢占CPU（当前线程也能抢）
 * 7. join(): 在a线程(主线程)中调用b线程(newThread线程)的join()方法，
 *            a线程(主线程)会进入阻塞状态，直到b线程(newThread线程)执行完
 * 8. stop(): 已过时；执行此方法，强制结束当前线程；
 * 9. sleep(long millis): 线程进入休眠状态，休眠指定毫秒，期间处于阻塞状态，
 *                        结束后，需要重新等待CPU的调用
 * 10. isAlive(): 判断当前线程是否存活
 *
 * 线程的优先级：(优先级高的概率大，但并不意味着一定能抢占到)
 * 1. Thread.MAX_PRIORITY: 10
 *    Thread.NORM_PRIORITY: 5
 *    Thread.MIN_PRIORITY: 1
 * 2. 获取、设置优先级：
 *    获取线程优先级：getPriority()
 *    设置线程优先级：setPriority()
 */

// 创建一个线程
class NewThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            if (i%5 == 0) {
                Thread.yield();
            }
        }
    }
}

public class ThreadCommonMethod {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        // 设置线程名setName(),需要在开启线程之前
        newThread.setName("线程一");
        // 设置优先级
        newThread.setPriority(Thread.MIN_PRIORITY);
        newThread.start();

        // 给主线程设置名字
        Thread.currentThread().setName("主线程");
        // 设置优先级
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
//            if (i==20) {
//                try {
//                    // 在主线程中执行，newThread线程的join方法
//                    newThread.join();
//                } catch (InterruptedException e) {
//
//                }
//            }
        }
        System.out.println(newThread.isAlive());
    }
}
