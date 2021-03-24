package com.tx.methodreference;

import org.junit.Test;
import sun.java2d.pipe.AAShapePipe;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用：
 * 1. 使用情景：要传递给lambda体的操作已经有实现的方法了，可以使用方法引用
 * 2. 方法引用，本质上就是lambda表达式，即为 函数式接口的实例
 * 3. 使用格式：    类(对象) :: 方法名
 * 4. 具体分为3种情况：
 *  - 对象 :: 非静态方法
 *  - 类  :: 静态方法
 *  - 类  :: 非静态方法
 *
 *  使用要求：要求接口中抽象方法的形参列表和返回值类型，与方法引用的方法的形参列表和返回值类型相同
 */
public class MethodReferenceTest {

    /**
     * Consumer<T>  void accept(T t)
     *              void System.out.println(T t)
     * 对象 :: 非静态方法
     */
    @Test
    public void test1() {
        System.out.println("lambda表达式.....");
        Consumer<String> consumer = (string)-> System.out.println(string);
        consumer.accept("kiki");
        System.out.println("MethodReference.....");
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("lishilong");
    }

    /**
     * 类 :: 静态方法
     * Comparator<String>  compare(s1,s2)
     */
    @Test
    public void test2() {
        System.out.println("lambda表达式.....");
        Comparator<String> comparator = (s1,s2)->s1.compareTo(s2);
        System.out.println(comparator.compare("kiki", "lishilong"));
        System.out.println("MethodReference.....");
        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println(comparator1.compare(20, 18));
    }

    /**
     * 构造器引用
     * 抽象方法的返回值类型即为构造器所属类的类型
     */
    @Test
    public void test3() {
        Supplier<User> supplier = ()-> new User();
        System.out.println(supplier.get());
        Supplier<User> supplier2 = User :: new;
        System.out.println(supplier2.get());
        System.out.println();
        BiFunction<String,Integer,User> function = (str,age)->new User(str,age);
        System.out.println(function.apply("aa", 20));
        System.out.println("MethodReference......");
        BiFunction<String,Integer,User> function1 = User::new;
        System.out.println(function1.apply("ikkk", 20));
    }
}
