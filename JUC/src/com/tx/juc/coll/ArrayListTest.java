package com.tx.juc.coll;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * ArrayList线程不安全：
 *- 在多线程情况下会出现，java.util.ConcurrentModificationException
 * 解决方法：
 * - Vector
 * - Collections.synchronizedList(new ArrayList<>())
 * - CopyOnWriteArrayList
 *
 * 写时复制：
 * - add时，先加锁，使用Arrays.copyOf(elements,len+1)
 * - 将原有的数据复制到新的Object[] newElements中
 * - 新的数组Object[] newElements,长度为原来的+1
 * - 添加元素后，释放锁
 */
public class ArrayListTest {
    public static void main(String[] args) {

    }
}
