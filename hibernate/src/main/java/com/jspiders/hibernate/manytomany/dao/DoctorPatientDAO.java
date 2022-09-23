package com.jspiders.hibernate.manytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;

import com.jspiders.hibernate.manytomany.dto.DoctorDTO;
import com.jspiders.hibernate.manytomany.dto.PatientDTO;

public class DoctorPatientDAO {

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

//		PatientDTO patient1 = new PatientDTO();
//		patient1.setName("Bhushan");
//		patient1.setAge(23);
//
//		PatientDTO patient2 = new PatientDTO();
//		patient2.setName("Sameer");
//		patient2.setAge(22);
//
//		List<PatientDTO> patients = Arrays.asList(patient1, patient2);
//
//		DoctorDTO doctor1 = new DoctorDTO();
//		doctor1.setName("Strange");
//		doctor1.setSpecialization("Neurologist");
//		doctor1.setPatients(patients);
//
//		DoctorDTO doctor2 = new DoctorDTO();
//		doctor2.setName("Haathi");
//		doctor2.setSpecialization("Orthopedic");
//		doctor2.setPatients(patients);
//
//		List<DoctorDTO> doctors = Arrays.asList(doctor1, doctor2);
//
//		patient1.setDoctors(doctors);
//
//		patient2.setDoctors(doctors);
//
//		entityManager.persist(patient1);
//
//		entityManager.persist(patient2);
//
//		entityManager.persist(doctor1);
//
//		entityManager.persist(doctor2);

		String jpql = "select name, specialization from DoctorDTO";

		Query query = entityManager.createQuery(jpql);

		List doctors = query.getResultList();

		for (Object doctor : doctors) {
			System.out.println(doctor);
		}

		jpql = "update DoctorDTO set specialization = 'Physician' where id =12";
		query = entityManager.createQuery(jpql);
		int executeUpdate = query.executeUpdate();
		System.out.println(executeUpdate + " row(s) updated.");

		jpql = "delete from DoctorDTO where id = 12";
		query = entityManager.createQuery(jpql);
		int executeUpdate2 = query.executeUpdate();
		System.out.println(executeUpdate2 + " row(s) deleted.");

		entityTransaction.commit();

		closeConnections();
	}

}
