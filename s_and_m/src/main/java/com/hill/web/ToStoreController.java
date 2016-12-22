package com.hill.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToStoreController {

	
  @RequestMapping("toStore")
  public String toStore(){
	  
	  
	  return "toStore";
  }
}
