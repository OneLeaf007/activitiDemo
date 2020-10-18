package com.springboot.study.ThreahStudy;


import java.util.concurrent.atomic.AtomicInteger;

class Mydata01{
    int i = 0;
    AtomicInteger a = new AtomicInteger();
}
public class AutomicDemo {
    public static void main(String[] args) {
        Mydata01 mydata01 = new Mydata01();

        //ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    mydata01.i++;
                    mydata01.a.getAndIncrement();
                }
            }).start();

        }


        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(mydata01.i);
        System.out.println(mydata01.a);



    }





}
