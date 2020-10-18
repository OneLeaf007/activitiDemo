package com.springboot.study.ThreahStudy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteAndReadLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{

                myCache.put(Thread.currentThread().getName().toString(),Thread.currentThread().getName().toString());

            }).start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{

                myCache.get(Thread.currentThread().getName().toString());

            }).start();
        }
    }
}

class MyCache {
    Map<String, Object> map = new HashMap<String, Object>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String Key, Object value) {

        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始写入===========");

            Thread.sleep(1000);
            map.put(Key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成============");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }

    }

    public void get(String key){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "开始读取");
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成");
        lock.readLock().unlock();
    }

}