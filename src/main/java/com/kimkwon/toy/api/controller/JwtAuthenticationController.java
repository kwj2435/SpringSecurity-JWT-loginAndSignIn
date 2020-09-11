package com.kimkwon.toy.api.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kimkwon.toy.api.service.UserService;
import com.kimkwon.toy.domain.UserVO;
import com.kimkwon.toy.jwt.model.AuthenticationRequest;
import com.kimkwon.toy.jwt.model.AuthenticationResponse;
import com.kimkwon.toy.jwt.service.JwtUserDetailsService;
import com.kimkwon.toy.util.JwtUtils;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(UserVO userVO) throws Exception {
		try{
			userService.setUser(userVO);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("fail",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>("ok",HttpStatus.OK);
	}
	@RequestMapping(value="/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
			/*
			 * authenticate - UsernamePasswordAuthenticationToken을 기본 AuthenticationProvider로 전달
			 * UserDetailsService를 사용하여 사용자 이름을 기반으로 사용자를 가져오고 해당 사용자의 비밀번호를 인증 토큰의 비밀번호와 비교
			 * Spring Security는 하나의 실제 AuthenticationManager만 구현
			 * */
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}	//id,password 검증 문제있을 경우 throw Exception
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtUtils.createToken(userDetails.getUsername(),"USER");	//유저이름, 권한List를 파라미터로 넣음
		
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
}
