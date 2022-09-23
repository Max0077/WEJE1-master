package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.beans.TeamBean;

public class TeamMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("TeamConfig.xml");
		TeamBean team1 = context.getBean(TeamBean.class);
		System.out.println(team1);
		((ClassPathXmlApplicationContext) context).close();
	}

}
