package com.springboot.springboot.dao.mapper;

import java.util.List;

import com.springboot.springboot.dao.model.BodyParam;

public interface BodyParamMapper {
    int deleteByPrimaryKey(String id);

    int insert(BodyParam record);

    int insertSelective(BodyParam record);

    BodyParam selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BodyParam record);

    int updateByPrimaryKey(BodyParam record);
    
    List<BodyParam> selectByUserId(String userId);

}