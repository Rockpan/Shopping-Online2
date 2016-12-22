package com.hill.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Car;

/**
 * 
 * @author 潘希城
 *
 */
public interface CarsService {

	// 根据用户名查询购物车商品
	List<Car> getCarByName(String userName);

	// 根据购物车id删除信息
	void deleteById(int id);

	// 根据购物车id查询product_id和user_id
	Car getCarById(int id);
}
