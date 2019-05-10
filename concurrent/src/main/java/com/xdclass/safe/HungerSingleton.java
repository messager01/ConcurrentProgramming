package com.xdclass.safe;

/*
*
*   饿汉单例    饿汉式一定是线程安全的
*
* */
public class HungerSingleton {
    private static HungerSingleton ourInstance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return ourInstance;
    }

    //  构造方法一定要私有化
    private HungerSingleton() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10 ;i++){
            new Thread(()->{
                System.out.println( HungerSingleton.getInstance());
            }).start();
        }

    }
}
