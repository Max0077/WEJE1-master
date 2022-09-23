package com.jspiders.springannotations.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springannotations.beans.StudentBean;
import com.jspiders.springannotations.config.StudentConfig;

public class StudentMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(StudentConfig.class);
		StudentBean student = (StudentBean) context.getBean("student");
		System.out.println(student);
		StudentBean student1 = (StudentBean) context.getBean("student1");
		System.out.println(student1);
		((AnnotationConfigApplicationContext) context).close();
	}

}
