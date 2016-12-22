package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Car;

/**
 * 订单表
 * 
 * @author 潘希城
 *
 */
public interface OrderDao {

	// 根据购物车的product_id和user_id向订单表插入数据
	int insert(@Param(value = "car") Car car);

}
