package com.kimkwon.toy.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.kimkwon.toy.api.service.UserService;
import com.kimkwon.toy.domain.UserVO;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	UserService userService;
	
	@Test
	public void signUpTest () throws Exception{
		UserVO userVO = new UserVO();
		userVO.setUser_id("test");
		userVO.setUser_password("test");
		userVO.setUser_name("testName");
		userVO.setUser_nickname("nickname");
		userVO.setUser_email("test@test");
		userVO.setUser_phone_number("123123");
		userVO.setUser_post_number("123456");
		userVO.setUser_address("test");
		userVO.setUser_address_detail("test");
			
	}
	
	
	

}
