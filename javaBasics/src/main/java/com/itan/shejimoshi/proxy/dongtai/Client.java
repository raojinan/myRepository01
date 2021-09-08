package com.itan.shejimoshi.proxy.dongtai;

import com.itan.shejimoshi.proxy.SellTickets;
import com.itan.shejimoshi.proxy.SellTicketsImpl;
import com.itan.shejimoshi.proxy.SellTicketsImpl02;

import java.lang.reflect.Proxy;

/**
 * 客户端对象
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/13 18:27
 */
public class Client {
    public static void main(String[] args) {

        //获取委托者对象
        SellTicketsImpl sellTicketsImpl = new SellTicketsImpl();
        //通过Proxy类的newProxyInstance方法生成代理对象
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(
                sellTicketsImpl.getClass().getClassLoader(),
                new Class[]{SellTickets.class},
                //自定义处理器，用处理器InvocationHandler的实现类，把委托者对象告诉处理器（入参委托者）
                new MyHandler(sellTicketsImpl));
        //代理对象执行委托者方法的同时也会执行增强的方法
        proxyInstance.sell();
        proxyInstance.sendMessage("小慧");
        System.out.println("------------下方是不需要增强的方法---------------");
        sellTicketsImpl.money();

        System.out.println("------------同一个接口的第二个实现类---------------");
        SellTicketsImpl02 sellTicketsImpl02 = new SellTicketsImpl02();
        SellTickets proxyInstance01 = (SellTickets) Proxy.newProxyInstance(
                sellTicketsImpl02.getClass().getClassLoader(),
                new Class[]{SellTickets.class},
                new MyHandler(sellTicketsImpl02));
        //需要增强的方法
        proxyInstance01.sell();
        //不需要增强的方法
        sellTicketsImpl02.money();


    }
}
