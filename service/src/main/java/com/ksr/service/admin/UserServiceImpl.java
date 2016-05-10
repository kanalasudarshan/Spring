package com.ksr.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ksr.dao.admin.UserDao;
import com.ksr.dto.UserDTO;
import com.ksr.service.exception.ApplicationException;
import com.ksr.util.constants.KSRConstant;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Cacheable(cacheNames=KSRConstant.USER_DTO_WITH_ID,key="#userDTO.userId")
	public void createUser(UserDTO userDTO)throws ApplicationException {
		try{
			userDao.createUser(userDTO);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}
		
	}
	
	@Override
	@CachePut(cacheNames=KSRConstant.USER_DTO_WITH_ID,key="#userDTO.userId")
	public void updateUser(UserDTO userDTO)throws ApplicationException {
		try{
			userDao.updateUser(userDTO);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}		
	}

	@Override
	@Cacheable(cacheNames=KSRConstant.USER_DTO_WITH_ID,key="#userId")
	public UserDTO getUserDTOByUserId(long userId)throws ApplicationException {
		try{
			return userDao.getUserDTOByUserId(userId);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}
	}
	
	@Override
	@Cacheable(cacheNames=KSRConstant.USER_DTO_WITH_USER_NAME,key="#userName")
	public UserDTO getUserDTOByUserName(String userName)throws ApplicationException{
		try{
			return userDao.getUserDTOByUserName(userName);
		}catch(Exception exception){
			throw new ApplicationException(exception);
		}
	}
}
