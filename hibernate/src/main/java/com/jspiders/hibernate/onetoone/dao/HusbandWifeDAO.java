package com.jspiders.hibernate.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.hibernate.onetoone.dto.HusbandDTO;
import com.jspiders.hibernate.onetoone.dto.WifeDTO;

public class HusbandWifeDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnections() {
		factory = Persistence.createEntityManagerFactory("hibernate");
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

	public static void main(String[] args) {
		openConnections();

		transaction.begin();

		WifeDTO wife1 = new WifeDTO();
		wife1.setWid(1);
		wife1.setWname("Sameera");
		wife1.setWage(50);

		HusbandDTO husband1 = new HusbandDTO();
		husband1.setHid(1);
		husband1.setHname("Sameer");
		husband1.setHage(23);
		husband1.setWife(wife1);

		wife1.setHusband(husband1);

		manager.persist(wife1);
		manager.persist(husband1);

		transaction.commit();

		closeConnections();
	}

}
