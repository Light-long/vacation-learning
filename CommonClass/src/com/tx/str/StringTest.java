package com.tx.str;

import org.junit.Test;

/**
 * String的使用
 */
public class StringTest {

    /**
     * String: 字符串，使用一对“ ”来表示
     * 1. String声明为final的，不可被继承
     * 2. String实现了Serializable接口：表示字符串是支持序列化的
     *          实现了Comparable接口：String可以比较大小
     * 3. String内部定义了final char[] value 用于存储字符数据
     * 4. String:代表不可变的字符序列，简称：不可变 性
     *    体现: 1. 当对字符串重新赋值时（修改），不能使用原有的value进行赋值（需要重新指定）
     *         2. 对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行添加
     *         3. 当调用String的replace修改字符时，需要重新指定内存区域，原有的不会修改
     * 5. 通过字面量(区别于new)给字符串赋值，此时的字符串值声明在字符串常量池中
     * 6. 字符串常量池中不会存储相同内容的字符串
     */
    @Test
    public void test1() {
        // 字面量赋值
        String str1 = "abc";
        String str2 = "abc";
        // 在字符串常量池中新建一个hello，str1指向hello
         str1 = "hello";
        // 比较地址值
        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);

        System.out.println("***********");
        String str3 = "abc";
        // 重新建了一个abcdef，让str3指向他
        str3+="def";
        System.out.println(str3);

    }

    /**
     * String的创建方式
     * 1. 通过字面量定义 String str = "abc";
     * 2. new + 构造器
     *
     * 面试：String str = new String("abc");这种方式创建了几个对象？
     * 答案：一个或两个
     *     1. 如果常量池中没有“abc”,则，一个堆空间中new的结构，另一个是char[]对应的常量池中的数据“abc”
     *     2. 如果常量池中有“abc”,则，只有堆空间中new的结构
     */
    @Test
    public void test2() {
        // 此时的s1,s2声明在方法区中的字符串常量池中,s1,s2,指向的是常量池中的地址
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        // 通过new+构造器方式，此时s3,s4保存的地址是数据在堆空间的地址，堆中存的value(char [])，是字符串常量池中的地址
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);// false
        System.out.println(s1 == s4);// false
        System.out.println(s3 == s4);// false
    }

    /**
     * 字符串不同拼接的比较：
     * 1. 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     * 2. 只要其中有一个是变量，结果就在堆中，相当于new 了一个字符串，存的是堆空间对应的地址
     * 3. 如果拼接的结果调用intern()方法，返回值就在常量池中（即常量池中的地址）
     */
    @Test
    public void test3() {
        String s1 = "Spring";
        String s2 = "MVC";

        // 字面量拼接相当于常量
        String s3 = "SpringMVC";
        String s4 = "Spring" + "MVC";
        // 只要有一个变量，结果就在堆中，存的是堆的地址
        String s5 = s1 + "MVC";
        String s6 = "Spring" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);// true
        System.out.println(s3 == s5);// false
        System.out.println(s3 == s6);// false
        System.out.println(s3 == s7);// false
        System.out.println(s5 == s6);// false
        System.out.println("String 的 intern()方法");
        String s8 = s5.intern();
        // intern方法返回常量池中的地址
        System.out.println(s3 == s8);//true
    }

    /**
     * 字符串常量池的演变：
     * 1.6-->永久代（方法区）
     * 1.7-->堆
     * 1.8-->元空间（方法区）
     */

}
