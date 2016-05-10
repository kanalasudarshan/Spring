package com.ksr.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksr.service.admin.UserService;

@RequestMapping("/admin")
@Controller
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@RequestMapping("/crateuser")
	public String createUser(){
		
		return "home";
	}
	
	@RequestMapping("/updateuser")
	public String updateUser(){
		
		return "home";
	}
	
	@RequestMapping("/deleteuser")
	public String deleteUser(){
		
		return "home";
	}
}
