package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.dao.StudentDAO;
import com.jspiders.springmvc.dto.StudentDTO;

@Service
public class StudentService implements StudentServiceInterface {

	@Autowired
	private StudentDAO dao;

	@Override
	public void addStudent(String name, String email, String userName, String password) {
		if (name != null && email != null && userName != null && password != null) {
			dao.addStudent(name, email, userName, password);
		}
	}

	@Override
	public StudentDTO login(String userName, String password) {
		if (userName != null && password != null) {
			StudentDTO student = dao.login(userName, password);
			if (student != null) {
				return student;
			}
		}
		return null;
	}

}
