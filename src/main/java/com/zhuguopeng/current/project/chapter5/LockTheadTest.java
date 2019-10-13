package com.zhuguopeng.current.project.chapter5;

public class LockTheadTest {


    public static void main(String[] args) {
        BLock block = new BLock();
        ALock alock = new ALock(block);
        block.setAlock(alock);

        new Thread(() -> {
            while(true)
                alock.a1();

        }).start();

        new Thread(() -> {
            while (true) {
                block.b2();
            }
        }).start();
    }
}
