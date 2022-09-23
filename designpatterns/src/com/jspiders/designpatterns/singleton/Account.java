package com.jspiders.designpatterns.singleton;

public class Account {

	static Account account = new Account();

	int balance = 10000;

	

	private Account() {
	}

	public static void withdraw(int amount) {
//		if (account == null) {
//			account = new Account();
//		}
		if (account.balance > amount) {
			account.balance -= amount;
			System.out.println("Successfully withdrawn " + amount + " rupees");
		} else {
			System.out.println("Insufficient balance.");
		}

	}

	public static void deposit(int amount) {
//		if (account == null) {
//			account = new Account();
//		}
		account.balance += amount;
		System.out.println("Successfully deposited " + amount + " rupees");
	}

	public static int checkBalance() {
//		if (account == null) {
//			account = new Account();
//		}
		return account.balance;
	}

}
