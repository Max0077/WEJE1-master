package com.jspiders.hibernate.onetomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FatherDTO {

	@Id
	private int id;

	private String name;

	private int age;

	@OneToMany
	private List<ChildDTO> children;

}
