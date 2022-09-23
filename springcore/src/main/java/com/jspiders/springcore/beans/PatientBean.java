package com.jspiders.springcore.beans;

import lombok.Data;

@Data
public class PatientBean {

	private int id;

	private String name;

	private DoctorBean doctor;

}
