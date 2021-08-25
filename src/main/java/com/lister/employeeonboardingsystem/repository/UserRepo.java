package com.lister.employeeonboardingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lister.employeeonboardingsystem.model.User;
@Repository
public interface UserRepo extends JpaRepository<User , Integer>{
	User findByUsernameAndPassword(String username,String password);

	  User findByRoleId(String roleid) ;

	

}
