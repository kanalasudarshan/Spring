package com.ksr.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ksr.dao.admin.BankDao;
import com.ksr.dto.BankDTO;
import com.ksr.service.exception.ApplicationException;
import com.ksr.util.constants.KSRConstant;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;
	
	@Override
	@Cacheable(cacheNames=KSRConstant.BANK_DTO_WITH_ID,key="#bankDTO.bankId")
	public void createBank(BankDTO bankDTO)throws ApplicationException {
		try{
			bankDao.createBank(bankDTO);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}
		
	}
	
	@Override
	@CachePut(cacheNames=KSRConstant.BANK_DTO_WITH_ID,key="#bankDTO.bankId")
	public void updateBank(BankDTO bankDTO)throws ApplicationException {
		try{
			bankDao.updateBank(bankDTO);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}		
	}

	@Override
	@Cacheable(cacheNames=KSRConstant.BANK_DTO_WITH_ID,key="#bankDTO.bankId")
	public BankDTO getUserDTOByUserId(long bankId)throws ApplicationException {
		try{
			return bankDao.getBankDTOByUserId(bankId);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}
	}
}
