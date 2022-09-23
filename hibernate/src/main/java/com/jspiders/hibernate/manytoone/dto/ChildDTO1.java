package com.jspiders.hibernate.manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "child_details")
public class ChildDTO1 {

	@Id
	private int id;

	private String name;

	private int age;

	@ManyToOne
	private FatherDTO1 father;

}
