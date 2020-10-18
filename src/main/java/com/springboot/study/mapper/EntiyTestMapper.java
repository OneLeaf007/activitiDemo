package com.springboot.study.mapper;

import com.springboot.study.entiy.EntiyTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EntiyTestMapper {
    EntiyTest selectById(@Param("id") String id);

}
