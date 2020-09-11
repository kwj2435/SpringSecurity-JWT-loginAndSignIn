package com.kimkwon.toy.api.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kimkwon.toy.api.service.UserService;
import com.kimkwon.toy.domain.UserVO;

@RestController
@RequestMapping(value="user",method=RequestMethod.POST)
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public ResponseEntity<String> doTest(){
		return ResponseEntity.ok("testOK");
	}
}
