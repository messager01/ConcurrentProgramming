package com.xdclass.safe;

public class SynDemo {

    //修饰方法
    public synchronized void out() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);

    }

    //修饰静态方法
    public synchronized static  void staticOut() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    private Object lock = new Object();
    //修饰代码块
    public void myout() throws InterruptedException {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000L);
        }
    }

    public static void main(String[] args) {
        SynDemo synDemo = new SynDemo();
        SynDemo synDemo2 = new SynDemo();

        new Thread(()->{
            try {
                synDemo.myout();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                synDemo.myout();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
