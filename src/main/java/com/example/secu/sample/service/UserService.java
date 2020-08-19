package com.example.secu.sample.service;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.secu.sample.dao.UserDAO;
import com.example.secu.sample.vo.UserVO;


@Service
public class UserService implements UserDetailsService {

	@Resource
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO account = new UserVO();
		try {
			account = userDAO.selectUserVO(username);

			if( account == null ) {
				throw new UsernameNotFoundException(username);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}

}
