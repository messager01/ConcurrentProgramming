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
