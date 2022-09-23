package com.jspiders.springmvc.service;

import com.jspiders.springmvc.dto.StudentDTO;

public interface StudentServiceInterface {

	void addStudent(String name, String email, String userName, 
			String password);

	StudentDTO login(String userName, String password);

}
