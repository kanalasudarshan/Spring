package com.ksr.dao.util;

import com.ksr.dao.DAOException;

public interface UtilDao {

		public void storeSecurityCriptKey(String secretKey)throws DAOException;
		
		public String getSecurityCriptKey()throws DAOException;
}
