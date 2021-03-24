package com.tx.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * java.time Java8新API
 */
public class Java8LocalTimeTest {

    /**
     * LocalDate,LocalTime,LocalDateTime
     */
    @Test
    public void test() {
        // now(当前的日期，时间)
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    @Test
    public void test2() {
        // of(设置指定的年月日，时分秒)
        LocalDateTime dateTime = LocalDateTime.of(2020, 11, 8, 20, 12, 1);
        System.out.println(dateTime);

        // get，获取相关属性
        int dayOfMonth = dateTime.getDayOfMonth();
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        System.out.println(dayOfWeek);

        // with(有返回值，不可变性)，设置相关属性
        LocalDateTime localDateTime = dateTime.withDayOfMonth(9);
        System.out.println(dateTime);
        System.out.println(localDateTime);

        // plus
        LocalDateTime localDateTime1 = dateTime.plusDays(1000);
        System.out.println(localDateTime1);
    }
}
