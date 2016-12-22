package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.User;

public interface IUserLogin {
  public User selectOneUser(@Param("userName")String userName,@Param("userPassword")String userPassword);
}
