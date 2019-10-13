package com.zhuguopeng.current.project.chapter5;

public class ALock {

    private final Object lock = new Object();

    private final BLock bLock;

    public ALock(BLock bLock) {
        this.bLock = bLock;
    }

    public void a1() {
        synchronized (lock) {
            bLock.b1();
        }
    }

    public void a2() {
        synchronized (lock) {
            System.out.println("a2----------------");
        }
    }

}
