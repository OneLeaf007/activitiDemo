package com.springboot.study.ThreahStudy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoumserAndProviderDemo {
    public static void main(String[] args) {
        SharaData sharaData = new SharaData();
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                sharaData.incream();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                sharaData.decream();
            }
        },"BB").start();

    }






}
class SharaData{
    private int number;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void  incream(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得lock");
            Thread.sleep(1000);
            while (number!=0){
                condition.await();
            }
            number++;
            condition.signalAll();
            System.out.println(Thread.currentThread().getName()+number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放lock");
        }

    }

    public void  decream(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得lock");
            Thread.sleep(1000);
            while (number==0){
                condition.await();
            }
            number--;
            condition.signal();
            System.out.println(Thread.currentThread().getName()+number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放lock");

        }

    }

}