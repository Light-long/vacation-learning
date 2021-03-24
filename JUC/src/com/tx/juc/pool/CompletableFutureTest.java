package com.tx.juc.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;

/**
 * 异步回调
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception{
        // 没有返回值的
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t update mysql ok");
        });
        // 获取执行结果
        voidCompletableFuture.get();

        // 有返回值的异步回调
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t insert into ok");
            // 人造异常
//            int i = 10/0;
            return 1024;
        });
        // 调用返回值
        System.out.println(integerCompletableFuture
                .whenComplete((t, u) -> {
                    // 返回值
                    System.out.println("t:" + t);
                    // 异常
                    System.out.println("u:" + u);
                })
                .exceptionally((t) -> {
                    // 异常信息
                    System.out.println("t:" + t.getMessage());
                    return 404;
                }).get());

    }
}
