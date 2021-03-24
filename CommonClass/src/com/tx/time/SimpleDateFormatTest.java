package com.tx.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 对Date类的格式化和解析
 */
public class SimpleDateFormatTest {

    /**
     * 格式化：日期-->字符串 format(Date)
     * 解析：字符串-->日期  parse(String)
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化：默认构造器
        SimpleDateFormat format = new SimpleDateFormat();
        // 格式化日期
        Date date = new Date();
        System.out.println(date);
        String dateString = format.format(date);
        System.out.println(dateString);

        // 解析
        String str = "21-1-22 下午5:36";
        Date date1 = format.parse(str);
        System.out.println(date1);
        System.out.println("++++++++++++++++++++++++++++");

        // 实例化SimpleDateFormat,调用带参数的构造器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println(format1);
        Date parse = simpleDateFormat.parse("2021-11-08 21:12:03");
        System.out.println(parse);
    }

    /**
     * SimpleDateFormat联系
     * @throws ParseException
     */
    @Test
    public void practice() throws ParseException {
        String birth = "2000-11-08";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(birth);
        System.out.println(date);
        // 将java.util.Date-->java.sql.Date
        java.sql.Date birthday = new java.sql.Date(date.getTime());
        System.out.println("生日："+birthday);
    }

    /**
     * 三天打鱼两天晒网
     * date2.getTime()-date1.getTime()/(1000*60*60*24) + 1天
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入一个日期：（yyyy-MM-dd）");
        Scanner scan = new Scanner(System.in);
        String dateString = scan.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateSting1 = "1990-01-01";
        // 将字符串 解析为 日期
        Date date2 = dateFormat.parse(dateString);
        Date date1 = dateFormat.parse(dateSting1);
        int day = (int) ((date2.getTime() - date1.getTime()) / (1000*60*60*24) +1);
        if (day % 5 == 1 || day % 5 == 2 || day % 5 == 3) {
            System.out.println("他在打渔");
        } else {
            System.out.println("他在晒网");
        }
    }
}
