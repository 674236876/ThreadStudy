package com.zhuguopeng.current.project.chapter1;

public class SellTicketThread extends Thread {

    private static int index = 1;

    private static final int MAX = 50;


    public SellTicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (index <= MAX) {

            System.out.println("当前窗口：" + Thread.currentThread().getName() + ",卖出票号：" +(index++));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
