package com.hill.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hill.dao.IUserLogin;
import com.hill.entity.User;

@Service
public class UserLoginService {
	
	@Resource
	private IUserLogin userLoginDao;
	
    public String handleUser(String userName,String userPassword){
    	
    User user=userLoginDao.selectOneUser(userName, userPassword);
  
      if (user.getUserPassword()!=null&&userPassword.equals(user.getUserPassword())) {
    	  return "success";
	}else {
		  return "fail";
	}
    	
    }
	
}
