package com.lister.employeeonboardingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressdeatilsid;
	private int employeeid;
	private String type;
	private String flatname;
	private String street;
	private String area;
	private String state;
	private String country;
	private String district;
	private int pincode;
	private String mapcoordinates;

}
