package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.StoreDetail;


public interface IStoreRegister {
	  public int InserStoreDetail(@Param("storeDetail") StoreDetail storeDetail);
	  public void InsertStore(@Param("sellerName")String sellerName,@Param("sellerPassword")String sellerPassword,@Param("sellerDetailId")int sellerDetailId);
}
