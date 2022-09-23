package com.jspiders.hibernate.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.hibernate.manytoone.dto.ChildDTO1;
import com.jspiders.hibernate.manytoone.dto.FatherDTO1;

public class FatherChildDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnections() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnections() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			try {
				entityTransaction.rollback();
			} catch (TransactionException e) {
				System.out.println("Transaction already commited.");
			}
		}
	}

	public static void main(String[] args) {

		openConnections();

		entityTransaction.begin();

		FatherDTO1 father1 = new FatherDTO1();
		father1.setId(1);
		father1.setName("Ashok");
		father1.setAge(50);

		entityManager.persist(father1);

		ChildDTO1 child1 = new ChildDTO1();
		child1.setId(1);
		child1.setName("Ashwin");
		child1.setAge(20);
		child1.setFather(father1);

		entityManager.persist(child1);

		ChildDTO1 child2 = new ChildDTO1();
		child2.setId(2);
		child2.setName("Ashwini");
		child2.setAge(23);
		child2.setFather(father1);

		entityManager.persist(child2);

		entityTransaction.commit();

		closeConnections();

	}

}
