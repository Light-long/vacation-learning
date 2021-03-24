package com.tx.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java中的对象，正常情况下，只能进行==或！=操作
 * 但是在开发场景中，我们需要对多个对象进行比较
 * - Comparable: 自然排序
 * - Comparator: 定制排序
 * Comparable和Comparator的比较：
 * 1. Comparable,让类实现这个接口，一旦指定，保证这个实现类对象在任何位置都可以比较大小
 * 2. Comparator,临时性比较，
 */
public class CompareTest {

    /**
     * Comparable接口使用举例
     * 1. 像String，包装类等实现了Comparable接口，重写了CompareTo(obj)方法
     * 2. 默认是从小到大排序
     * 3. 自定义类，如果要排序，让自定义类实现Comparable接口，重写CompareTo(obj)方法
     */
    @Test
    public void test1() {
        String[] array = new String[]{"BB","AA","CC","MM","DD"};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() {
        Goods[] goods = new Goods[3];
        goods[0] = new Goods("huawei",3000);
        goods[1] = new Goods("lenovo",2000);
        goods[2] = new Goods("apple",5000);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /**
     * Comparator
     * 适用于：没有实现Comparable接口又不方便修改代码
     * 1. 重写Compare(Object o1,Object o2),比较o1,o2的大小
     */
    @Test
    public void test3() {
        String[] array = new String[]{"BB","AA","CC","MM","DD"};
        // 字符串从大到小
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test4() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("huawei",3000);
        goods[1] = new Goods("lenovo",2000);
        goods[2] = new Goods("apple",5000);
        goods[3] = new Goods("honor",3000);
        Arrays.sort(goods, (o1, o2) -> {
            // 名称从低到高
            if (o1.getName().equals(o2.getName())) {
                // 价格从高到低
                return -Double.compare(o1.getPrice(),o2.getPrice());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
