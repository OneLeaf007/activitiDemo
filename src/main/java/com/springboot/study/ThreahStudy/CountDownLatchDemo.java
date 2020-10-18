package com.springboot.study.ThreahStudy;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <7 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"==========被灭");
                countDownLatch.countDown();
            },CountryEnum.getCountryName(i).getResMassage()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("秦统一六国");

    }


}
