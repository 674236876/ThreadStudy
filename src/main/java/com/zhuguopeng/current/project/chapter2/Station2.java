package com.zhuguopeng.current.project.chapter2;

import com.zhuguopeng.strategy.Order;

public class Station2 {
    public static void main(String[] args) {
        SellTicketRunable sellTicketRunable = new SellTicketRunable();
        Thread thread1 = new Thread(sellTicketRunable,"1号窗口");
        Thread thread2 = new Thread(sellTicketRunable,"2号窗口");
        Thread thread3 = new Thread(sellTicketRunable, "3号窗口");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
