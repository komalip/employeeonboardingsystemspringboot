package com.lister.employeeonboardingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lister.employeeonboardingsystem.model.User;
import com.lister.employeeonboardingsystem.repository.UserRepo;
@Service
public class UserService {
	@Autowired
	private  UserRepo userRepo;
	public  User saveUser(User user) {
		  return userRepo.save(user);
		  
	}
	
}