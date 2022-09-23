package com.jspiders.springcore.beans;

import java.util.List;

import lombok.Data;

@Data
public class TeamBean {

	private int id;

	private String name;

	private String city;

	private List<PlayerBean> players;

}
