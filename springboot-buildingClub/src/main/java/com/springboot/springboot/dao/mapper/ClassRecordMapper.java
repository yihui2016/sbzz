package com.springboot.springboot.dao.mapper;

import com.springboot.springboot.dao.model.ClassRecord;

public interface ClassRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassRecord record);

    int insertSelective(ClassRecord record);

    ClassRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassRecord record);

    int updateByPrimaryKey(ClassRecord record);
}