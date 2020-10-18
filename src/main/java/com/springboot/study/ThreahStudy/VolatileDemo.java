package com.springboot.study.ThreahStudy;

class Mydata{
    volatile int i;
}

public class VolatileDemo {

    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++mydata.i;
            System.out.println(Thread.currentThread().getName()+"线程将值修改为"+ mydata.i);
        },"aaa").start();
        while (mydata.i == 0 ){
            //System.out.println("主线程不知道改了 还是0呢");
        }

        System.out.println("执行完毕");

    }
}
