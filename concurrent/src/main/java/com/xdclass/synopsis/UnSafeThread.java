package com.xdclass.synopsis;


import sun.applet.Main;

import java.util.concurrent.CountDownLatch;

/*
* 线程不安全操作
* */
public class UnSafeThread {
    private static Integer num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

   /*
   * 每次调用对num 进行++的操作
   * */
    public  static void inCreate(){
            num ++;

    }

    public static void main(String[] args) {
        for(int i = 0;i < 10; i++){
            new Thread(()->{
                for(int j = 0; j <100;j ++){
                    inCreate();
                   /* try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
                // 每个线程完成之后   调用CountDownLatch
                countDownLatch.countDown();
            }).start();
        }
        while (true){
            if(countDownLatch.getCount() == 0){
                System.out.println(num);
            }
            break;
        }
        System.out.println(num);
    }
}
