package com.lister.employeeonboardingsystem.exceptionhandling;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeNotFound extends RuntimeException {

	private String message;
		
	}
	
