package com.tx.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest2 {
    /**
     * newInstance(),调用此方法，创建运行时类的对象
     * - 内部调用了运行时类的空参构造器
     *
     * 想要此方法正常的创建运行时类对象，要求：
     * 1. 运行时类必须提供空参构造器
     * 2. 空参构造器的访问权限得够，最好是public
     *
     * 在javabean中要求提供一个public的空参构造器的原因：
     * 1. 便于通过反射，创建运行时类的对象
     * 2. 便于子类继承此运行时类时，默认调用super()时，保证父类有构造器
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person.getClass());
    }

    /**
     * 获取属性
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        // getFields():获取当前运行时类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        //getDeclaredFields(): 获取当前运行时类声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        // 权限修饰符  变量类型  变量名
        for (Field declaredField : declaredFields) {
            // 获取权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 获取变量类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getSimpleName() + "\t");

            // 获取变量名
            String name = declaredField.getName();
            System.out.print(name);
            System.out.println();
        }
    }

    /**
     * 反射获取方法
     */
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        // getMethods()：获取当前运行时类及其父类的所有public修饰的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();
        // getDeclaredMethods:获取当前运行时类的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
            Annotation[] annotations = declaredMethod.getAnnotations();
        }
    }

    /**
     * 反射获取构造器
     */
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        // 获取当前运行时类的所有声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();
        // 获取当前运行时类的所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /**
     * 操作运行时类的指定属性
     */
    @Test
    public void test5() throws Exception{
        Class<Person> clazz = Person.class;
        // 创建一个运行时类的对象
        Person person = clazz.newInstance();
        // 获取指定属性
        Field name = clazz.getDeclaredField("name");
        // 设置为可以访问
        name.setAccessible(true);
        // 设置set（需要设置属性的运行时类对象，属性值）
        name.set(person,"kiki");
        System.out.println(name.get(person));
    }

    /**
     * 操作运行时类的指定方法
     */
    @Test
    public void test6() throws Exception{
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        // 获取指定名称的方法
        //getDeclaredMethod(String methodName,形参列表)
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        // 设置方法可访问
        showNation.setAccessible(true);
        // 调用方法
        // showNation(调用方法的运行时类的对象，实参)
        String chn = (String) showNation.invoke(person, "CHN");
        System.out.println(chn);

        System.out.println("调用静态方法");
        Method info = clazz.getDeclaredMethod("info");
        info.setAccessible(true);
        info.invoke(Person.class);
    }
}
