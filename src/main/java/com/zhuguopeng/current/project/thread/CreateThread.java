package com.zhuguopeng.current.project.thread;

import java.util.Arrays;

public class CreateThread {

    public static void main(String[] args) {
        Thread t = new Thread("Thread-1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        };

        t.start();
//        System.out.println(Thread.currentThread().getThreadGroup().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[Thread.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);

    }

}
