package com.lister.employeeonboardingsystem.vo;

import java.util.List;

import javax.validation.constraints.Pattern;

import com.lister.employeeonboardingsystem.model.Address;

import lombok.Data;
@Data

public class Employeeform {
	private int employeeid;
	private String employeecode;
	@Pattern(regexp="[a-zA-z]*")
	private String name;
	@Pattern(regexp="^((\\+91-?)|0)?[0-9]{10}$")
    private int phonenumber;
    @Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String emailId;
    private String bloodgroup;
	private String DOB;
	@Pattern(regexp="[0-9]*")
	private int aadharnumber;
	private String gender;
	private double Hscscore;
	private double sslcscore;
	private double ugscore;
	@Pattern(regexp="[a-zA-z]*")
	private String fathername;
	@Pattern(regexp="[a-zA-z]*")
	private String mothername;
	@Pattern(regexp="[a-zA-z]*")
	private String emergencyconname;
	private String emergencyconrelation;
	private String emergengyconnum;
	private List<Address>address;
	private String status;

}
