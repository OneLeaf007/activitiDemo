package com.springboot.study.controller;


import com.springboot.study.entiy.EntiyTest;
import com.springboot.study.service.Impl.EntiyTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataScoreTest")
public class EntiyTestController {
    @Autowired
    EntiyTestServiceImpl entiyTestService;

    @GetMapping("/test")
    public EntiyTest TestDataScore(@RequestParam("id") Integer id){

        System.out.println(11111);


        return entiyTestService.get(String.valueOf(id));
    }


}
