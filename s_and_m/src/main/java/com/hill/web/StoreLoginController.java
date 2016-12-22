package com.hill.web;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hill.serviceImp.StoreLoginService;

@Controller
public class StoreLoginController {
	
	@Resource
	StoreLoginService storeLoginService;
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("toStoreLogin")
     public String toStoreLogin(){
		return "storeLogin";
	} 
	@RequestMapping(value="doStoreLogin",method=RequestMethod.POST)
	public String doStoreLogin(){
		String sellername = null;
		String password = null;
		try {
			request.setCharacterEncoding("utf-8");
			sellername = request.getParameter("sellername");
			password = request.getParameter("password");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String system=storeLoginService.handleStore(sellername, password);
		if ("success".equals(system)) {
			return "sellerFunction";
		}else {
			request.setAttribute("sellerLoginEror", "用户名或密码错误");
			return "storeLogin";
		}
		
	}
	
}
