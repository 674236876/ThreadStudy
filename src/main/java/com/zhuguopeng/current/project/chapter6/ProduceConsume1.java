package com.zhuguopeng.current.project.chapter6;

/**
 * 存在问题的生产着消费者程序
 * 由于cpu随机切换线程执行上下文，导致生产者生产过多无用数据，消费者消费同一个数，对于次问题通过版本2 解决
 */
public class ProduceConsume1 {

    private int i = 0;


    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            System.out.println("p->" + (++i));
        }
    }

    public void consume() {
        synchronized (LOCK) {
            System.out.println("c->" + i);
        }
    }

    public static void main(String[] args) {
        ProduceConsume1 pc = new ProduceConsume1();
        new Thread(){
            @Override
            public void run() {
                while(true)
                    pc.produce();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true)
                    pc.consume();
            }
        }.start();
    }

}
