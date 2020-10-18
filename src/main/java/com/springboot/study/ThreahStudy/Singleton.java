package com.springboot.study.ThreahStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Singleton {


    private static Singleton singleton;

    private Singleton( ) {
        System.out.println("进入无参构造函数创建新对象");
    }

    public static Singleton getInstant(){
        if(singleton==null){

           /* synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }*/
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {

        ExecutorService executorService =Executors.newFixedThreadPool(10);
        for (int i = 0; i <10 ; i++) {
            executorService.execute(()->{
                Singleton.getInstant();
                System.out.println(Thread.currentThread().getName() + "创建对象");
            });
            /*new Thread(()->{
                Singleton.getInstant();
                //System.out.println(Thread.currentThread().getName() + "创建对象");
            }).start();*/
        }
        executorService.shutdown();


    }



}
