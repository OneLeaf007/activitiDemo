package com.springboot.study.ThreahStudy;

public class DeadLockDemo
{
    private String lockA;

    private String lockB;

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() +"获得m1方法锁");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"尝试获得m2方法锁");
        this.m2();
        System.out.println(Thread.currentThread().getName() +"尝试获得m2方法锁成功");

    }

    public synchronized  void m2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m1();
        System.out.println(Thread.currentThread().getName() +"获得m2方法锁");
    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        new Thread(()->{
            deadLockDemo.m1();
            deadLockDemo.m2();

        }).start();
        new Thread(()->{
            deadLockDemo.m2();
            deadLockDemo.m1();
        }).start();

    }

}
