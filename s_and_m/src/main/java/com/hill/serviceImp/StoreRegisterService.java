package com.hill.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hill.dao.IStoreRegister;
import com.hill.entity.StoreDetail;
import com.hill.entity.UserDetail;

@Service
public class StoreRegisterService {
	@Resource
	IStoreRegister storeRegisterDao;

	public int getStoreDetail(StoreDetail storeDetail) {

		storeRegisterDao.InserStoreDetail(storeDetail);
		return storeDetail.getSellerDetailId();
	}
	
	public String handleRegisterStore(String sellerName,String password,String rPassword,int sellerDetailId){
		if (password.equals(rPassword)) {
			try {
				storeRegisterDao.InsertStore(sellerName, password, sellerDetailId);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "repeatStorename";
			}
			
			
			return "success";
		}else {
			return "fail";
		}
		
	}
	
}
