package com.ksr.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ksr.dto.UserDTO;
import com.ksr.service.admin.UserService;

@RequestMapping("/admin")
@Controller
public class UserController {
	
	@Autowired
	UserService UserService;
	
	@RequestMapping("/createuser")
	public ModelAndView createUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO,BindingResult result){
		ModelAndView mav=new ModelAndView();
		if(result.getErrorCount()==0){
			mav.setViewName("home");
		}else{
			mav.setViewName("registration");
		}
		return mav;
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
