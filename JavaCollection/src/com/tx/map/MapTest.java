package com.tx.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Map接口：存储key-value
 * - HashMap: Map的主要实现类，线程不安全，效率高；可以存储null值的key和value
 * --- LinkedHashMap: 遍历Map时，可以按照添加顺序遍历
 *                  - 在HashMap底层的基础上，添加了一对指针，指向前一个元素和后一个元素
 *                  - 对于频繁的遍历操作，效率高于HashMap
 * - TreeMap: 可以按照添加的key-value进行排序，实现排序遍历（按照key排序）
 *            - 底层是红黑树
 * - Hashtable: Map的古老实现类，线程安全，效率低；不可以存储null值的key or value
 * --- Properties: 常用来处理配置文件，String=String
 *
 * Map结构的理解：
 * - Map中的key：无序的，不可重复的；使用Set存储所有的key； key所在的类要重写equals()和hashCode()
 * - Map中的value：无序，可重复，使用collection存储； value所在的类要重写equals()
 * - 一个key-value键值对构成一个Entry对象
 * - Map中的entry：无序的，不可重复的，使用set存储所有的entry
 */
public class MapTest {

    /**
     * HashMap的底层原理：（jdk7）
     * HashMap map = new HashMap();
     * 此次实例化以后，底层创建了一个长度为16的Entry[] table数组
     * map.put(key,value);
     * - 首先，调用key所在类的hasCode()计算出key的hash值，然后根据某处算法，计算出在Entry数组总存放的位置
     * - 如果此位置数据为空，则key-value添加成功
     * - 如果此位置数据不为空，(意味着此位置上已经存在一个或多个(以链表形式存在)的数据)，比较key和已经存在的数据的hash值
     * --- 如果key的hash值与已经存在的所有数据的hash值都不同：此时（key，value）添加成功
     * --- 如果key的hash值与某一个数据（key1，value1）的hash值都相同，继续判断，调用key所在类的equals方法(key.equals(key1))
     * ----- 如果equals()返回false，则(key，value)添加成功
     * ----- 如果equals()返回true，则用value1替换value（新value替换旧value）
     *
     * 补充：多个数据在一个索引位置是，以链表的形式存储
     * 扩容：超出threshold（且要存放的位置非空），默认扩容为原来的2倍，然后将原有的数据复制过来
     *
     * jdk8相比于jdk7底层的不同：
     * - new HashMap(); // 底层没有创建长度为16的数组
     * - 底层数组是Node<K,V>[] (int hash,K key,V value,Node<K,V> next),而非Entry[]
     * - 首次调用put()是，调用扩容，底层创建一个长度为16的Node[]
     * - jdk7底层只有：数组+链表 jdk8：数组+链表+红黑树
     * --- 当数组某一索引位置上元素以链表形式存在的数据个数>8 并且 当前数组长度>64时
     * ----- <64时，扩容
     * --- 此索引位置的所有数据改为红黑树存储
     *
     * threshold = DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR = 16*0.75=12
     */
    @Test
    public void testHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"lishilong");
        map.put(2,"dandan");
        map.put(3,"kiki");
        Set<Entry<Integer, String>> entrySet = map.entrySet();
        for (Entry<Integer,String> entry : entrySet) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("-------------------------");
        entrySet.forEach(System.out::println);
    }
}
