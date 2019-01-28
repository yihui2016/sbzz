package com.springboot.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springboot.springboot.dao.model.UserLog;

public interface UserLogMapper {
	int insert(UserLog record);

	List<UserLog> listLogs(@Param("ids") List<String> ids, @Param("startTime") Long startTime,
			@Param("endTime") Long endTime, @Param("category") Long category, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	long countAll(@Param("ids") List<String> ids, @Param("startTime") Long startTime, @Param("endTime") Long endTime,
			@Param("category") Long category, @Param("offset") Integer offset, @Param("limit") Integer limit);

}