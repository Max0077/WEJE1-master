package com.jspiders.servlets.servletclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegistration
 */
@WebServlet("/Employee")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			writer.println("Welcome " + firstName + " " + lastName + "<br>");
			writer.println("Email : " + email + "<br>");
			writer.println("Phone : " + phone + "<br>");
			writer.println("Gender : " + gender);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into emp values (?,?,?,?,?)");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, gender);
			int executeUpdate = preparedStatement.executeUpdate();
			writer.println(executeUpdate + " row(s) inserted in database");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
