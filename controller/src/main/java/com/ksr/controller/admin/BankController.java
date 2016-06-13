package com.ksr.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksr.dto.BankDTO;
import com.ksr.service.admin.BankService;
import com.ksr.util.logger.KSRLogger;

@RequestMapping("/admin")
@Controller
public class BankController {

	private BankService bankService;
	
	private final Class<BankController> classObj=BankController.class;
	
	@RequestMapping("/createbank")
	public String createBankDetails(BankDTO bankDTO){
		try{
			bankService.createBank(bankDTO);
		}catch(Exception exception){
			KSRLogger.error(classObj, exception);
		}
		return "createBank";
	}
	
	@RequestMapping("/getbankdetails")
	public BankDTO getBankDetailsById(long bankId){
		BankDTO dto=null;
		try{
			dto=bankService.getUserDTOByUserId(bankId);
		}catch(Exception exception){
			KSRLogger.error(classObj, exception);
		}
		return dto;
	}
	
	@RequestMapping("/getallbankdetails")
	public @ResponseBody List<BankDTO> getBankDetails(){
		List<BankDTO> bankDTOList=null;
		try{
			
		}catch(Exception exception){
			KSRLogger.error(classObj, exception);
		}
		return bankDTOList;
	}
}
