package com.xdclass.thread.interrupt;

public class InteruptDemo implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InteruptDemo());
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
    }
}
