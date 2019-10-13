package com.zhuguopeng.current.project.thread;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1_000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5_000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
            }

        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(10_000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
            }

        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("执行完啦");
    }
}
