package com.jspiders.jdbc.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc5 {

	static Connection connection;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	static FileReader fileReader;
	static Properties properties = new Properties();
	static int resultInt;
	static String query;
	static String filePath = "D:\\WEJE1\\jdbc\\resources\\db_info.properties";

	public static void main(String[] args) {
		try {

			fileReader = new FileReader(filePath);

			properties.load(fileReader);

			Class.forName(properties.getProperty(
					"driverPath"));

			connection = DriverManager.getConnection(
					properties.getProperty("dbPath"), 
					properties);

			query = "select * from emp";
			preparedStatement = 
					connection.prepareStatement(query);

			resultSet = 
					preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " +
				resultSet.getString(2) + " | " +
								resultSet.getString(3));
			}

			query = "insert into emp values (?, ?, ?)";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 8888);
			preparedStatement.setString(2, "Totla Seth");
			preparedStatement.setDouble(3, 42000.00);
			resultInt = preparedStatement.executeUpdate();
			System.out.println("Query OK, " + resultInt +
					" row(s) affected\n");
			
			query = "select * from emp";
			
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " +
				resultSet.getString(2) + " | " +
								resultSet.getString(3));
			}

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
