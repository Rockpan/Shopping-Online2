package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Users;

public interface UserDao {

	Users getUserById(int userId); 
	
	Users getUserByIdAndName(@Param("userId") int userId,@Param("userName") String userName);
	
}
