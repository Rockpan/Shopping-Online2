package com.hill.serviceImp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hill.dao.UserDao;
import com.hill.entity.Users;
import com.hill.service.UserService;

@Service
public class UserServiceImp implements UserService {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
    private UserDao userDao;
	
	public Users getById(int id) {
		
		return userDao.getUserById(id);
	}

	public Users getByIdAndName(int id, String userName) {
		
		return userDao.getUserByIdAndName(id, userName);
	}

}
