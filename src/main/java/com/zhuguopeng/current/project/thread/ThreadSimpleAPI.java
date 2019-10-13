package com.zhuguopeng.current.project.thread;

import java.util.Optional;

public class ThreadSimpleAPI {


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Optional.of(Thread.currentThread().getName() + "-index-" + i).ifPresent(System.out::println);
            }
        });

        thread1.setPriority(Thread.MAX_PRIORITY);

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Optional.of(Thread.currentThread().getName() + "-index-" + i).ifPresent(System.out::println);
            }
        });

        thread2.setPriority(Thread.NORM_PRIORITY);

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Optional.of(Thread.currentThread().getName() + "-index-" + i).ifPresent(System.out::println);
            }
        });

        thread3.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
