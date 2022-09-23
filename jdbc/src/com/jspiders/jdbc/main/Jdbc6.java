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

import com.jspiders.jdbc.entities.Employee;

public class Jdbc6 {
	
	static Connection connection;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	static FileReader fileReader;
	static Properties properties = new Properties();
	static String query;
	static String filePath = "D:\\WEJE1\\jdbc\\" + 
	"resources\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {

			fileReader = new FileReader(filePath);

			properties.load(fileReader);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(
					properties.getProperty("dbPath"), 
					properties);

			query = "select * from emp";
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();
			
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
		}
		
	}

}
