package com.jspiders.designpatterns.factory;

import java.util.Scanner;

public class CarMain {
	static boolean loop = true;

	public static void main(String[] args) {

		while (loop) {
			try {
				factory().buyCar();
			} catch (NullPointerException e) {
				System.out.println("Car not selected.");
			}
		}

	}

	private static Car factory() {
		Car car = null;
		System.out.println("Select car to buy:\n1. Mercedes\n2. Ferrari");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			car = new Mercedes();
			loop = false;
			break;

		case 2:
			car = new Ferrari();
			loop = false;
			break;

		default:
			System.out.print("Invalid selection. ");
			break;
		}
		return car;
	}

}
