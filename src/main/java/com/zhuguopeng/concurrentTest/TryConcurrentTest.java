package com.zhuguopeng.concurrentTest;

public class TryConcurrentTest {

    public static void main(String[] args) {

        try {
            Thread.sleep(1000 * 300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
