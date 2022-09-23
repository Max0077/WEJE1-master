package com.jspiders.hibernate.manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "father_details")
public class FatherDTO1 {

	@Id
	private int id;

	private String name;

	private int age;

}
