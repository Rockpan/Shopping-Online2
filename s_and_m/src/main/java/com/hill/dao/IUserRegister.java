package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.User;
import com.hill.entity.UserDetail;

public interface IUserRegister {
  public int InserUserDetail(@Param("userDetail") UserDetail userDetail);
  public void InsertUser(@Param("userName")String userName,@Param("userPassword")String userPassword,@Param("userDetailId")int userDetailId);
}
