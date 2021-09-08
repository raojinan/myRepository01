package com.itan.shejimoshi.proxy.cglib;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 拦截器
 * 委托者对象拦截器，实现MethodInterceptor
 * @author raojinan
 * @version 1.0
 * @date 2021/8/15 21:11
 */
public class MyInterceptor implements MethodInterceptor {
    /**
     * 重写方法拦截在方法前和方法后加入业务
     * Object obj为目标对象
     * Method method为目标方法
     * Object[] params 为参数，
     * MethodProxy proxy CGlib方法代理对象
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(obj, params);
        System.out.println(" 调用后");
        return result;
    }
}
