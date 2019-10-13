package com.zhuguopeng.current.project.chapter6;

import java.util.stream.Stream;

/**
 * 简单的介绍了生产者与消费者的实现逻辑
 * Object 的wait：会将当前线程进入等待状态，相当于放弃了CPU执行权，只有当其他线程对该对象调用了notify方法或者notifyAll方法才会唤醒
 * Object 的notify：会将停在当前线程的线程给唤醒
 * Object 的notifyAll：会将当前对象后的所有线程都给唤醒
 *
 *
 */
public class ProduceConsume2 {

    private int i = 0;

    private final Object LOCK = new Object();

    private boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            while (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                }
            }
            i++;
            System.out.println("p->" + i);
            isProduce = true;
            LOCK.notifyAll();
        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {

                }
            }
            System.out.println("c->" + i);
            isProduce = false;
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) {
        ProduceConsume2 pc = new ProduceConsume2();
        Stream.of("P1", "P2").forEach((n) ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true)
                            pc.produce();
                    }
                }.start()
        );


        Stream.of("C1", "C2").forEach((n) ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true)
                            pc.consume();
                    }
                }.start());
    }

}
