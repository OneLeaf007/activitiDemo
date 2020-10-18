package com.springboot.study.service.Impl;


import com.springboot.study.entiy.EntiyTest;
import com.springboot.study.mapper.EntiyTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntiyTestServiceImpl {
    @Autowired
    EntiyTestMapper entiyTestMapper;

    public EntiyTest get(String id ){
        return entiyTestMapper.selectById(id);
    }
}

