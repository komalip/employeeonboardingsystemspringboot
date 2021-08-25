package com.lister.employeeonboardingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lister.employeeonboardingsystem.model.EmployeeDemographics;


@Repository
public interface EmployeeDemographicsRepo extends JpaRepository<EmployeeDemographics, Integer> {

	EmployeeDemographics findByEmployeeId(int employeeId);
	
	

}
