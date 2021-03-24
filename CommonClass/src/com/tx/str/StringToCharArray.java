package com.tx.str;

import org.junit.Test;

public class StringToCharArray {

    // String-->charArray
    @Test
    public void test() {
        String string = "abcdef";
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar+"  ");
        }
    }

    // charArray-->String
    @Test
    public void test2() {
        char[] chars = new char[]{'a','b','c','d','e'};
        String str = new String(chars);
        System.out.println(str);
    }
}
