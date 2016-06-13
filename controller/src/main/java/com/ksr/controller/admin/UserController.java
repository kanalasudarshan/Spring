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
import com.ksr.util.ecdc.EncriptDecriptUtil;
import com.ksr.util.logger.KSRLogger;

@RequestMapping("/admin")
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	Class<UserController> classObj=UserController.class;
	
	@RequestMapping("/createuser")
	public ModelAndView createUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO,BindingResult result){
		ModelAndView mav=new ModelAndView();
		try{
			if(result.getErrorCount()==0){
				userDTO.setUserName(EncriptDecriptUtil.getInstance().encript(userDTO.getUserName()));
				userDTO.setActive(true);
				userService.createUser(userDTO);
				mav.setViewName("home");
			}else{
				mav.setViewName("registration");
			}
		}catch(Exception exception){
			 KSRLogger.error(classObj, exception);
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
