package com.zhuguopeng.current.project.chapter5;

/**
 * 调用interrupt来执行打断动作，线程通过interrupted来获取是否被打断的状态从而停止运行
 * 如果说线程处于某种block状态时会导致无法检测到Thread 被interrupt的signal，从而导致线程无法被强制关闭，可以查看ThreadCloseForce来进行关闭
 */
public class ThreadInterrupt2 {


    private static class Worker extends Thread {


        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
//                try {
//                    Thread.sleep(10_000);
//                } catch (InterruptedException i) {
//                    break;
//                }
            }
            System.out.println("线程停了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(3_000);
        worker.interrupt();

    }

}
