package com.springboot.study.service.Impl;

import com.springboot.study.mapper.BorrowInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowInfoServiceImpl  implements BorrowInfoService{
    @Autowired
    BorrowInfoMapper borrowInfoMapper;
}
