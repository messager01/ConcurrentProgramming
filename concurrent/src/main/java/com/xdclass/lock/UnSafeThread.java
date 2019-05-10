package com.xdclass.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*
*
*       lock与synchronized的区别
        lock 获取锁与释放锁的过程，都需要程序员手动的控制 Lock用的是乐观锁方式。所谓乐观锁就是，每次不加
        锁而是假设没有冲突而去完成某项操作，如果因为冲突失败就重试，直到成功为止。乐观锁实现的机制就 是
        CAS操作 synchronized托管给jvm执行 原始采用的是CPU悲观锁机制，即线程获得的是独占锁。独占锁意味
        着其他线程只能依靠阻塞来等待线程释放锁。
* */

public class UnSafeThread {

    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static Lock lock = new ReentrantLock();

    /**
     * 每次调用对num进行++操作
     */
    public  static void  inCreate() {
        lock.lock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //每个线程执行完成之后，调用countDownLatch
                countDownLatch.countDown();
            }).start();
        }

        while (true) {
            if (countDownLatch.getCount() == 0) {
                System.out.println(num);
                break;
            }
        }

    }
}
