package com.hill.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Car;

/**
 * 
 * @author ��ϣ��
 *
 */
public interface CarsService {

	// �����û�����ѯ���ﳵ��Ʒ
	List<Car> getCarByName(String userName);

	// ���ݹ��ﳵidɾ����Ϣ
	void deleteById(int id);

	// ���ݹ��ﳵid��ѯproduct_id��user_id
	Car getCarById(int id);
}
