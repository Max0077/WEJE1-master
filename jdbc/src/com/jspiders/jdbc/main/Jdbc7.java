package com.jspiders.jdbc.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jspiders.jdbc.entities.Employee;

public class Jdbc7 {

	static Connection connection;
	static ResultSet resultSet;
	static CallableStatement callableStatement;
	static FileReader fileReader;
	static Properties properties = new Properties();
	static String query;
	static String filePath = "D:\\WEJE1\\jdbc\\" + "resources\\db_info.properties";

	public static void main(String[] args) {

		try {

			fileReader = new FileReader(filePath);

			properties.load(fileReader);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dbPath"), properties);

			callableStatement = connection.prepareCall("call proc()");

			resultSet = callableStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				emp.setEmpno(resultSet.getInt(1));
				emp.setEname(resultSet.getString(2));
				emp.setSal(resultSet.getDouble(3));
				System.out.println(emp);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
