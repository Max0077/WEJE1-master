package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2 {
	
	static Connection connection;
	static Statement statement;
	static int resultInt;
	static String driverPath = "com.mysql.cj.jdbc.Driver";
	static String dbPath = "jdbc:mysql://localhost:3306/weje1";
	static String user = "root";
	static String password = "root";
	static String query = "create table emp (empno int primary key)";
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName(driverPath);
			
			connection = DriverManager.getConnection( dbPath,user,password);
			
			statement = connection.createStatement();
			
			resultInt = statement.executeUpdate(query);
			
			if (resultInt != 0) {
				System.out.println("Query OK, "+resultInt+
						" row(s) affected");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		} catch (SQLException e) {
			System.out.println("Database not found");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Connection not closed");
				}
			}
		}
		
		
	}

}
