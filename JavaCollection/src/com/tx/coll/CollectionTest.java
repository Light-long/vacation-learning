package com.tx.coll;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合框架：
 * - Collection接口: 单列集合，用来存储一个一个的对象
 * --- List接口：有序，可重复 -->动态数组
 * ----- ArrayList，LinkedList，Vector
 * --- Set接口：无序，不可重复
 * ----- HashSet，LinkedHashSet，TreeSet
 * - Map接口：双列结合，用来存储一对（key-value）一对的数据
 * --- HashMap，LinkedHashMap,TreeMap,HashTable,Properties
 *
 * iterator:
 * 集合每次调用iterator都会生成一个新的iterator对象
 *
 * foreach：只能遍历，不能赋值
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add(new String("aa"));
        // 把每个元素都设置为null，然后size=0
        coll.clear();

        // contains()默认调用equals比较

    }
}
