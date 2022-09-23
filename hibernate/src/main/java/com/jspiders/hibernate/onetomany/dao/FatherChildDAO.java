package com.jspiders.hibernate.onetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.hibernate.onetomany.dto.ChildDTO;
import com.jspiders.hibernate.onetomany.dto.FatherDTO;

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

		ChildDTO child1 = new ChildDTO();
		child1.setId(1);
		child1.setName("Ashwin");
		child1.setAge(20);

		ChildDTO child2 = new ChildDTO();
		child2.setId(2);
		child2.setName("Ashwini");
		child2.setAge(23);

		entityManager.persist(child1);
		entityManager.persist(child2);

		FatherDTO father1 = new FatherDTO();
		father1.setId(1);
		father1.setName("Ashok");
		father1.setAge(50);

		List<ChildDTO> children = Arrays.asList(child1, child2);

		father1.setChildren(children);

		entityManager.persist(father1);

		entityTransaction.commit();

		closeConnections();

	}

}
