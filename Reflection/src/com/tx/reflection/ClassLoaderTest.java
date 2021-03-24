package com.tx.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解ClassLoader：
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(appClassLoader);
        // 获取拓展类加载器
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);
        // 无法获取引导类加载器（有C++编写，用来加载java核心类库）
    }

    /**
     * Properties加载配置文件
     */
    @Test
    public void test() throws Exception{
        // 创建properties对象
        Properties properties = new Properties();
        // 这种方式加载配置文件默认在module下找
        //FileInputStream fis1 = new FileInputStream("jdbc1.properties");

        // 2. 通过ClassLoader获取流
        // 默认在src下找配置文件
        InputStream fis2 = ClassLoaderTest.class.getClassLoader().getResourceAsStream("jdbc2.properties");
        // 根据流加载配置文件
        properties.load(fis2);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(username+":"+password);

    }
}
