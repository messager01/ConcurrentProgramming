package com.xdclass.thread.demo;

public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        thread.setName("xdclass");
        thread.start();
    }
}
