package com.jspiders.hibernate.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WifeDTO {

	@Id
	private int wid;

	private String wname;

	private int wage;

	@OneToOne
	private HusbandDTO husband;

}
