package com.springboot.study.ThreahStudy;

import java.util.concurrent.CopyOnWriteArrayList;

public class SigletonDemo {

    private static SigletonDemo sigletonDemo;

    private  SigletonDemo() {
        System.out.println(Thread.currentThread().getName() + "线程------调用构造方法创建对象-------");
    }

    public  static SigletonDemo getInstant(){
       // CopyOnWriteArrayList
        if(sigletonDemo ==null){
            synchronized (SigletonDemo.class){
                if(sigletonDemo ==null) {
                    sigletonDemo = new SigletonDemo();
                }
            }
        }
        return sigletonDemo;
    }

    public static void main(String[] args) {


        for (int i = 0; i <100000 ; i++) {
            new Thread(()->{
                SigletonDemo.getInstant();
            }).start();

        }

       /* System.out.println(SigletonDemo.getInstant() ==SigletonDemo.getInstant() );
        System.out.println(SigletonDemo.getInstant() ==SigletonDemo.getInstant() );
        System.out.println(SigletonDemo.getInstant() ==SigletonDemo.getInstant() );
        for (int i = 0; i <10 ; i++) {
            new Thread(new C()).start();
        }
        for (int i = 0; i <10 ; i++) {
            new D().start();
        }*/
       while(Thread.activeCount()>2){
           Thread.yield();
       }
        System.out.println(sigletonDemo);
    }
}

class C implements Runnable{
    @Override
    public void run() {
        SigletonDemo.getInstant();
    }
}

class D extends Thread{
    @Override
    public void run() {
        SigletonDemo.getInstant();
    }
}
