package com.tx.enum1;

/**
 * 枚举类的使用：
 * 1. 类的对象只有有限个，确定个，我们称为枚举类
 * 2. 需要定义一组常量时，使用枚举类
 * 3. 如果枚举类只有一个对象时，则可以作为单例模式的实现方式
 *
 * 如何定义枚举类？
 * 1. JDK5之前，自定义
 * 2. JDK5之后，关键字enum

 */

// 季节，自定义枚举类
class Season {
    //1. 声明Season对象的属性：private final
    private final String seasonName;
    private final String seasonDesc;

    //2. 私有化构造器，并给属性赋值
    private Season(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3. 提供当前枚举类的多个对象，public static final
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4. 获取枚举类对象属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    //5. toString()
    @Override
    public String toString() {
        return seasonName+":"+seasonDesc;
    }

}

public class SeasonTest {
    public static void main(String[] args) {
        // 测试自定义枚举类
        Season spring = Season.SPRING;
        // toString
        System.out.println(spring.toString());
    }
}
