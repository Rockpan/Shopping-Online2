package com.hill.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hill.entity.Car;
import com.hill.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class CarTest {

	@Resource
	private CarsDao carsDao;

	@Resource
	private OrderDao orderDao;

	// @Test
	public void testSelect() {
		List<Car> car = carsDao.getCarByName("≈Àœ£≥«");
		Iterator<Car> i = car.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

	@Test
	public void testSelectById() {
		Car car = carsDao.getCarById(1);
		System.out.println(car);
	}

	// @Test
	public void testDelete() {
		carsDao.deleteById(4);
		List<Car> car = carsDao.getCarByName("≈Àœ£≥«");
		Iterator<Car> i = car.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

	// @Test
	public void testInsertOrder() {
		Order order = new Order();
		order.setProduct_id(1);
		order.setUser_id(1);
		//int a = orderDao.insert(order);
		//System.out.println(a);

	}

}
