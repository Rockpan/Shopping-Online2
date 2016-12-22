package com.hill.web;



import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hill.entity.UserDetail;
import com.hill.serviceImp.UserRegisterService;

/*
 * author :胡新健
 * 
 * date:2016-12-20
 * */
@Controller
public class UserRegisterController {
  @Resource
  private  UserRegisterService userRegisterService;
  @Autowired  
  private  HttpServletRequest request; 
  
  
  
   @RequestMapping("registe")
   public String  userRegister(){
	   return "register";
   }
   
 @RequestMapping(value="doRegiste",method=RequestMethod.POST)
  public String doUserRegister(){
	 
	      String realName=null;
	      String sex=null;
	      String IdCard=null;
	      String phone=null;
	      String address=null;
	     try {
	    	 
			request.setCharacterEncoding("utf-8");
			realName = request.getParameter("realName");
		    sex= request.getParameter("sex");
		    IdCard = request.getParameter("IdCard");
		    phone= request.getParameter("phone");
		    address= request.getParameter("address");
		   
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     UserDetail userdetail=new UserDetail();
	     userdetail.setUserRealName(realName);
	     userdetail.setUserSex(sex);
	     userdetail.setUserIdCard(IdCard);
	     userdetail.setUserPhone(phone);
	     userdetail.setUserAddress(address);
	     
	     
	   int userDetailId =userRegisterService.getUserDetail(userdetail);
	   System.out.println("++++++++======================userDetailId "+userDetailId );
	   HttpSession session= request.getSession();
	   session.setAttribute("userDetailId", userDetailId);
	    //request.setAttribute("userDetailId", userDetailId);
	    System.out.println("++++++++++0000"+request.getAttribute("userDetailId"));
	   if (userDetailId!=0) {
		   return "register2";
	}else {
		   return "fail";
	}	
	    
  }
 
 
    @RequestMapping(value="doUserPregister",method=RequestMethod.POST)
    public String doUserPregister(){
    	String userName= null;
    	String password=null;
    	String rPassword=null;
    	try {
			request.setCharacterEncoding("utf-8");
			userName= request.getParameter("registerName");
	        password=request.getParameter("registerPassword");
	    	rPassword=request.getParameter("registerRpassword");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	HttpSession session= request.getSession();
 	    int userDetailId=(int) session.getAttribute("userDetailId");
    	//int userDetailId=(int) request.getAttribute("userDetailId");
    	System.out.println(userDetailId);
    	System.out.println("username"+userName+"password"+password+"rpassword"+rPassword+"userDetailId"+userDetailId);
    	String system=userRegisterService.handleRegisterUser(userName, password, rPassword, userDetailId);
    	System.out.println("++++++++======================system"+system);
    	if ("success".equals(system)&&system=="success") {
    		return "registerSuccess";
		}else if ("fail".equals(system)) {
			request.setAttribute("fail", "两次输入不一致");
			return "register2";
		}else {
		   request.setAttribute("repeatUsername", "用户名已存在");
		   return "register2";
		}
		
    }
 
}
