package com.zhuguopeng.current.project.chapter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * 锁的实现逻辑类
 * 设计模式：保护性模式
 *
 * 注意：
 * 1.调用wait的地方需要使用synchronized,否则会报错 IllegalMonitorStateException
 * 2.是哪个线程锁的，就得用哪个线程去释放锁
 *
 */
public class BooleanLock implements Lock {

    //如果锁已经被线程占用了 则为true
    //如果锁是空闲的则为false
    private boolean initValue;

    //当前的线程
    private Thread currentThread;

    //保存阻塞Thread的容器
    private Collection<Thread> waitThread = new ArrayList<>();

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {

        while (initValue) {
            waitThread.add(Thread.currentThread());
            this.wait();
        }
        this.currentThread = Thread.currentThread();
        waitThread.remove(Thread.currentThread());
        initValue = true;
    }

    @Override
    public void lock(Long millis) throws InterruptedException, TimeOutException {

        if (millis <= 0) {
            lock();
        }

        long hasRemainTime = millis;
        long endTime = System.currentTimeMillis() + millis;

        while (initValue) {
            if (hasRemainTime <= 0) {
                throw new TimeOutException("超时啦");
            }

            waitThread.add(Thread.currentThread());
            this.wait(millis);
            hasRemainTime = endTime - System.currentTimeMillis();

        }

        this.currentThread = Thread.currentThread();
        waitThread.remove(Thread.currentThread());
        initValue = true;


    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == this.currentThread) {
            initValue = false;
            Optional.of(Thread.currentThread().getName() + "释放了锁").ifPresent(System.out::println);
            this.notifyAll();
        }


    }

    @Override
    public Collection<Thread> getWaitThread() {
        return Collections.unmodifiableCollection(waitThread);
    }
}
