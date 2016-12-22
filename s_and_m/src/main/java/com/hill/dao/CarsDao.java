package com.hill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Car;

/**
 * 
 * @author 潘希城
 *
 */
public interface CarsDao {

	//测试使用
	//List<Car> getCarByName(String userName); 
	
	//根据用户名查询数据库
	List<Car> getCarByName(@Param("userName") String userName);
	
	//根据购物车id删除数据
	void deleteById(@Param("id") int id);
	
	//根据购物车id查询product_id和user_id
	Car getCarById(@Param("id") int id);
	
}
