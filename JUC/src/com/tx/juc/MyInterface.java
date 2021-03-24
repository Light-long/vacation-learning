package com.tx.juc;

/**
 * 函数式接口中，只有一个方法的声明
 * jdk8之后，可以有多个方法的实现，方法用default修饰
 * 可以有多个静态方法
 */
@FunctionalInterface
public interface MyInterface {

    void save();

    default int a() {
        return 1;
    }
    default int b() {
        return 1;
    }

    public static void  info() {}
    public static void  info2() {}
}
