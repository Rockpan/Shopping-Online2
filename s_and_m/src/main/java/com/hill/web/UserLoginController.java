package com.hill.web;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hill.serviceImp.UserLoginService;

@Controller
public class UserLoginController {
	@Resource
	UserLoginService userLoginService;
	@Autowired
	HttpServletRequest request;

	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value="doLogin",method=RequestMethod.POST)
	public String doLogin() {
		String username = null;
		String password = null;
		try {
			request.setCharacterEncoding("utf-8");
			username = request.getParameter("username");
			password = request.getParameter("password");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String system=userLoginService.handleUser(username, password);
		if ("success".equals(system)) {
			return "allProduct";
		}else {
			request.setAttribute("loginError", "用户名或密码错误");
			return "login";
		}
		
	}

}
