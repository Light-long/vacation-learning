package com.tx.threadsynchronization;

/**
 * 单例模式饿汉式改为
 */
public class SingletonMode {
}

class Bank {
    // 私有构造器
    private Bank() {}

    private static Bank instance = null;

    // 效率稍低的方式
//    public static Bank getInstance() {
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    // 效率较高的方式
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
