package com.tx.enum1;

/**
 * 使用enum定义的枚举类，默认继承于java.lang.Enum
 *
 * ENUM 的常用方法：
 *  - toString(): 默认返回对象名
 *  - values(): 返回枚举类的对象数组
 *  - valueOf(objName): 返回枚举类中与objName相同名称的对象
 *
 *  枚举类实现接口：
 *  1. enum中重写接口中的方法
 *  2. 每个enum对象重写方法
 */

// 使用enum关键字定义枚举类
enum Season1 {
    //1. 提供当前枚举类对象，多个对象之间用，隔开，最后一个以；结尾
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");

    //2. 声明Season1对象的属性，private final
    private final String seasonName;
    private final String seasonDesc;

    //3. 私有化构造器给对象属性赋值
    private Season1(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4. 获取枚举类对象属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 不用写toString
}
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        // toString
        System.out.println(summer.toString());
        // values
        Season1[] seasons = Season1.values();
        for (Season1 season : seasons) {
            System.out.print(season+"  ");
        }
        System.out.println();
        // valueOf
        // 如果objName不存在，java.lang.IllegalArgumentException:
        // No enum constant com.tx.enum1.Season1.AUTUM
        Season1 autumn = Season1.valueOf("AUTUMN");
        System.out.println(autumn);
    }
}
