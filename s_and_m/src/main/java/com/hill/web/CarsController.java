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
 * ���ﳵ�Ŀ��Ʋ� ��������ѯ��ɾ��������
 * 
 * @author ��ϣ��
 *
 */
@Controller
public class CarsController {

	@Resource
	private CarsService carsService;

	@Resource
	private OrderService orderService;

	/**
	 * ��ȡ���ﳵ��Ʒ�б�
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
	 * ���ݹ��ﳵidɾ����Ϣ
	 * 
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "/{deleteId}/CarsDelete", method = RequestMethod.GET)
	public void deleteCars(@PathVariable("deleteId") int id, HttpServletResponse response) {
		carsService.deleteById(id);
		try {
			String name = URLEncoder.encode("��ϣ��", "utf-8");
			System.out.println(name);
			response.sendRedirect("http://localhost:8080/s_and_m/" + name + "/CarsDetail");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����ѡ�����Ʒ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/CarsBalance", method = RequestMethod.GET)
	public String BalanceCars(@RequestParam(value = "carid", required = true) int[] id) {
		for (int i = 0; i < id.length; i++) {
			// ͨ�����ﳵid��ѯ���ﳵ�е�product_id��user_id
			Car car = carsService.getCarById(id[i]);
			// ɾ����Ӧ�Ĺ��ﳵ��Ϣ
			carsService.deleteById(id[i]);
			// �򶩵����������
			orderService.insert(car);
		}
		return "buy_success";
	}
}
