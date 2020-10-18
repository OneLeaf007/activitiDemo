package com.springboot.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello1")
public class HelloController
{
    @GetMapping("/hello")
    public String hello(){

        System.out.println(1111);
        return "helloWord1";

    }

}
