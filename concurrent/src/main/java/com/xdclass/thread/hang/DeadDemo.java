package com.xdclass.thread.hang;


/*
* suspend 死锁演示
* */
public class DeadDemo implements Runnable {
    private static Object object = new Object();
    @Override
    public void run() {
        // 持有资源
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"占用资源");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName()+"释放了资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeadDemo());
        thread.setName("对比线程");
        thread.start();
        Thread.sleep(1000L);
        thread.resume();

        Thread deadThread = new Thread(new DeadDemo());
        deadThread.setName("死锁线程");
        deadThread.start();
        deadThread.resume();
    }
}
