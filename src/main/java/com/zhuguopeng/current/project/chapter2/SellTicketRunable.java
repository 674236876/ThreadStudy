package com.zhuguopeng.current.project.chapter2;

public class SellTicketRunable implements Runnable {

    private int index = 1;

    private final int MAX = 50;

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