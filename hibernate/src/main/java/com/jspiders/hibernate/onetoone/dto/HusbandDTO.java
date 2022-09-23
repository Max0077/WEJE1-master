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
public class HusbandDTO {

	@Id
	private int hid;

	private String hname;

	private int hage;

	@OneToOne
	private WifeDTO wife;

}
