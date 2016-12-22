package com.hill.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hill.dao.OrderDao;
import com.hill.entity.Car;
import com.hill.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Resource
	private OrderDao orderDao;
	
	//根据购物车的product_id和user_id向订单表插入数据
	@Override
	public int insert(Car car) {
		return orderDao.insert(car);
	}

}
