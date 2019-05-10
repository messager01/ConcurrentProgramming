package com.xdclass.thread.interrupt;

public class UnsafeWithStop implements Runnable {

    private static int i = 0;
    private static int j = 0;
    @Override
    public void run() {
        i++;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    public static void print(){
        System.out.println("i的值为："+i);
        System.out.println("j的值为："+j);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new UnsafeWithStop());
        thread.start();
        Thread.sleep(1000L);
        thread.stop();
        print();
    }
}
