package com.hill.web;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hill.entity.StoreDetail;
import com.hill.serviceImp.StoreRegisterService;



@Controller
public class StoreRegisterController {
	  @Autowired  
	  private  HttpServletRequest request; 
	  @Resource
	  private StoreRegisterService storeRegisterService;
	   @RequestMapping("toStoreRegister")
	   public String  toStoreRegister(){
		   return "storeRegister";
	   }
	   
	   @RequestMapping(value="doStoreRegister",method=RequestMethod.POST)
	   public String doStoreRegister(){
		      String storeName=null;
		      String realName=null;
		      String IdCard=null;
		      String phone=null;
		      String address=null;
		   
		      try {
				request.setCharacterEncoding("utf-8");
				storeName=request.getParameter("storeName");
				realName = request.getParameter("realName");
			    IdCard = request.getParameter("IdCard");
			    phone= request.getParameter("phone");
			    address= request.getParameter("address");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		    StoreDetail storeDetail=new StoreDetail();
		    
		    storeDetail.setStoreName(storeName);
		    storeDetail.setSellerRealName(realName);
		    storeDetail.setSellerIdCard(IdCard);
		    storeDetail.setSellerPhone(phone);
		    storeDetail.setSellerAddress(address);
		    int storeDetailId=storeRegisterService.getStoreDetail(storeDetail);
		    System.out.println("++++++++======================storeDetailId "+storeDetailId );
		    
		    
		    HttpSession session=request.getSession();
		    session.setAttribute("storeDetailId", storeDetailId);
		    System.out.println("++++++++++++0000000000"+session.getAttribute("storeDetailId"));
		    
		    if (storeDetailId!=0) {
				return "storeRegister2";
			}else {
				return "fail";
			}
		      
	   }
	   
	  @RequestMapping(value="doStorePregister",method=RequestMethod.POST)
	  public String doStorePregister(){
		    String sellerName= null;
	    	String password=null;
	    	String rPassword=null;
	    	try {
				request.setCharacterEncoding("utf-8");
				sellerName= request.getParameter("registerName");
		        password=request.getParameter("registerPassword");
		    	rPassword=request.getParameter("registerRpassword");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	HttpSession session= request.getSession();
	 	    int storeDetailId=(int) session.getAttribute("storeDetailId");
	 	 
	    	System.out.println("sellerName"+sellerName+"password"+password+"rpassword"+rPassword+"storeDetailId"+storeDetailId);
	    	String system=storeRegisterService.handleRegisterStore(sellerName, password, rPassword, storeDetailId);
	    	System.out.println("++++++++======================system"+system);
	    	if ("success".equals(system)&&system=="success") {
	    		return "registerSuccess";
			}else if ("fail".equals(system)) {
				request.setAttribute("Storefail", "两次输入不一致");
				return "storeRegister2";
			}else {
			   request.setAttribute("repeatStorename", "用户名已存在");
			   return "storeRegister2";
			}
	  }
			
}
