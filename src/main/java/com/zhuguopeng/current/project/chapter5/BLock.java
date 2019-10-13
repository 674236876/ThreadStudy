package com.zhuguopeng.current.project.chapter5;

public class BLock {

    private final Object lock = new Object();

    public ALock alock;

    public void setAlock(ALock alock) {
        this.alock = alock;
    }

    public void b1() {
        synchronized (lock) {
            System.out.println("b1----------------");
        }
    }

    public void b2() {
        synchronized (lock) {
            alock.a2();
        }
    }
}
