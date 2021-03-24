package com.tx.juc.pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * 核心类：ThreadPoolExecutor
 * 七大参数：
 * int corePoolSize,                  -- 常驻核心线程数
 * int maximumPoolSize,               -- 线程池中能够容纳同时执行的最大线程数，此值必须大于等于1
 * long keepAliveTime, (保留时间)             -- 多余的空闲线程的存活时间
 *                                    -- 当前池中线程数量超过corePoolSize时
 *                                    -- 当空闲时间达到keepAliveTime时，多余线程会被销毁直到只剩下corePoolSize个线程为止
 * TimeUnit unit,                     -- keepAliveTime的单位
 * BlockingQueue<Runnable> workQueue, -- 任务队列，被提交但尚未被执行的任务
 * ThreadFactory threadFactory,       -- 表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认的即可
 * RejectedExecutionHandler handler)  -- 拒绝策略，表示当队列满了，并且工作线程大于等于线程池的最大线程数（maximumPoolSize）时
 *                                    -- 如何来拒绝请求执行的runnable的策略
 *
 * 四种拒绝策略：
 * AbortPolicy: 直接抛出RejectedExecutionException异常阻止系统正常运行
 * CallerRunsPolicy: 该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。(交给main线程执行)
 * DiscardPolicy: 该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种策略。
 * DiscardOldestPolicy: 抛弃队列中等待最久的任务，然后把当前任务加人队列中尝试再次提交当前任务。
 *
 * IO密集型任务：maxPoolSize = Runtime.getRuntime().availableProcess()+1
 */
public class ThreadPoolTest {
    
    @Test
    public void test1() {
        // 固定线程数的线程池
        // ExecutorService threadPool1 = Executors.newFixedThreadPool(6);
        // 单个线程的线程池
        // ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        // n个线程数的线程池，可以根据线程数伸缩
        // ExecutorService threadPool3 = Executors.newCachedThreadPool();

        // 自定义创建线程池
        ExecutorService threadPoll = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            for (int i=1;i<=10;i++) {
                threadPoll.execute(()-> System.out.println(Thread.currentThread().getName()+"办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoll.shutdown();
        }
    }
}
