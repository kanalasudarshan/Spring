package com.ksr.service.admin;

import com.ksr.dto.BankDTO;
import com.ksr.service.exception.ApplicationException;

public interface BankService {
	
	public void createBank(BankDTO bankDTO)throws ApplicationException;
	
	public void updateBank(BankDTO bankDTO)throws ApplicationException;
	
	public BankDTO getUserDTOByUserId(long bankId)throws ApplicationException;

}
