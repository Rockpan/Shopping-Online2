package com.hill.dao;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Car;

/**
 * ������
 * 
 * @author ��ϣ��
 *
 */
public interface OrderDao {

	// ���ݹ��ﳵ��product_id��user_id�򶩵����������
	int insert(@Param(value = "car") Car car);

}
