package com.hill.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hill.dao.CarsDao;
import com.hill.entity.Car;
import com.hill.service.CarsService;

/**
 * CarsService��ʵ����
 * @author ��ϣ��
 *
 */
@Service
public class CarsServiceImp implements CarsService{

	@Resource
	private CarsDao carsDao;
	
	@Override
	public List<Car> getCarByName(String userName) {
		return carsDao.getCarByName(userName);
	}

	@Override
	public void deleteById(int id) {
		carsDao.deleteById(id);
	}

	
	@Override
	public Car getCarById(int id) {
		return carsDao.getCarById(id);
	}

}
