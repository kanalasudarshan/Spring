package com.ksr.service.admin;

import com.ksr.dto.UserDTO;
import com.ksr.service.exception.ApplicationException;

public interface UserService {
	
	public void createUser(UserDTO userDTO)throws ApplicationException;
	
	public void updateUser(UserDTO userDTO)throws ApplicationException;	
	
	public UserDTO getUserDTOByUserId(long userId)throws ApplicationException;
	
	public UserDTO getUserDTOByUserName(String userName)throws ApplicationException;

}
