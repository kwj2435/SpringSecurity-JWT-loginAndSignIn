package com.kimkwon.toy.api.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kimkwon.toy.api.mapper.UserMapper;
import com.kimkwon.toy.domain.UserVO;
import com.kimkwon.toy.util.JwtUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Service
public class UserService {
	
	@Value("${jwt.secret}")
	private String secret;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JwtUtils jwtUtils; 
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	public void setUser(UserVO userVO) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userVO.setUser_password(encoder.encode(userVO.getUser_password()));
		userMapper.setUser(userVO);
	}
	public UserVO getUserIdPassword(String user_id) {
		return userMapper.getUserIdPassword(user_id);
	}
}
