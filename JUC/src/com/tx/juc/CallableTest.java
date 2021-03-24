package com.tx.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 实现Callable接口创建多线程的有点：
 * - 有返回值
 * - 支持泛型
 * - 可以抛异常
 *
 * 同一个Callable接口实现类对象中的call方法只被执行一次
 * 相当于缓存下来了
 */

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Callable接口....");
        return 1024;
    }
}
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new FutureTask<T>(new Callable<T)).start();
        // 创建FutureTask对象
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        // 创建线程，并启动
        new Thread(task,"线程1").start();

        System.out.println("main线程任务。。。。");
        // 获得返回值
        // get方法一般放在最后一行（get会阻塞）
        Integer integer = task.get();
        System.out.println(integer);

    }
}
