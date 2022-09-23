package com.jspiders.demo.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.demo.dto.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		openConnections();
		transaction.begin();
//		updateStudent();
		removeStudent();
		transaction.commit();
//		transaction.begin();
//		displayStudents();
//		transaction.commit();
//		transaction.begin();
//		removeStudent();

		closeConnections();

	}

	private static void addStudent() {
		StudentDTO student1 = new StudentDTO();
		System.out.println("Enter the student id:");
		int id = scanner.nextInt();
		student1.setRollNo(id);
		System.out.println("Enter the student id:");
		String name = scanner.next();
		student1.setName(name);
		System.out.println("Enter the student email:");
		String email = scanner.next();
		student1.setEmail(email);
		manager.persist(student1);
	}

	private static void displayStudents() {
		StudentDTO student = manager.find(StudentDTO.class, 3);
		System.out.println(student);
	}

	private static void removeStudent() {
		StudentDTO student = manager.find(StudentDTO.class, 5);
		manager.remove(student);
	}

	private static void updateStudent() {
		StudentDTO student = manager.find(StudentDTO.class, 5);
		student.setEmail("dhananjay@gmail.com");
		manager.persist(student);
	}

	private static void openConnections() {
		factory = Persistence.createEntityManagerFactory("demo");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnections() {
		factory.close();
		manager.close();
		try {
			transaction.rollback();
		} catch (TransactionException e) {
			System.out.println("Transaction cannot be rolled back");
		}
	}

}
