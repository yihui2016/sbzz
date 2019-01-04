package com.springboot.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springboot.springboot.dao.model.User;

public interface UserMapper {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> listUsers();

	User selectByPhone(String phone);

	List<User> selectByPid(@Param("pid") String pid, @Param("offset") Integer offset, @Param("limit") Integer limit);

	List<User> selectAllByPid(@Param("pid") String pid);

	long countByPid(@Param("pid") String pid);

	List<User> selectAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

	long countAll();

}