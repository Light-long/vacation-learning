package com.tx.coll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList,LinkedList,Vector三者的异同：
 * 同：都实现了List接口，存储数据的特点相同：有序，可重复
 * 异：1. ArrayList:- 线程不安全，效率高
 *                 - 底层是Object[] elementData
 *    2. LinkedList:- 底层使用双向链表
 *                  - 频繁增，删操作使用LinkedList，效率比ArrayList高
 *    3. Vector:- List接口的古老实现类
 *              - 线程安全，效率低
 *              - 底层使用Object[] elementData
 */
public class ListTest {

    /**
     * ArrayList源码分析：
     * - jdk7:1. ArrayList list = new ArrayList(); //底层创建了一个长度为10的Object[] elementData数组
     *        2. list.add(123); // elementData[0] = new Integer(123);
     *        ...
     *        3. list.add(11); //如果此次添加，导致底层elementData数组容量不够，则扩容；
     *        默认情况下，扩容为原来容量的1.5倍，同时将原有的数据复制到新的数组中，作为新的elementData
     *        tips: 建议使用带参构造函数，ArrayList list = new ArrayList(int capacity);减少扩容次数
     * - jdk8:ArrayList的变化
     *        1. ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}；并没有创建长度为10的数组
     *        2. list.add(123); // 第一次调用add时，才创建长度为10的Object[] elementData数组，并将数据add进去
     *        ...后续操作和jdk7一致
     * - 小结:- jdk7中ArrayList对象的创建类似于单例的饿汉式
     *       - jdk8中ArrayList对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存
     */
    @Test
    public void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        // IndexOutOfBoundsException
        list.add(3,12);
        System.out.println(list);
    }

    /**
     * LinkedList源码分析：
     * LinkedList list = new LinkedList();
     * 内部声明了Node类型的first，last，默认值为null
     * list.add(1);//将1封装到Node中，创建了Node对象
     *
     * Node的定义，体现了LinkedList的双向链表的说法
     * private static class Node<E> {
     *         E item;
     *         Node<E> next;
     *         Node<E> prev;
     *
     *         Node(Node<E> prev, E element, Node<E> next) {
     *             this.item = element;
     *             this.next = next;
     *             this.prev = prev;
     *         }
     *     }
     */
    @Test
    public void testLinkedList() {

    }

    /**
     * Vector源码分析：
     * 1. Vector v = new Vector();// 底层创建一个长度为10的Object[] elementData数组
     * 2. 线程安全
     * 3. 默认情况，扩容2倍
     */
    @Test
    public void testVector() {

    }
}
