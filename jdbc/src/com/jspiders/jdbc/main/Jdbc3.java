package com.jspiders.jdbc.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc3 {

	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static FileReader fileReader;
	static Properties properties = new Properties();
	static int resultInt;
	static String query;
	static String filePath = "D:\\WEJE1\\jdbc\\"
			+ "resources\\db_info.properties";
	

	public static void main(String[] args) {

		try {

			fileReader = new FileReader(filePath);
			
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection(
					properties.getProperty("dbPath"), properties);
			
			statement = connection.createStatement();
			
			query = "drop table emp";
			statement.executeUpdate(query);
			System.out.println("Creating table\n");
			query = "create table emp "
					+ "(empno int primary key, "
					+ "ename varchar(50) not null, "
					+ "sal decimal(10,2) not null)";
			resultInt = statement.executeUpdate(query);
			System.out.println("Query OK, " 
					+ resultInt + " row(s) affected\n");
			System.out.println("Table created");
			System.out.println("----------------------------------");
			
			System.out.println("Inserting values in table\n");
			query = "insert into emp" + 
			" values (1111, 'Arjun Reddy', 50000.00)," + 
					" (2222, 'Kabir Singh', 50000.00),"
					+ " (3333, 'Raju', 40000.00)," + 
					" (4444, 'Shyam', 40000.00)," + 
					" (5555, 'Babu Bhaiya', 40000.00)";
			resultInt = statement.executeUpdate(query);
			System.out.println("Query OK, " + resultInt + " row(s) affected\n");
			System.out.println("Values inserted");
			System.out.println("----------------------------------");
			
			System.out.println("Displaying table\n");
			query = "select * from emp";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " 
								+ resultSet.getString(2) + " | " 
								+ resultSet.getString(3));
			}
			System.out.println();
			System.out.println("Table displayed");
			System.out.println("----------------------------------");
			
			System.out.println("Updating table\n");
			query = "update emp set sal = "
					+ "45000.00 where empno "
					+ "between 3333 and 5555";
			resultInt = statement.executeUpdate(query);
			System.out.println("Query OK, " + resultInt + " row(s) affected\n");
			System.out.println("Table updated");
			System.out.println("----------------------------------");
			
			System.out.println("Displaying table\n");
			query = "select * from emp";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3));
			}
			System.out.println();
			System.out.println("Table displayed");
			System.out.println("----------------------------------");
			
			System.out.println("Deleting values from table\n");
			query = "delete from emp where empno = 5555";
			resultInt = statement.executeUpdate(query);
			System.out.println("Query OK, " + resultInt + " row(s) affected\n");
			System.out.println("Values deleted");
			System.out.println("------------------------------------");
			
			System.out.println("Displaying table\n");
			query = "select * from emp";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " 
								+ resultSet.getString(2) + " | " 
								+ resultSet.getString(3));
			}
			System.out.println();
			System.out.println("Table displayed");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
