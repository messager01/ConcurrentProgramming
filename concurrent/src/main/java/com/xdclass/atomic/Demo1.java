package com.xdclass.atomic;


import java.util.concurrent.atomic.AtomicInteger;

/*
*
* AtomicBoolean   AtomicInteger   AtomicLong
*
* */
public class Demo1 {
     //AtomicInteger
    //初始化实例
    private static AtomicInteger num = new AtomicInteger(0);

    public static void inCreate(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for(int j = 0; j< 100;j++){
                    inCreate();
                    System.out.println(num);
                }
            }).start();


        }
    }
}
