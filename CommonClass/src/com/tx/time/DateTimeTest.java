package com.tx.time;

import org.junit.Test;

import java.util.Date;

/**
 * 日期和时间的API测试
 */
public class DateTimeTest {

    /**
     * System类中的currentTimeMillis()
     */
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        // 返回当前时间与1970年1月1日0时0分0秒的时间差
        System.out.println(time);
    }

    /**
     * java.util.Date
     *
     * 1. 两个构造器的使用
     *
     * 2. 两个方法的使用
     *  - toString():显示当前年月日，时分秒
     *  - getTime(): 当前Date对象对应的毫秒数
     */
    @Test
    public void test2() {
        // 构造器一：Date():当前对应时间的Date对象
        Date date = new Date();
        System.out.println(date.toString());// Fri Jan 22 15:44:27 CST 2021
        System.out.println(date.getTime());// 1611301467990

        // 构造器一：Date(long time)
        Date date1 = new Date(1611301467990L);
        System.out.println(date1);
    }
}
