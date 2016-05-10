package com.ksr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
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
		return "login";
	}	
}
