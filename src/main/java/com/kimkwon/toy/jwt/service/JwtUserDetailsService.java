package com.kimkwon.toy.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kimkwon.toy.api.service.UserService;
import com.kimkwon.toy.domain.UserVO;
@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserVO userVO = userService.getUserIdPassword(username);
		
		if(userVO.getUser_id().equals(username)) {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User(userVO.getUser_id(),userVO.getUser_password(),roles);	//ArrayList = role
		}else {
			throw new UsernameNotFoundException("User not found with username: " +username);
		}
	}
}
