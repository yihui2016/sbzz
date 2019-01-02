package com.springboot.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springboot.springboot.dao.model.ClassRecord;

public interface ClassRecordMapper {
	int deleteByPrimaryKey(String id);

	int insert(ClassRecord record);

	int insertSelective(ClassRecord record);

	ClassRecord selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ClassRecord record);

	int updateByPrimaryKey(ClassRecord record);

	List<ClassRecord> selectByUserIdAndStartTimeAndEndTime(@Param("userId") String userId,
			@Param("startTime") Long startTime, @Param("endTime") Long endTime);

	List<ClassRecord> selectByUserId(@Param("userId") String userId, @Param("offset") Integer offset,
			@Param("limit") Integer limit);
	
	long countByUserId(@Param("userId") String userId);
}