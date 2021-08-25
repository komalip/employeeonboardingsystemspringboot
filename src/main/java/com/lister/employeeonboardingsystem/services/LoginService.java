package com.lister.employeeonboardingsystem.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lister.employeeonboardingsystem.model.User;
import com.lister.employeeonboardingsystem.repository.UserRepo;
import com.lister.employeeonboardingsystem.vo.InviteInfo;
import com.lister.employeeonboardingsystem.vo.UserLogin;


@Service
public class LoginService { 
	@Autowired
	private UserRepo userRepo;
	public UserLogin validate(InviteInfo lui) {
		User vc = userRepo.findByUsernameAndPassword(lui.getPassword(),lui.getUsername());
		UserLogin invalid=new UserLogin();
        if((vc != null)){
        	UserLogin   i = new UserLogin();
            i.setRoleId(vc.getRoleId());
            return i;
        }
		return invalid;
	}	
	
	 
}
	


