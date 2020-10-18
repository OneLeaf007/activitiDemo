package com.springboot.study.ThreahStudy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingConsumerAndProviderDemo {
    public static void main(String[] args) {
        ConsumerBlockingDemo consumerBlockingDemo = new ConsumerBlockingDemo(new ArrayBlockingQueue(3));
        new Thread(()->{
            consumerBlockingDemo.Provider();
        },"生产线程").start();
        new Thread(()->{
            consumerBlockingDemo.Consumer();
        },"消费线程").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumerBlockingDemo.stop();


    }
}

class ConsumerBlockingDemo{
    private volatile Boolean Flag=true;
    BlockingQueue blockingQueue = null;

    private AtomicInteger atomicInteger = new AtomicInteger();

    public ConsumerBlockingDemo(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("使用=========："+this.blockingQueue.getClass().getName());
    }
    public void Provider(){
        String data = null;
        while(Flag){
            data = String.valueOf(atomicInteger.getAndIncrement());
            try {
                this.blockingQueue.offer(data,2L,TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName()+"生产了"+data);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("======生产线程停止工作=======");
    }

    public void Consumer(){
        String data = null;

        while(Flag){
            try {
                data=String.valueOf(this.blockingQueue.poll(2L,TimeUnit.SECONDS));
                System.out.println(Thread.currentThread().getName()+"消费了"+data);
                if(null==data||"".equals(data) ){
                    Flag=false;
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("======消费线程停止工作=======");
    }

    public void stop(){
        this.Flag=false;
        System.out.println("停止工作");
    }
}
