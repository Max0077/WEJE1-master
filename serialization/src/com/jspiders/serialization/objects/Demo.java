package com.jspiders.serialization.objects;

import java.io.Serializable;

public class Demo implements Serializable {

	int a;
	String b;

	public Demo(int a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

}
