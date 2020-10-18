package com.springboot.study.ThreahStudy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable {


    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        return 1000;
    }
}

class myRun{
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY:MM:dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        FutureTask<Integer> futureTask = new FutureTask(new CallableDemo());

        new Thread(futureTask,"aa").start();



        int result= 1000;
        Thread.sleep(2000);
        int result2 = futureTask.get();

        System.out.println(result2+result);
        System.out.println(simpleDateFormat.format(new Date()));



    }

}