package com.tx.newmethod;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三：实现Callable接口
 *
 * 如何理解实现Callable接口比实现Runnable接口强大：
 * 1. call()有返回值
 * 2. call()可以抛出异常被外面的方法捕获
 * 3. call()支持泛型
 */

// 1. 创建一个类实现Callable接口
class NumThread implements Callable<Integer>{

    // 2. 重写call()
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=1;i<=100;i++) {
            if (i%2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args) {
        // 3. 创建一个Callable接口的实现类
        NumThread numThread = new NumThread();
        // 4. 创建一个FutureTask对象，将Callable接口的实现类当做参数传入FutureTask的构造器中
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        // 5. 将futureTack对象传入Thread构造器中，并start()
        // tips: futureTask是Runnable的一个实现类
        new Thread(futureTask).start();

        // 6. 获取call方法的返回值
        // get()的返回值记为FutureTask构造器中callable实现类重写的call()的返回值
        try {
            Integer o = futureTask.get();
            System.out.println("总和为"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
