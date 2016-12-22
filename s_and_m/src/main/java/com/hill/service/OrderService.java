package com.hill.service;

import com.hill.entity.Car;

public interface OrderService {

	// 根据购物车的product_id和user_id向订单表插入数据
	int insert(Car car);
}
