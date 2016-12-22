package com.hill.serviceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hill.dao.IStoreLogin;
import com.hill.entity.Store;
import com.hill.entity.User;

@Service
public class StoreLoginService {
      @Resource
      private IStoreLogin storeLoginDao;
      
	public String handleStore(String sellerName,String sellerPassword){
		 Store store= storeLoginDao.selectOneStore(sellerName, sellerPassword);
		 if (store.getSellerPassword()!=null&&sellerPassword.equals(store.getSellerPassword())) {
			return "success";
		}else {
			return "fail";
		}
		  
	}
}
