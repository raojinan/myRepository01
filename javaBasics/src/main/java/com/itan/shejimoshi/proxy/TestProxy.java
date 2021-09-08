package com.itan.shejimoshi.proxy;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/13 16:29
 */
public class TestProxy {
    public static void main(String[] args) {
        ProxySellTickets proxySellTickets = new ProxySellTickets();
        proxySellTickets.sell();
        String name="晓东";
        proxySellTickets.sendMessage(name);

    }
}
