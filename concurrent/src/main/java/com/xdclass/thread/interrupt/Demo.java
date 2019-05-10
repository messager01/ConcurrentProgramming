package com.xdclass.thread.interrupt;

import com.xdclass.thread.hang.DeadDemo;

public class Demo implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo());
        thread.start();
        Thread.sleep(2000L);
        thread.stop();
    }
}
