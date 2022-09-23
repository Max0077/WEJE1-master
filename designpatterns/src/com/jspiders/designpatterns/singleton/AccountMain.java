package com.jspiders.designpatterns.singleton;

public class AccountMain {
	
	public static void main(String[] args) {
		
		System.out.println(Account.checkBalance());
		Account.deposit(5000);
		System.out.println(Account.checkBalance());
		Account.withdraw(2000);
		System.out.println(Account.checkBalance());
		Account.deposit(3000);
		System.out.println(Account.checkBalance());
		Account.withdraw(1500);
		System.out.println(Account.checkBalance());
		Account.withdraw(15000);
	}

}
