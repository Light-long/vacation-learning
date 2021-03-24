package com.tx.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar的使用
 * 抽象类，不能直接new
 */
public class CalendarTest {

    @Test
    public void testCalendar() {
        // 方式一：创建其子类（GregorianCalendar）
        // 方式二：调用静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        // class java.util.GregorianCalendar
        // System.out.println(calendar.getClass());

        // 常用方法
        // get
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("这个月的第几天："+i);
        // set(修改)
        calendar.set(Calendar.MONTH,11);
        System.out.println(calendar.get(Calendar.MONTH));
        // add
        calendar.add(Calendar.MONTH,2);
        System.out.println(calendar.get(Calendar.MONTH));

        // getTime(): 日历-->Date
        Date time = calendar.getTime();
        System.out.println(time);

        // setTime(): Date-->日历
        System.out.println("_______________________");
        calendar.setTime(time);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
