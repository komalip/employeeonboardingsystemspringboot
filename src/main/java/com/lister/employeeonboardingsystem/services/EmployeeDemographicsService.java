package com.lister.employeeonboardingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lister.employeeonboardingsystem.exceptionhandling.EmployeeNotFound;
import com.lister.employeeonboardingsystem.model.EmployeeDemographics;
import com.lister.employeeonboardingsystem.model.User;
import com.lister.employeeonboardingsystem.repository.EmployeeDemographicsRepo;
import com.lister.employeeonboardingsystem.repository.UserRepo;
import com.lister.employeeonboardingsystem.vo.Employeeform;
import com.lister.employeeonboardingsystem.vo.InviteInfo;
import com.lister.employeeonboardingsystem.vo.Status;

@Service

public class EmployeeDemographicsService {

	@Autowired
	private EmployeeDemographicsRepo employeeDemographicsRepo;
	@Autowired
	private EmailService emailService;

	public EmployeeDemographics saveEmployeedemographics(EmployeeDemographics employeeDemographics) {

		return employeeDemographicsRepo.save(employeeDemographics);
	}

	public EmployeeDemographics getEmployeedemographicsByEmployeeId(int employeeId) {

		EmployeeDemographics employeeDemographics = employeeDemographicsRepo.findByEmployeeId(employeeId);
		if (employeeDemographics != null) {
			return employeeDemographics;
		} else {
			
			throw new EmployeeNotFound("employee not found");
		}
	}

	public List<EmployeeDemographics> getAllEmployeedemographics() {
		return employeeDemographicsRepo.findAll();
	}

	public void status(Status status) {
		EmployeeDemographics employeeDemographics = getEmployeedemographicsByEmployeeId(status.getEmployeeId());
		if (status.getAction() == ("Approve"));
		{

			employeeDemographics.setCurrentstatus("completed");
		}
		if (status.getAction() == ("Reject"));
			
		{
			employeeDemographics.setCurrentstatus("rejected");
			employeeDemographics.setRejectionreason(status.getRejectionreason());
			emailService.sendMail(employeeDemographics.getEmailId(), "Rejected", status.getRejectionreason());

		}

	}
	public void createroleid() {
		
	}

	@Autowired
	private UserRepo userRepo;

	public void createuser(InviteInfo invite) {
		User user = new User();
		user.setUsername(invite.getUsername());
		user.setPassword(invite.getPassword());
		user.setRoleId(invite.getRoleid());
		userRepo.save(user);

	}

	public void save(Employeeform employeeform) {
		EmployeeDemographics employeeDemographics = new EmployeeDemographics();
		employeeDemographics.setName(employeeform.getName());
		employeeDemographics.setAadharnumber(employeeform.getAadharnumber());
		employeeDemographics.setBloodgroup(employeeform.getBloodgroup());
		employeeDemographics.setAddress(employeeform.getAddress());
		employeeDemographics.setUgscore(employeeform.getUgscore());
		employeeDemographics.setSslcscore(employeeform.getSslcscore());
		employeeDemographics.setCurrentstatus(employeeform.getStatus());
		employeeDemographics.setPhonenumber(employeeform.getPhonenumber());
		employeeDemographics.setMothername(employeeform.getMothername());
		employeeDemographics.setGender(employeeform.getGender());
		employeeDemographics.setFathername(employeeform.getFathername());
		employeeDemographics.setHscscore(employeeform.getHscscore());
		employeeDemographics.setEmployeeId(employeeform.getEmployeeid());
		employeeDemographics.setEmployeecode(employeeform.getEmployeecode());
		employeeDemographics.setEmergengyconnum(employeeform.getEmergengyconnum());
		employeeDemographics.setEmergencyconrelation(employeeform.getEmergencyconrelation());

		saveEmployeedemographics(employeeDemographics);

	}

}
