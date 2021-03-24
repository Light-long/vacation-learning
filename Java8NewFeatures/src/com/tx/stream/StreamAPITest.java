package com.tx.stream;

import com.tx.methodreference.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream
 * 1. Stream关注的是数据的运算，与CPU打交道
 *    集合关注的是数据的存储，与内存打交道
 * 2.
 *  - Stream自己不会存储元素
 *  - Stream不会改变原对象，他会返回一个持有结果的心Stream
 *  - Stream的操作时延迟的，需要结果的时候才执行
 *
 * 3. Stream的执行流程
 *  - Stream的实例化
 *  - 一系列中间操作
 *  - 终止操作
 *
 * tips: 只有执行终止操作，Stream中间一系列操作链才会执行
 */
public class StreamAPITest {

    /**
     * 创建Stream流的方式
     */
    @Test
    public void test1() {
        // 1. 通过集合创建Stream
        List<String> list = new ArrayList<>();
        list.add("kiki");
        // 顺序流
        Stream<String> stream = list.stream();
        // 并行流
        Stream<String> parallelStream = list.parallelStream();

        // 2. 通过数组创建Stream
        int[] array = new int[] {1,2,3,4};
        // Arrays.stream(T[] t)
        IntStream intStream = Arrays.stream(array);

        // 3. 通过Stream.of(T... values)
        Stream<String> stringStream = Stream.of("lishilong", "kiki", "xuan");

        // 4.创建无限流
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
    }

    /**
     * 中间操作
     */
    @Test
    public void test2() {
        List<User> list = new ArrayList<>();
        list.add(new User("kiki",20));
        list.add(new User("lishilong",18));
        list.add(new User("dandan",16));
        list.add(new User("xuan",25));
        list.stream().sorted(Comparator.comparingInt(User::getAge)).forEach(System.out::println);

    }

    @Test
    public void test3() {
        List<User> list = new ArrayList<>();
        list.add(new User("kiki",20));
        list.add(new User("lishilong",18));
        list.add(new User("dandan",16));
        list.add(new User("xuan",25));
//        Stream<Integer> ageStream = list.stream().map(e -> e.getAge());
//        Optional<Integer> ss = ageStream.reduce((i1, i2) -> Integer.sum(i1, i2));
        Optional<Integer> sum = list.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(sum);
    }

}
