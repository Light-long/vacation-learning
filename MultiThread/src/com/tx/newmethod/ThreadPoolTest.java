package com.tx.newmethod;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：线程池
 * 好处：
 * 1. 提高响应速度，减少创建新线程时间
 * 2. 降低资源消耗
 * 3. 便于线程管理(ThreadPoolExecutor)
 *  - corePoolSize 核心池大小
 *  - maximumPoolSize 最大线程数
 *  - keepAliveTime 线程没有任务最多保持多久后结束
 *
 *  创建多线程有4种方式
 */
class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i=1;i<=100;i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class CallableTest1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=1;i<=100;i++) {
            if (i%2!=0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//         强制转换为子类对象(就可以设置线程数等等)
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) executorService;
//        executor.setCorePoolSize(5);
//        executor.setMaximumPoolSize();
        // 2. 执行指定的线程操作
        // 适用于Runnable
        executorService.execute(new RunnableTest());
        // 适用于Callable
        Future<Integer> future = executorService.submit(new CallableTest1());
        Integer i = null;
        try {
            i = future.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 3. 关闭连接池
        executorService.shutdown();
    }
}
