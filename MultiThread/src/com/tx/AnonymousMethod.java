package com.tx;

public class AnonymousMethod {

    public static void main(String[] args) {

        // 创建Thread类的匿名内部类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<=100;i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();
    }
}
