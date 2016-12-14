package com.hill.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hill.entity.Users;
import com.hill.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/{userId}/detail",method=RequestMethod.GET)
	public String justOne(@PathVariable("userId") int userId,Model model){
		Users users=userService.getById(userId);
		model.addAttribute("users", users);
		return "one";
	}
	@RequestMapping(value="/{userId}/{userName}/detail",method=RequestMethod.GET)
	public String selectOne(@PathVariable("userId") int userId,@PathVariable("userName") String userName,Model model){
		Users users=userService.getByIdAndName(userId, userName);
		model.addAttribute("users", users);
		return "two";
	}
}
