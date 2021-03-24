package com.tx.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    /**
     * 通过反射对Person进行操作
     * Class是 类的类 ，定义了类的属性，方法，构造器等共性
     */
    @Test
    public void test1() throws Exception{
        //1. 通过反射创建Person对象
        // Person.class是Class的对象
        Class<Person> clazz = Person.class;
        // 通过类对象获取构造器(构造器的参数类型)
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        // 通过构造器创建对象newInstance(参数)
        Person p = constructor.newInstance("kiki", 20);
        System.out.println(p);
        //2. 通过反射调用对象指定的属性，方法
        // 获取指定名称的属性
        Field age = clazz.getDeclaredField("age");
        // 调用属性set(原来对象，新的name值)
        age.set(p,30);
        System.out.println(p);
        // 获取指定的方法(方法名，[参数类型])
        Method show = clazz.getDeclaredMethod("show");
        // 调用方法(哪个对象调用方法，方法的实参（需要传递的参数）)
        Object invoke = show.invoke(p);
        // 方法的返回值
        System.out.println(invoke);
    }

    /**
     * 通过反射，调用Person类的私有结构
     */
    @Test
    public void test2() throws Exception{
        // 创建Peron类对象
        Class<Person> clazz = Person.class;
        // 1. 调用私有构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        // 将私有的构造器设置为可以用的
        cons1.setAccessible(true);
        // 通过构造器创建对象（构造器需要的参数）
        Person p = cons1.newInstance("lishilong");
        System.out.println(p);

        // 2. 调用私有属性
        // 获取私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        // 属性赋值（需要赋值的对象，赋的值）
        name.set(p,"Kiki");
        Field age = clazz.getDeclaredField("age");
        age.set(p,22);
        System.out.println(p);

        // 3. 调用私有方法
        // 获取私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        // 调用私有方法（哪个对象，参数）-->返回值和原方法返回值相同
        // 相当于String nation = p.showNation("中国");
        String nation = (String) showNation.invoke(p,"中国");
        System.out.println(nation);
    }

    /**
     * 关于java.lang.Class的理解
     * 1. 类的加载过程
     * - 程序经过javac.exe编译后，会生成一个或多个字节码文件(.class结尾)
     * - 接着使用java.exe对字节码文件进行揭示运行；相当于将某个字节码文件加载到内存中，此过程称为类的加载；
     * - 加载到内存中的类称为，运行时类，此运行时类，就作为Class类的一个实例
     *
     * 2. Class的一个实例就对应一个运行时类
     * 3. 一个类对应的Class实例（加载到内存中的运行时类）只有一个
     */
    @Test
    public void test3() throws ClassNotFoundException {
        // 获取Class实例的方式
        //1. 通过类的属性：类.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //2. 通过类创建对象的方法：getClass()
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        //3. 通过Class类的静态方法：Class.forName(String classPath)
        Class<?> clazz3 = Class.forName("com.tx.reflection.Person");
        System.out.println(clazz3);
        // 所有通过Person类创建的Class实例都是同一个
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //4. 通过当前类的类加载器：当前类.class.getClassLoader
        // 获取当前类的类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        // 加载指定类
        Class<?> clazz4 = classLoader.loadClass("com.tx.reflection.Person");
        System.out.println(clazz4);
    }


}
