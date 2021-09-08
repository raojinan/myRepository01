package com.itan.shejimoshi.proxy;

/**
 * 抽象的接口，实际对象（委托者）和代理对象都需要实现的接口
 *
 * @author raojinan
 * @version 1.0
 * @date 2021/8/13 16:16
 */
public interface SellTickets {
    void sell();
    void money();
    void sendMessage(String name);

}
