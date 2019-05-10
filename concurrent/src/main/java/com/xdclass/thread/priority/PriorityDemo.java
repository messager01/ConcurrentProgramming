package com.xdclass.thread.priority;

/*
* 线程优先级demo
* */
public class PriorityDemo{

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.setName("线程1");
        thread.setPriority(Thread.MIN_PRIORITY);

        Thread thread2 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread2.setName("线程2");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread2.start();
    }
}
