package com.zhuguopeng.current.project.chapter5;

/**
 * 通过控制flag来让线程走完
 */
public class ThreadInterrupt {


    private static class Worker extends Thread {

//        当不加volatile关键字是 该线程停不下来是为什么？

        private static volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
            }
        }

        public void shutdown() {
            flag = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();


        Thread.sleep(3_000);
        worker.shutdown();

    }

}
