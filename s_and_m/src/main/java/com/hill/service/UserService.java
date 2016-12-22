package com.hill.service;



import com.hill.entity.Users;

public interface UserService {

	Users getById(int id);
	
	Users getByIdAndName(int id, String userName);
}
