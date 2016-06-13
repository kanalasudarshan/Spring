package com.ksr.dao.admin;

import com.ksr.dao.DAOException;
import com.ksr.dto.BankDTO;

public interface BankDao {
	
	public long createBank(BankDTO bankDTO)throws DAOException;
	
	public void updateBank(BankDTO bankDTO)throws DAOException;
	
	public BankDTO getBankDTOByUserId(long bankId)throws DAOException;

}
