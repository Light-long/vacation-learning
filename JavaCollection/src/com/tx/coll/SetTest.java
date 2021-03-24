package com.tx.coll;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Set接口的实现类：
 * - HashSet: 线程不安全，可以存储null
 * ---LinkedHashset: Hashset子类，遍历内部数据时，可以按照添加顺序遍历
 * - TreeSet: 可以按照添加对象的指定属性，进行排序
 *
 * 向set中添加的数据：
 * - 其所在类，一定要重写hashCode()方法和equals()方法
 * - 重写的方法尽可能保证一致性，相等的对象具有相同的hashCode值
 */
public class SetTest {

    /**
     * HashSet
     * 1. 无序性： 不等于随机性，存储的的数据在底层中，并非按照数组的索引顺序添加，而是根据数据的Hash值决定的
     * 2. 不可重复性：保证添加的元素按照equals方法判断时，不能返回true，即相同的元素只能添加一个
     *
     * 添加元素：
     * - 我们向HashSet添加元素a，首先调用a元素所在类的hashCode()方法，计算出元素a的hash值
     * - 然后用hash值通过某种算法，计算出a在HashSet底层数组中的存放位置（即为索引位置）
     * - 判断此位置上是否有元素？
     * --- 如果此位置没有其他元素，则元素a添加成功   -- 情况1
     * --- 如果此位置上已有其他元素b(或者以链表的形式存在多个元素)，则比较a与元素b(以及其他元素)的hash值：
     * ----- 如果hash值不相同，则元素a添加成功     -- 情况2
     * ----- 如果hash值相同，进而需要调用a的equals方法(a.equals(b))，和该位置元素一一比较
     * ------- equals()返回true，元素a添加失败
     * ------- equals()返回false，元素a添加成功  -- 情况3
     *
     * --- tips: 对于添加成功的情况2，3而言，与已经存在指定索引位置上数据以链表的方式存储
     * --- jdk7：头插法
     * --- jdk8：尾插法
     * --- 七上八下
     *
     * --- HashSet底层：数据+链表
     */
    @Test
    public void testHashSet() {

    }

    /**
     * LinkedHashSet:
     * - HashSet的子类，添加数据时，还维护了两个引用（指针），记录此数据的前一个数据和后一个数据
     * - 对于 频繁遍历的操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void testLinkedHashSet() {

    }

    /**
     * TreeSet:
     * - 向TreeSet中添加的数据，要求是相同类的对象
     * - 两种排序方式，自然排序，定制排序
     * - 自然排序中，比较两个对象是否相同的标准为CompareTo(),而不是equals()
     */
    @Test
    public void testTreeSet() {
        // 自然排序
        TreeSet<User> set = new TreeSet<>();
        set.add(new User("kiki",20));
        set.add(new User("lishilong",21));
        set.add(new User("lala",25));
        set.add(new User("lishilong",23));
        set.add(new User("dandan",23));
        for (User user : set) {
            System.out.println(user);
        }

        System.out.println("定制排序");
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        };
        TreeSet<User> set2 = new TreeSet<>(comparator);
        set2.add(new User("kiki",20));
        set2.add(new User("lishilong",21));
        set2.add(new User("lala",25));
        set2.add(new User("lishilong",23));
        set2.add(new User("dandan",23));
        System.out.println(set2);
    }

}
