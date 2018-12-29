package com.springboot.springboot.dao.mapper;

import com.springboot.springboot.dao.model.ClassRecordDatail;

public interface ClassRecordDatailMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassRecordDatail record);

    int insertSelective(ClassRecordDatail record);

    ClassRecordDatail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassRecordDatail record);

    int updateByPrimaryKey(ClassRecordDatail record);
}