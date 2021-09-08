package com.itan.shejimoshi.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/15 21:19
 */
public class Client {
    public static void main(String[] args) {
        //这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer = new Enhancer();
        //将被代理类设置为父类
        enhancer.setSuperclass(SellTicketsImpl03.class);
        //设置拦截器
        enhancer.setCallback(new MyInterceptor());
        //最后执行enhancer.create()动态生成一个代理类，并从Object强制转型成父类型SellTicketsImpl03。
        //Object o = enhancer.create();
        SellTicketsImpl03 sellTicketsImpl03 = (SellTicketsImpl03) enhancer.create();
        //调用方法就是增强此方法
        sellTicketsImpl03.money();
        sellTicketsImpl03.sendMessage("王宝强");
        //不需要增强方法
        SellTicketsImpl03 sellTicketsImpl = new SellTicketsImpl03();
        sellTicketsImpl.sell();


    }
}
