package com.xdclass.synopsis;

/*
* 死锁demo
* */
public class DeadLockDemo {
    private static final Object Hair_A = new Object();

    private static final Object Hair_B = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (Hair_A){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Hair_B){
                    System.out.println("A成功抓住B的头发");
                }
            }
        }).start();


        new Thread(()->{
            synchronized (Hair_B){
                synchronized (Hair_A){
                    System.out.println("B成功抓住A的头发");
                }
            }
        }).start();
    }
}
