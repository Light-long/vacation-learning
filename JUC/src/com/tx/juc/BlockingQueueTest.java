package com.tx.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        // 需要传一个int capacity
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // 抛异常的3个方法  add(E e)，remove()，element()（取队头元素）
        // 特殊值   offer(E e) 满了返回false，poll()--没有元素返回null，peek()--null
        // 阻塞 put()--队满是阻塞，take()--队空时阻塞

    }
}
