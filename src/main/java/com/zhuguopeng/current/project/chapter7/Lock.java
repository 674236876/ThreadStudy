package com.zhuguopeng.current.project.chapter7;

import java.util.Collection;

/**
 * 自定义一个锁
 */
public interface Lock
{
    class TimeOutException extends Exception{
        public TimeOutException(String message) {
            super(message);
        }
    }


    void lock() throws InterruptedException;

    void lock(Long millis) throws InterruptedException,TimeOutException;

    void unlock();

    Collection<Thread> getWaitThread();


}
