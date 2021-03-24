package com.tx.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 接口
interface Human {
    String getBelieve();

    void eat(String food);
}

// 被代理对象
class Superman implements Human {

    @Override
    public String getBelieve() {
        return "中国共产党";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

// 通用加强方法
class HumanUtils {
    public static void method1() {
        System.out.println("加强方法1");
    }
    public static void method2() {
        System.out.println("加强方法2");
    }
}

// 代理对象工厂
class ProxyFactory {
    // 调用此方法，返回一个代理类的对象
    // 需要一个 被代理对象
    public static Object getProxyInstance(Object obj) {

        // 被代理对象的类加载器
        // 被代理对象实现的所有接口
        // method.invoke(被代理对象,参数)-->代理对象调用方法就会让被代理对象调用invoke方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                (proxy, method, args) -> {
            HumanUtils.method1();
            Object returnValue = method.invoke(obj, args);
            HumanUtils.method2();
            return returnValue;
        });
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        // 代理对象是运行期，根据传递的代理对象生成的
        // 因为代理对象也实现了接口，所以可以强转为 接口(Human)类型
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new Superman());
        String believe = proxyInstance.getBelieve();
        System.out.println(believe);
        proxyInstance.eat("西红柿鸡蛋");
    }
}
