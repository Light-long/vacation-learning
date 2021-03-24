package com.tx;

import org.junit.Test;

import java.util.List;

/**
 * 不使用泛型的弊端:
 * 1. 类型不安全
 * 2. 强转时，可能ClassCastException
 *
 * 使用泛型：
 * 1. 编译时类型检查
 * 2. 不用强转
 *
 * tips:泛型不能是基本数据类型，只能是包装类
 *
 * 泛型类有多个参数：
 * class Order<T,E,K,V>
 *
 * tips: 静态方法中不能使用泛型：因为创建对象时才会指定泛型
 */

// 自定义泛型类
class Order<T> {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}

// 子类继承泛型类，也得是泛型类
//class OrderSun extends Order<T> 是错的
class OrderSun<T> extends Order<T> {

}
public class GenericTest {

    @Test
    public void testGeneric() {
        Order<String> order = new Order<>();
    }

    // 泛型方法：在方法中一定要声明是一个泛型方法 public <E> void test(E e){}
    // 在方法中出现了泛型结构，泛型参数与累的泛型没有关系
    // 和所属类是不是泛型没有关系
    // 可以声明为静态
    public static <E> void testGen(E e) {
        
    }

    /**
     * 泛型在继承方面的特征：
     * 类A是类B的父类，但G<A> 不是 G<B> 的父类
     * - List<Object> 不是 List<String>的父类
     * - 但是 List<String> 是 ArrayList<String>的父类
     *
     * 通配符的使用：
     * 通配符：？
     * - 类A是类B的父类，G<A>和G<B>并列，他们的共同父类是G<?>
     * - G<?>类型的变量可以读，不可以取（Object）
     *
     * 有条件的通配符：
     * - ？ extends A
     * --- ？代表A以及A的子类 （不能添加）
     * - ？ super A
     * --- ？代表A以及A的父类 （可以添加A或A的子类对象）
     */
    public void test() {
        List<String> list1= null;
        List<Object> list2= null;

        List<?> list = null;
        list = list1;
        list = list2;
    }


}
