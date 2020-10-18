package com.springboot.study.ThreahStudy;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁代码验证
 *
 *
 */
public class SpinLockSDemo {
    AtomicReference <Thread>  atomicReference = new AtomicReference<>();

    Thread thrad = Thread.currentThread();

    public void lock(Thread thrad){

        while (!atomicReference.compareAndSet(null,thrad)){
        }
        System.out.println("加锁成功");
    }


    public  void unLock(Thread thrad){
        while (!atomicReference.compareAndSet(thrad,null)){

        }
        System.out.println("解锁成功");
    }
}

class TestSpinLockSDemo{

    public static void main(String[] args) {
        SpinLockSDemoData spinLockSDemoData = new SpinLockSDemoData();

        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                spinLockSDemoData.add();
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(spinLockSDemoData.i);

    }
}

class  SpinLockSDemoData{
     volatile int i=0;
    SpinLockSDemo spinLockSDemo = new SpinLockSDemo();
      void add(){
          spinLockSDemo.lock(Thread.currentThread());
        for (int j = 0; j <1000; j++) {
            i++;
        }
          spinLockSDemo.unLock(Thread.currentThread());
    }
}
