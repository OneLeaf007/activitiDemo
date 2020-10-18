package com.springboot.study.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "helloworld";
    }
}
