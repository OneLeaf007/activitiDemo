package com.springboot.study.service.Impl;

import com.springboot.study.entiy.BorrowInfo;
import com.springboot.study.mapper.BorrowInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BatchInster implements Runnable {

    BorrowInfo borrowInfo;
    @Autowired
    BorrowInfoMapper borrowInfoMapper;
    Lock lock = new ReentrantLock();




    @Override
    public void run() {
        try {
            lock.lock();
            borrowInfoMapper.inster(borrowInfo);
        }catch (Exception e){
            System.out.println("异常数据" + borrowInfo.toString());
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        System.out.println(Thread.currentThread().getName()+"线程处理:" +borrowInfo.getBorrow_name());
    }


    /*@Override
    public Object call() throws Exception {
        return null;
    }*/

    public BorrowInfo getBorrowInfo() {
        return borrowInfo;
    }

    public void setBorrowInfo(BorrowInfo borrowInfo) {
        this.borrowInfo = borrowInfo;
    }
}
