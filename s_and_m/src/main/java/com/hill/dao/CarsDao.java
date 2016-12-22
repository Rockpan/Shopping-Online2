package com.hill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hill.entity.Car;

/**
 * 
 * @author ��ϣ��
 *
 */
public interface CarsDao {

	//����ʹ��
	//List<Car> getCarByName(String userName); 
	
	//�����û�����ѯ���ݿ�
	List<Car> getCarByName(@Param("userName") String userName);
	
	//���ݹ��ﳵidɾ������
	void deleteById(@Param("id") int id);
	
	//���ݹ��ﳵid��ѯproduct_id��user_id
	Car getCarById(@Param("id") int id);
	
}
