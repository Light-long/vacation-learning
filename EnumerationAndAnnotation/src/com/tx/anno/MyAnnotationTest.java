package com.tx.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 * 1. 注解声明为：@Interface
 * 2. 内部定义成员，通常用value表示
 * 3. 是以使用default指定成员的默认值
 * 4. 如果自定义注解没有成员，表示为一个标识作用
 *
 * jdk提供的4种元注解：对现有的注解进行修饰
 * - Retention: 指明修饰的Annotation的声明周期
 *   - SOURCE:编译为.class文件后就消失了（class文件中没有了）
 *   - CLASS:class文件中还存在，但是没有加载到内存中(默认行为)
 *   - RUNTIME:加载到内存中，只有声明为RUNTIME,才能通过反射获取
 * - Target: 声明这个注解可以标注在什么结构
 * - Documented: 所修饰的注解在被javadoc解析时，保留下来
 * - Inherited: 某个类使用了被次标注的注解，则其子类自动使用该注解
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value() default "hello";
}

@MyAnnotation
public class MyAnnotationTest {
}
