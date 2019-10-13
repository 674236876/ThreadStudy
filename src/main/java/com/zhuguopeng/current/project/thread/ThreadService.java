package com.zhuguopeng.current.project.thread;

public class ThreadService {


    private Thread thread;

    private static boolean flag = false;

    public void excute(Runnable task) {

        thread = new Thread(() -> {
            final ThreadGroup threadGroup = new ThreadGroup("test");
            Thread mytask = new Thread(threadGroup,task);
            mytask.setDaemon(true);
            mytask.start();

            try {
                mytask.join();
                flag = true;
            } catch (InterruptedException e) {
                System.out.println("线程被关闭了");
            }
        });
        thread.start();
    }

    public void shutdown(long millis) {
        long currentTime = System.currentTimeMillis();
        while (!flag) {
            if ((System.currentTimeMillis() - currentTime) > millis) {
                System.out.println("超时了，我要关闭线程了");
                thread.interrupt();
                break;
            }
            System.out.println("当前存活的线程数："+Thread.activeCount());

//这个sleep没看懂， 为什么非要睡1ms呢？  不睡还检测不到任务执行完了，而且还超时打断
//            try {
//                thread.sleep(1);
//            } catch (InterruptedException e) {
//                System.out.println("执行线程被打断");
//
//            }
        }
        flag = false;
    }

}
