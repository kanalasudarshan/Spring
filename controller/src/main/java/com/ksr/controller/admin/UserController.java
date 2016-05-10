package com.ksr.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksr.service.admin.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@RequestMapping("/home")
	public String getHome(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String getLogin(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String getLogout(){
		return "logout";
	}	

}
