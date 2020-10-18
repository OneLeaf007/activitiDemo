package com.springboot.study.common;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GloabExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(HttpServletRequest request,Exception e){
        e.printStackTrace();
        return "服务器忙！";
    }
}
