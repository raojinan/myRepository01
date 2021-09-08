package com.itan.shejimoshi.proxy.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理对象的处理器(动态代理处理器)
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/14 16:15
 */
public class MyHandler implements InvocationHandler {

    private Object object;

    //构造器目的是为了入参委托者，使得委托者原始方法能够在代理者中执行
    public MyHandler(Object object) {
        this.object = object;
    }

    //proxy:代理对象   method:代理对象调用的方法对象。   args:代理对象调用方法时传递的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //需要增强的方法

        System.out.println("委托者方法执行前增强的方法");
        //这里可以可以看出用的是反射机制，调用成员方法对象的invoke方法；object：委托者
        Object invoke = method.invoke(object, args);
        System.out.println("委托者方法执行后增强的方法");
         return invoke;
    }
}

