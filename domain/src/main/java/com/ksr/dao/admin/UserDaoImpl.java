package com.ksr.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ksr.dao.BaseDaoImpl;
import com.ksr.dao.DAOException;
import com.ksr.dto.UserDTO;
import com.ksr.util.logger.KSRLogger;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements  UserDao {
	
	private Class<UserDaoImpl> classObj=UserDaoImpl.class;
	
	@Override
	public long createUser(UserDTO userDTO)throws DAOException{
		long id=0;
		try{
			KSRLogger.info(classObj, "createUser calling");
			String sql="INSERT INTO b_user(user_id,user_name,first_name,last_name,is_active,is_email_verified)VALUES(?,?,?,?,?,?)";
			KSRLogger.debug(classObj, "SQL :"+sql);
			KSRLogger.debug(classObj, "UserDTO :"+userDTO.toString());
			id=insert(sql, userDTO.getUserId(),userDTO.getUserName(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.isActive(),userDTO.isEmailVerified());
			KSRLogger.info(classObj, "createUser called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return id;
	}
	
	@Override
	public void updateUser(UserDTO userDTO)throws DAOException{
		try{
			KSRLogger.info(classObj, "updateUser calling");
			String sql="UPDATE b_user SET user_name = ?,first_name = ?,last_name = ?,is_active = ?,is_email_verified =? WHERE user_id = ?";
			KSRLogger.debug(classObj, "SQL :"+sql);
			KSRLogger.debug(classObj, "UserDTO :"+userDTO.toString());
			update(sql,userDTO.getUserName(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.isActive(),userDTO.isEmailVerified(), userDTO.getUserId());
			KSRLogger.info(classObj, "updateUser called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
	}
	
	@Override
	public UserDTO getUserDTOByUserId(long userId)throws DAOException{
		UserDTO userDTO=null;
		try{
			KSRLogger.info(classObj, "getUserDTOByUserId calling");
			
			String sql="select *from b_user where user_id=?";
			KSRLogger.debug(classObj, "SQL :"+sql);
			List<Map<String, Object>> sqlObject=select(sql, userId);
			KSRLogger.debug(classObj, "Result :"+sqlObject);
			if(sqlObject.size()>0){
				for(Map<String, Object> map:sqlObject){
					userDTO=convertUserMapToUserDTO(map);
				}
			}
			KSRLogger.info(classObj, "getUserDTOByUserId called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return userDTO;
	}
	
	@Override
	public UserDTO getUserDTOByUserName(String userName)throws DAOException{
		UserDTO userDTO=null;
		try{
			KSRLogger.info(classObj, "getUserDTOByUserName calling");			
			String sql="select *from b_user where user_name=?";
			KSRLogger.debug(classObj, "SQL :"+sql);
			List<Map<String, Object>> sqlObject=select(sql, userName);
			KSRLogger.debug(classObj, "Result :"+sqlObject);
			if(sqlObject.size()>0){
				for(Map<String, Object> map:sqlObject){
					userDTO=convertUserMapToUserDTO(map);
				}
			}
			KSRLogger.info(classObj, "getUserDTOByUserName called");
		}catch(Exception exception){
			throw new DAOException(exception);
		}
		return userDTO;
	}
	
	private UserDTO convertUserMapToUserDTO(Map<String, Object> map){
		KSRLogger.info(classObj, "convertUserMapToUserDTO calling");	
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId(Long.parseLong(map.get("user_id").toString()));
		userDTO.setUserName(map.get("user_name").toString());
		userDTO.setFirstName(map.get("first_name").toString());
		userDTO.setLastName(map.get("last_name").toString());
		userDTO.setActive(Boolean.parseBoolean(map.get("is_active").toString()));
		userDTO.setEmailVerified(Boolean.parseBoolean(map.get("is_email_verified").toString()));
		KSRLogger.info(classObj, "convertUserMapToUserDTO called");	
		return userDTO;
	}

}
