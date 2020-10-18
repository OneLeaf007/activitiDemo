package com.springboot.study.controller;

import com.springboot.study.entiy.BorrowInfo;
import com.springboot.study.mapper.BorrowInfoMapper;
import com.springboot.study.service.Impl.BatchInster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@RestController
public class BorrowInfoController {

    //@Autowired
    //BorrowInfoService borrowInfoService;
    @Autowired
    BorrowInfoMapper borrowInfoMapper;

    @Autowired
    BatchInster batchInster;
    volatile InputStream inputStream;


    public BorrowInfo getBorrowInfoByid(@RequestParam("id") String id){
        System.out.println(111111);
        BorrowInfo borrowInfo=null;
        try {
            borrowInfo =   borrowInfoMapper.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return borrowInfo;
    }
    @RequestMapping(value = "/getBorrowInfo")
    void batchInster(){
        List list = Arrays.asList("a","B","c","d","e","f","g","h","i","j");
       /* BlockingQueue<Runnable> workQueue = new BlockingQueue<Runnable>() {
        }*/
        ExecutorService executorService = new ThreadPoolExecutor(5,20,2000,TimeUnit.HOURS,new LinkedBlockingDeque<>());//Executors.newFixedThreadPool(10);// //
        for ( int i = 0; i<list.size(); i++){
            BorrowInfo borrowInfo = new BorrowInfo();
            borrowInfo.setBorrow_name((String) list.get(i));
            System.out.println(list.get(i));
            //executorService.execute(new BatchInster(borrowInfo,borrowInfoMapper));
            batchInster.setBorrowInfo(borrowInfo);
            executorService.execute((batchInster));
        }


    }


}
