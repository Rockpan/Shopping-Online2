package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Store;


public interface IStoreLogin {
	  public Store selectOneStore(@Param("sellerName")String sellerName,@Param("sellerPassword")String sellerPassword);
}
