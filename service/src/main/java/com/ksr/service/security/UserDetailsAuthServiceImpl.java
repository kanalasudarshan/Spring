package com.ksr.service.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ksr.dao.DAOException;
import com.ksr.dao.admin.UserDao;
import com.ksr.dto.UserDTO;
import com.ksr.dto.UserRoleDTO;
import com.ksr.service.admin.UserService;
import com.ksr.service.exception.ApplicationException;
import com.ksr.util.logger.KSRLogger;

@Service("userDetailsService")
public class UserDetailsAuthServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;
	
	
	private Class<UserDetailsAuthServiceImpl> classObj=UserDetailsAuthServiceImpl.class;
	
	public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
		User user=null;
		try{
			UserDTO userDTO=userService.getUserDTOByUserName(userName);
			userDTO.setPassword("123");
			Set<UserRoleDTO> userRoles=new HashSet<UserRoleDTO>();
			UserRoleDTO userRoleDTO=new UserRoleDTO();
			userRoleDTO.setRoleName("ROLE_ADMIN");
			userRoles.add(userRoleDTO);
			
			List<GrantedAuthority> authorities = buildUserAuthority(userRoles);
			user=buildUserForAuthentication(userDTO, authorities);
		}catch(ApplicationException exception){
			KSRLogger.error(classObj, exception);			
		}
		return user;
	}
	
	private User buildUserForAuthentication(UserDTO userDTO,List<GrantedAuthority> authorities) {
		return new User(userDTO.getUserName(), userDTO.getPassword(), userDTO.isActive(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRoleDTO> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRoleDTO userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
