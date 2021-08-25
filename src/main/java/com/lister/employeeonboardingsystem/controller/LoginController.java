package com.lister.employeeonboardingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.lister.employeeonboardingsystem.services.LoginService;
import com.lister.employeeonboardingsystem.vo.InviteInfo;
import com.lister.employeeonboardingsystem.vo.UserLogin;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@PostMapping()
	public ResponseEntity<UserLogin> actionLogin(@Validated @RequestBody InviteInfo loginui){
		UserLogin lui=loginService.validate(loginui);
		return ResponseEntity.ok(lui);
		
		
	}
	
	   }
