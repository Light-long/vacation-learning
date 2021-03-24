package com.tx.str;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 */
public class StringBufferBuilderTest {

    /**
     * StringBuffer,StringBuilder,String三者异同：
     * String：不可变的字符序列，使用final char[]
     * StringBuffer: 可变的字符序列，线程安全，效率低,char[]
     * StringBuilder: 可变的字符序列，线程不安全，效率高，jdk5新增,char[]
     *
     * 源码分析：
     * String str = new String(); // char[] value = new char[0];
     * String str1 = new String("abc"); // char[] value = new char[]{'a','b','c'};
     *
     * StringBuffer sb = new StringBuffer(); //char[] value = new char[16];
     * 底层创建了一个长度为16的char[],capacity = 16
     * StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length()+16];
     *
     * 问题1：sb2.length = 3;
     * 问题2：扩容问题：如果添加的数据底层数组添加不下了，就需要扩容数组
     *              默认情况下，扩容为原来的2倍+2，同时将原有数组中的元素复制到新的数组中
     */
    @Test
    public void test() {
        StringBuffer buffer = new StringBuffer("abc");
        System.out.println(buffer.length());
        // 3+16
        System.out.println(buffer.capacity());
    }


}
