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
	
	//���ݹ��ﳵ��product_id��user_id�򶩵����������
	@Override
	public int insert(Car car) {
		return orderDao.insert(car);
	}

}
