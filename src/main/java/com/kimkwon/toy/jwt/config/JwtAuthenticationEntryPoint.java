package com.kimkwon.toy.jwt.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{	//권한이 없을 경우 처리 로직 
	public void commence (HttpServletRequest request,HttpServletResponse response, AuthenticationException authException) throws IOException{
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
	}
}
