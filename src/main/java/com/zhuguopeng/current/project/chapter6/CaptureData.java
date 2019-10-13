package com.zhuguopeng.current.project.chapter6;

import java.util.*;

/**
 * 需求：
 * 采集数据。  一共有10台机器需要采集数据，
 * 但是考虑机器的线程效率与数量成抛物线比例的，也就是当线程数量过多时，效率反而会降低（原因：CPU会消耗大量的时间在切换上下文上）
 * 现在只开启5个线程工作，当一个线程完成后在开启用另外的线程补上继续采集，由此保证线程处于一个最高效率的执行
 * <p>
 * 技术：采用join，synchronize,wait,notify等Api来实现
 */
public class CaptureData {

//用于记录当前正在执行的线程数量，且作为锁
    private static final LinkedList<Control> CONTROLS = new LinkedList<>();

//    最大执行线程数量
    private static final int MAX = 5;

    public static void main(String[] args) {

        List<Thread> works = new ArrayList<>();

        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10").stream()
                .map(CaptureData::createThread)
                .forEach(t -> {
                    t.start();
                    works.add(t);
                });

        works.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        });

        Optional.of("所有的采集工作都做完了").ifPresent(System.out::println);

    }

    public static Thread createThread(String name) {
        return new Thread(() -> {
            Optional.of("线程[" + Thread.currentThread().getName() + "]被创建了").ifPresent(System.out::println);

            synchronized (CONTROLS) {
                while (CONTROLS.size() >= MAX) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }


            Optional.of("线程[" + Thread.currentThread().getName() + "]正在采集数据").ifPresent(System.out::println);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
            }

            synchronized (CONTROLS) {
                Optional.of("线程[" + Thread.currentThread().getName() + "]采集完成").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);
    }

// 该类的作用： 为了在主程序中定义一个链表类型的锁。  可以吧这个类视为一个数量控制器。
    public static class Control {

    }

}
