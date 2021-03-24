package com.tx.create.singleton;

/**
 * 饿汉式
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    // 私有化构造器
    private HungrySingleton() {}
    public static HungrySingleton getInstance() {
        return instance;
    }
}
