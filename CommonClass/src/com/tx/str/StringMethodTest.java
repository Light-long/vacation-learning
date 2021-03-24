package com.tx.str;

import org.junit.Test;

public class StringMethodTest {

    @Test
    public void test1() {
        String s1 = "Spring";
        // 字符串长度
        int length = s1.length();
        System.out.println(length);
        // 获取指定索引字符
        char c = s1.charAt(2);
        System.out.println(c);
        // subString(start,end)-->左闭右开

        // String.valueOf(number)
    }
}
