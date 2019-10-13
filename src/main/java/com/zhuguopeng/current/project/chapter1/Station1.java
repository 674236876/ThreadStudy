package com.zhuguopeng.current.project.chapter1;

public class Station1 {

    public static void main(String[] args) {
        SellTicketThread thread1 = new SellTicketThread("1号窗口");
        SellTicketThread thread2 = new SellTicketThread("2号窗口");
        SellTicketThread thread3 = new SellTicketThread("3号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
