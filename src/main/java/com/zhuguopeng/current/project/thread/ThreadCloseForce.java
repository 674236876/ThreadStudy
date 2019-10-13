package com.zhuguopeng.current.project.thread;

import java.util.Arrays;

/**
 * 通过执行线程来创建一个守护线程来强制关闭线程的执行
 * 利用了守护线程的特性：当只有守护线程存在的时候，程序将会退出
 */
public class ThreadCloseForce {


    public static void main(String[] args) {

        ThreadService threadService = new ThreadService();
        threadService.excute(()->{
            try {
                System.out.println("任务开始执行");
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
            }

        });
        long startTime = System.currentTimeMillis();
        threadService.shutdown(4_000);
        long endTime = System.currentTimeMillis();

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[Thread.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);

        System.out.println(endTime - startTime);
    }
}
