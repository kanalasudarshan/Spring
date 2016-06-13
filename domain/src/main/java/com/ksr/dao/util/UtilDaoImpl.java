package com.ksr.dao.util;

import java.util.Date;

import com.ksr.dao.BaseDaoImpl;
import com.ksr.dao.DAOException;
import com.ksr.util.logger.KSRLogger;

public class UtilDaoImpl extends BaseDaoImpl implements UtilDao{

	private Class<UtilDaoImpl> classObj=UtilDaoImpl.class;
	
	@Override
	public void storeSecurityCriptKey(String secretKey) throws DAOException {
		try{
			KSRLogger.info(classObj, "storeSecurityCriptKey calling");
			String sql="INSERT INTO b_security_key(security_key_name,is_active,create_date) VALUES(?,?,?,?)";
			insert(sql,secretKey,true,new Date());
			KSRLogger.info(classObj, "storeSecurityCriptKey called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}	
	}

	@Override
	public String getSecurityCriptKey() throws DAOException {
		try{
			KSRLogger.info(classObj, "getSecurityCriptKey calling");
			
			KSRLogger.info(classObj, "getSecurityCriptKey callied");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return null;
	}

}
