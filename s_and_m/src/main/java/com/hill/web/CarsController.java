package com.hill.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hill.entity.Car;
import com.hill.service.CarsService;
import com.hill.service.OrderService;

/**
 * 购物车的控制层 操作：查询，删除，结算
 * 
 * @author 潘希城
 *
 */
@Controller
public class CarsController {

	@Resource
	private CarsService carsService;

	@Resource
	private OrderService orderService;

	/**
	 * 获取购物车商品列表
	 * 
	 * @param userName
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{userName}/CarsDetail", method = RequestMethod.GET)
	public String selectCars(@PathVariable("userName") String userName, HttpServletRequest request) {
		List<Car> carsList = carsService.getCarByName(userName);
		request.setAttribute("car", carsList);
		return "MyCars";
	}

	/**
	 * 根据购物车id删除信息
	 * 
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "/{deleteId}/CarsDelete", method = RequestMethod.GET)
	public void deleteCars(@PathVariable("deleteId") int id, HttpServletResponse response) {
		carsService.deleteById(id);
		try {
			String name = URLEncoder.encode("潘希城", "utf-8");
			System.out.println(name);
			response.sendRedirect("http://localhost:8080/s_and_m/" + name + "/CarsDetail");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 结算选择的商品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/CarsBalance", method = RequestMethod.GET)
	public String BalanceCars(@RequestParam(value = "carid", required = true) int[] id) {
		for (int i = 0; i < id.length; i++) {
			// 通过购物车id查询购物车中的product_id和user_id
			Car car = carsService.getCarById(id[i]);
			// 删除对应的购物车信息
			carsService.deleteById(id[i]);
			// 向订单表插入数据
			orderService.insert(car);
		}
		return "buy_success";
	}
}
