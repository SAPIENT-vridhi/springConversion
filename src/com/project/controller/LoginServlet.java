package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Customer;
import com.project.bl.CustomerBl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerBl customerBL = new CustomerBl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = null;
		try {
			customer = customerBL.signIn(email, password);
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("errorMessage", "Unsuccessful Sign in");
			request.getRequestDispatcher("error404page.jsp").include(request, response);
		}

		if (customer == null) { // login failed
			try {
				request.setAttribute("errorMessage", "Invalid User, please retry again");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			} catch (ServletException | IOException e) {
				request.setAttribute("errorMessage", "Invalid User");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			} // redirecting to index.jsp
		} else if (customer.getEmail().equals("admin") || customer.getPassword().equals("admin123")) {
			HttpSession session = request.getSession(); // creating session
			session.setAttribute("email", email);
			session.setAttribute("customerObject", customer);
			// setting session attribute
			try {
				request.getRequestDispatcher("admin.jsp").forward(request, response); // redirecting
																						// to
																						// admin.jsp
			} catch (ServletException | IOException e) {
				request.setAttribute("errorMessage", "Unsuccessful Admin Sign in");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			}
		} else { // customer login successful
			HttpSession session = request.getSession(); // creating session
			session.setAttribute("email", email); // setting session attribute
			session.setAttribute("customerObject", customer); // setting
																// customer
																// object in
																// session scope
			try {
				request.getRequestDispatcher("index.jsp").forward(request, response); // redirecting
																						// to
																						// index.jsp
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				request.setAttribute("errorMessage", "Unexpected Error");
				request.getRequestDispatcher("error404page.jsp").include(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}