package com.ksr.dao.admin;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ksr.dao.BaseDaoImpl;
import com.ksr.dao.DAOException;
import com.ksr.dto.BankDTO;
import com.ksr.util.logger.KSRLogger;

@Repository("bankDao")
public class BankDaoImpl extends BaseDaoImpl implements BankDao {
	
	private Class<BankDaoImpl> classObj=BankDaoImpl.class;
	
	@Override
	public long createBank(BankDTO bankDTO)throws DAOException{
		long id=0;
		try{
			KSRLogger.info(classObj, "createBank calling");
			String sql="INSERT INTO b_bank(bank_name,current_account_balance,current_loan_balance,created_date,modified_date) VALUES(?,?,?,?,?)";
			KSRLogger.debug(classObj, "SQL :"+sql);
			KSRLogger.debug(classObj, "BankDTO :"+bankDTO.toString());
			id=insert(sql, bankDTO.getBankName(),bankDTO.getCurrentAcountBalance(),bankDTO.getCurrentLoanBalance(),bankDTO.getCreatedDate(),bankDTO.getModifiedDate());
			KSRLogger.info(classObj, "createBank called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return id;
	}
	
	@Override
	public void updateBank(BankDTO bankDTO)throws DAOException{
		try{
			KSRLogger.info(classObj, "updateBank calling");
			String sql="UPDATE b_bank SET bank_name = ?, current_account_balance = ?, current_loan_balance = ?, modified_date =? WHERE bank_id =?";
			KSRLogger.debug(classObj, "SQL :"+sql);
			KSRLogger.debug(classObj, "BankDTO :"+bankDTO.toString());
			update(sql,bankDTO.getBankName(),bankDTO.getCurrentAcountBalance(),bankDTO.getCurrentLoanBalance(),bankDTO.getModifiedDate(),bankDTO.getBankId());
			KSRLogger.info(classObj, "updateBank called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
	}
	
	@Override
	public BankDTO getBankDTOByUserId(long bankId)throws DAOException{
		BankDTO bankDTO=null;
		try{
			KSRLogger.info(classObj, "getBankDTOByUserId calling");
			
			String sql="select *from bank_name where bank_id=?";
			KSRLogger.debug(classObj, "SQL :"+sql);
			List<Map<String, Object>> sqlObject=select(sql, bankId);
			KSRLogger.debug(classObj, "Result :"+sqlObject);
			if(sqlObject.size()>0){
				for(Map<String, Object> map:sqlObject){
					bankDTO=convertBankMapToBankDTO(map);
				}
			}
			KSRLogger.info(classObj, "getBankDTOByUserId called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return bankDTO;
	}
	
	private BankDTO convertBankMapToBankDTO(Map<String, Object> map)throws DAOException{
		BankDTO bankDTO=null;
		try{
			bankDTO=new BankDTO();
			if(map.get("bank_id")!=null)
				bankDTO.setBankId(Long.parseLong(map.get("bank_id").toString()));
			if(map.get("bank_name")!=null)
				bankDTO.setBankName(map.get("bank_name").toString());
			if(map.get("current_account_balance")!=null)
				bankDTO.setCurrentAcountBalance(Double.parseDouble(map.get("current_account_balance").toString()));
			if(map.get("current_loan_balance")!=null)
				bankDTO.setCurrentLoanBalance(Double.parseDouble(map.get("current_loan_balance").toString()));
			if(map.get("created_date")!=null)
				bankDTO.setCreatedDate(Timestamp.valueOf(map.get("created_date").toString()));
			if(map.get("modified_date")!=null)
				bankDTO.setModifiedDate(Timestamp.valueOf(map.get("modified_date").toString()));
			
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return bankDTO;
	}
}
