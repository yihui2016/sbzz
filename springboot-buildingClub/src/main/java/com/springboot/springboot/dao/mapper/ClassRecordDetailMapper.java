package com.springboot.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springboot.springboot.dao.model.ClassRecordDetail;

public interface ClassRecordDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassRecordDetail record);

    int insertSelective(ClassRecordDetail record);

    ClassRecordDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassRecordDetail record);

    int updateByPrimaryKey(ClassRecordDetail record);
    
    List<ClassRecordDetail> selectByClassRecordId(String classRecordId);

    int deleteByRecordIdAndIdsNotIn(@Param("recordId")String recordId,@Param("ids") List<String> ids);

}