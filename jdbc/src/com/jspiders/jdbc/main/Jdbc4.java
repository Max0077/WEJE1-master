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

public class Jdbc4 {

	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static String driverPath = "com.mysql.cj.jdbc.Driver";
	static String query = "select * from mumbai_indians";
	static FileReader fileReader;
	static Properties properties = new Properties();

	public static void main(String[] args) {

		try {

			Class.forName(driverPath);

			fileReader = new FileReader("D:\\WEJE1\\jdbc\\resources" + "\\db_info.properties");

			properties.load(fileReader);

			connection = DriverManager.getConnection(properties.getProperty("dbPath"), properties);

			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
