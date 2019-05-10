package com.xdclass.safe;


/*
*
* 懒汉式单例模式
* */
public class LazySingleton {

    //构造器私有化
    private LazySingleton(){

    }


    //声明
   private static volatile LazySingleton lazySingleton = null;   //  添加上volatile 防止指令重排！！

    //  可以使用 synchronized  修饰 这个静态方法
    public  static LazySingleton getInstance() throws InterruptedException {
        //判断实例是否为空   否则直接返回
        if( null== lazySingleton){
            //  模拟实例化耗时
            Thread.sleep(1000);
         synchronized (LazySingleton.class){            //double check
            if (null == lazySingleton){
                lazySingleton = new LazySingleton();
            }
         }
        }
        return lazySingleton;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                try {
                    System.out.println(LazySingleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
/*
*
*      线程安全问题成因：
*      1.  多线程环境
*      2.  多个线程操作统一共享资源
*      3.  对该共享资源进行了非原子性的操作
*
*      如何解决？
*         打破成因中三点的任意一点即可
*         1.  将多线程 改变为单线程   （必要的代码加锁 ）
*         2.  多线程不操作同一共享的资源  （ThreadLocal  、 不共享、 共享资源不可变  用final修饰）
*         3.  对该共享的资源进行原子性的操作( 加锁  使用JDK自带的原子性操作的类、JUC提供的并发工具)
*
*
* */