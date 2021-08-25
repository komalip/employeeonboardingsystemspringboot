package com.lister.employeeonboardingsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
@Entity
@Data
@Table
public class EmployeeDemographics {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "Employee_id" )
		private int employeeId;
		
		@Column(name = "Employee_code" )
		private String employeecode;
		@Size(min=2,message="field should contain atleast 2 characters")
		@Pattern(regexp="[a-zA-z]*")
	    private String name;
		@Pattern(regexp="^((\\+91-?)|0)?[0-9]{10}$")
	    private int phonenumber;
		@Column(name = "email_id" )
		@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
		private String emailId;
		@Column(name = "blood_group" )
		private String bloodgroup;
		private String DOB;
		@Pattern(regexp="[0-9]*")
		@Column(name = "aadhar_number")
		private int aadharnumber;
		private String gender;
		@Column(name = "HSC_score")
		private double Hscscore;
		@Column(name = "SSLC_score" )
		private double sslcscore;
		@Column(name = "UG_score" )
		private double ugscore;
		@Pattern(regexp="[a-zA-z]*")
		@Size(min=2,message="field should contain atleast 2 characters")
		@Column(name = "father_name")
		@Pattern(regexp="[a-zA-z]*")
		@Size(min=2,message="field should contain atleast 2 characters")
		private String fathername;
		@Column(name = "mother_name")
		private String mothername;
		@Pattern(regexp="[a-zA-z]*")
		@Column(name = "emergency_con_name" )
		private String emergencyconname;
		@Column(name = "emergency_con_relation" )
		private String emergencyconrelation;
		@Column(name = "emergency_con_number")
		private String emergengyconnum;
		private String createdat;
		private String currentstatus;
		private String rejectionreason;
		@JsonManagedReference
		
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name="Emp_id")
		private List<Address> address;
		

}
