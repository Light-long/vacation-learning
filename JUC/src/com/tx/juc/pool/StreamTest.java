package com.tx.juc.pool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class StreamTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"kiki",20));
        list.add(new User(2,"dandan",16));
        list.add(new User(3,"lishilong",18));
        list.add(new User(4,"xuan",25));
        list.add(new User(5,"shiyuan",23));
        // filter(Predicated<T> T) 过滤
        // map(Function<T,R> f) 映射为其他流（操作）
        list.stream().filter(u->u.getId()%2==0)
                .filter(u->u.getAge()>=10)
                .map(u->u.getName().toUpperCase())
                .sorted(Comparator.reverseOrder()) // sorted((s1,s2)->-s1.compareTo(s2))
                .limit(1)
                .forEach(System.out::println);

    }
}
