package com.tx.create.singleton;

/**
 * 双重校验锁
 */
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton instance;
    private DoubleCheckLockSingleton() {}

    // 双重检测
    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}