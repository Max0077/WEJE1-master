package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) {
		try {
			// Step 1: Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Open connection
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/" + "weje1?user=root&password=root");

			// Step 3: Prepare statement
			Statement createStatement = connection.createStatement();

			// Step 4: Process the result
			String query = "delimiter /";
			String query1 = " create procedure proc6()\n"
					+ "begin\n"
					+ "select * from mumbai_indians;\n"
					+ "end";
			String query2 ="delimiter ;";
			String query3 = "call proc6()";
			int resultInt = createStatement.executeUpdate(query);
			System.out.println(resultInt);
			resultInt = createStatement.executeUpdate(query1);
			System.out.println(resultInt);
			resultInt = createStatement.executeUpdate(query2);
			System.out.println(resultInt);
			ResultSet resultSet = createStatement.executeQuery(query3);

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | " + resultSet.getInt(3));
			}

			// Step 5: Close connection
			if (connection != null) {
				connection.close();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
//			System.out.println("Database not found");
			e.printStackTrace();
		}
	}

}
