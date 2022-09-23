package com.jspiders.springannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springannotations.beans.StudentBean;

public class StudentConfig {

	@Bean("student")
	public StudentBean getStudent() {
		StudentBean student = new StudentBean();
		student.setId(1);
		student.setName("Rahul");
		student.setEmail("rahul@gmail.com");
		student.setAddress("Pune");
		return student;
	}

	@Bean("student1")
	public StudentBean getStudent1() {
		StudentBean student1 = new StudentBean();
		student1.setId(2);
		student1.setName("Rohan");
		student1.setEmail("rohan@gmail.com");
		student1.setAddress("Mumbai");
		return student1;
	}

}
