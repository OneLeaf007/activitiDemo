package com.springboot.study.mapper;

import com.springboot.study.entiy.BorrowInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BorrowInfoMapper {
    BorrowInfo selectById(@Param("id") String id);

    Integer inster(@Param("borrowInfo") BorrowInfo borrowInfo);
}
