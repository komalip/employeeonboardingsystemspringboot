package com.lister.employeeonboardingsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lister.employeeonboardingsystem.model.EmployeeDemographics;
import com.lister.employeeonboardingsystem.model.User;
import com.lister.employeeonboardingsystem.services.EmployeeDemographicsService;
import com.lister.employeeonboardingsystem.services.UserService;
import com.lister.employeeonboardingsystem.vo.Employeeform;

@RestController
@RequestMapping("/user")
public class EmployeeDemographicsController  {
	@Autowired
	private EmployeeDemographicsService employeeDemographicsService;
	@Autowired
	private UserService userService;

	@PostMapping()
	public ResponseEntity<String> saveEmployeedemographics(@Valid @RequestBody Employeeform employeeform) {
		employeeDemographicsService.save(employeeform);

		return ResponseEntity.ok("saved");
	}

	@GetMapping("/hr/{employeeId}")
	public ResponseEntity<EmployeeDemographics> findEmployeedemographicsById(
			@PathVariable(value = "employeeId") int employeeId) {
		
		return ResponseEntity.ok(employeeDemographicsService.getEmployeedemographicsByEmployeeId(employeeId));
	}

	@GetMapping("/hr")
	public ResponseEntity<List<EmployeeDemographics>> getEmployeedemographics() {
		return ResponseEntity.ok(employeeDemographicsService.getAllEmployeedemographics());

	}

	@PostMapping("newuser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
}
