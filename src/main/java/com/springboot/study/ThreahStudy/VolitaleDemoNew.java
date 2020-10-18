package com.springboot.study.ThreahStudy;

import java.util.concurrent.atomic.AtomicInteger;

class Data{
    volatile AtomicInteger i=new AtomicInteger();

    int j = 0;
}
public class VolitaleDemoNew {
    public static void main(String[] args) {
        Data mydata01 = new Data();

      /*  new Thread(()->{
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            mydata01.i+=1;
            System.out.println("新线程已经将i修改为"+mydata01.i);

        }).start();

        while (mydata01.i==0){

        }
        System.out.println(mydata01.i);

    }*/
      A a = new A(mydata01);

        for (int i = 0; i <20 ; i++) {
            Thread t = new Thread(a,String.valueOf(i));
            t.start();
            B b = new B(mydata01);
            b.start();

        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(mydata01.i);
        System.out.println(mydata01.j);



    }
}

    class A implements Runnable {
    public Data data ;

    public A(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            data.i.getAndIncrement();
            data.j+=1;
        }
        System.out.println(Thread.currentThread().getName() +"-----------"+data.i);
    }
}
class B extends Thread {
    public Data data ;
    public B(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            data.i.getAndIncrement();
        }
    }
}
