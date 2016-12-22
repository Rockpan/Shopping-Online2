package com.hill.serviceImp;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.hill.dao.IUserRegister;

import com.hill.entity.UserDetail;

@Service
public class UserRegisterService {
	@Resource
	IUserRegister userRegiterDao;
	
	public int getUserDetail(UserDetail userDetail){
		
		userRegiterDao.InserUserDetail(userDetail);
		return  userDetail.getUserDetailId();
	}
	
	
	public String handleRegisterUser(String userName,String password,String rPassword,int userDetailId){
		
		if (password.equals(rPassword)) {
			try {
			 userRegiterDao.InsertUser(userName, password,userDetailId);
			 
			} catch (Exception e) {
				e.printStackTrace();
				return "repeatUsername";
			}
			return "success";
			  
		}else {
		  
		  return "fail";
		}
		
		
	}
}
