package com.ksr.dao.admin;

import com.ksr.dao.DAOException;
import com.ksr.dto.UserDTO;


public interface UserDao{

	public long createUser(UserDTO userDTO)throws DAOException;
	
	public void updateUser(UserDTO userDTO)throws DAOException;
	
	public UserDTO getUserDTOByUserId(long userId)throws DAOException;
	
	public UserDTO getUserDTOByUserName(String userName)throws DAOException;
}
