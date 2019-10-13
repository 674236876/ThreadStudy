package com.zhuguopeng.current.project.thread;

/**
 * 1.当jvm中运行的线程都是守护线程时，jvm将会退出。
 * 2.setDaemon方法必须在start之前调用，否则会抛出illegalThreadStateException异常
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                while (true) {
                    System.out.println("check connected");
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            innerThread.setDaemon(true);
            innerThread.start();


            Thread innerThread2 = new Thread(() -> {
                try {
                    Thread.sleep(10_000);
                    System.out.println("innerThread2 running done");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            innerThread2.start();

            try {
                Thread.sleep(5_000);
                System.out.println("thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

//        thread.setDaemon(true);
        thread.start();

        System.out.println("main");

    }
}
