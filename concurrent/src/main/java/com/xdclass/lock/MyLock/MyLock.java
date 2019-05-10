package com.xdclass.lock.MyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/*
*    同一时刻   能且仅能  一个学线程获得锁
*    其他线程只能等该线程释放锁之后才能获取锁
*
* */
public class MyLock implements Lock {

    private boolean isHoldLock  = false;
    @Override
    public synchronized void lock() {

        if(isHoldLock){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isHoldLock = true;
    }




    @Override
    public synchronized void unlock() {

        notify();
        isHoldLock = false;

    }








    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
