package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {
	
	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static String driverPath = "com.mysql.cj.jdbc.Driver";
	static String dbPath = "jdbc:mysql://localhost:3306/weje1";
	static String user = "root";
	static String password = "root";
	static String query = "select * from mumbai_indians";
	
	public static void main(String[] args) {
		try {
			
			Class.forName(driverPath);
			
			connection = DriverManager.getConnection( dbPath,user,password);
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | " 
						+ resultSet.getString(2) + " | " 
						+ resultSet.getString(3));
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
