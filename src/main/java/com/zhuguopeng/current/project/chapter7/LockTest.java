package com.zhuguopeng.current.project.chapter7;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 创建了自定义锁实验
 *
 *
 *
 */
public class LockTest {

    public static void main(String[] args) {
        Lock booleanLock = new BooleanLock();


        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name ->
                        new Thread(() -> {
                            try {
                                booleanLock.lock(2000L);
                                Optional.of(Thread.currentThread().getName() + "占用了锁").ifPresent(System.out::println);
                                work();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (Lock.TimeOutException e) {
                                Optional.of(Thread.currentThread().getName() + "超时啦").ifPresent(System.out::println);

                            } finally {
                                booleanLock.unlock();
                            }

                        }, name).start()

                );
    }

    private static void work() {
        Optional.of(Thread.currentThread().getName() + "正在工作").ifPresent(System.out::println);

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
        }

    }
}
