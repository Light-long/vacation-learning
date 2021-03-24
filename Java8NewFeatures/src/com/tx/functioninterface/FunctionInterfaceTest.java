package com.tx.functioninterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 函数式接口：
 * - 只有一个抽象方法的接口
 * - @FunctionalInterface
 *
 * java.util.function包下有多个函数是接口：
 * 四大函数是接口：
 * - 消费型接口：Consumer<T>    void accept(T t)
 * - 供给型接口：Supplier<T>    T get()
 * - 函数型接口：Function<T,R>  R apply(T t)
 * - 断定型接口：Predicate<T>   boolean test(T t)
 */
public class FunctionInterfaceTest {

    @Test
    public void testConsumer() {
        consumerMoney(1000d, aDouble -> System.out.println("消费"+aDouble));
    }

    public void consumerMoney(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("北京","南京","天津","西安");
        // 包含 京 的字符串
        List<String> strList = filterList(list, s -> s.contains("京"));
        strList.forEach(System.out::println);
    }

    // 此方法用来过滤数组
    public List<String> filterList(List<String> list, Predicate<String> predicate) {
        // 存放符合要求的String
        ArrayList<String> arrayList = new ArrayList<>();
        // 遍历list，符合要求的放入arrayList
        for (String s : list) {
            if (predicate.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
