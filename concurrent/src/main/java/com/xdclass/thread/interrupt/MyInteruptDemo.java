package com.xdclass.thread.interrupt;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class MyInteruptDemo implements Runnable {

    private static volatile boolean FLAG = true;
    @Override
    public void run() {
        while (FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyInteruptDemo());
        thread.start();
        Thread.sleep(1000L);
        FLAG = false;
    }
}
