package com.jspiders.springannotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class EmployeeBean {

	@Value("1")
	private int id;

	@Value("Arun")
	private String name;

	@Autowired
	private EmployeeDetailsBean details;

}
