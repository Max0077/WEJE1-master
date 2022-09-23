package com.jspiders.springannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.springannotations.beans.EmployeeBean;

@ComponentScan("com.jspiders.springannotations")
public class EmployeeConfig {

	@Bean
	public EmployeeBean getEmployee() {
		return new EmployeeBean();
	}

}
