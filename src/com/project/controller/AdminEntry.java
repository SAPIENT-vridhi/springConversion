package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class AdminEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger(AdminEntry.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("admin entry class working!!");
 	    
		String str = request.getParameter("button");
		HttpSession session=request.getSession(false);
		
		switch (str) {
		case "View Category":
			//response.sendRedirect("ViewCategory");
			
			request.getRequestDispatcher("./ViewCategory").forward(request, response);
			break;
		case "Add Product":
			
			request.getRequestDispatcher("./AddProductServlet").forward(request, response);
			break;
		case "Add Category":
			response.sendRedirect("addcategory.jsp");
			//request.getRequestDispatcher("addcategory.jsp").forward(request, response);
			break;
		case "Remove Category":
			request.getRequestDispatcher("removecategory.jsp").forward(request, response);
			break;
		case "Remove Product":
			request.getRequestDispatcher("removeproduct.jsp").forward(request, response);
			break;
		case "Bill History":
			System.out.println("testinggggggggggggggggggg");
			request.getRequestDispatcher("./BillHistory").forward(request, response);
			break;
		case "Update Product":
			request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
			break;
		case "View Products":
			request.getRequestDispatcher("./ViewProducts").forward(request, response);
			break;
		case "Update Password":
			request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
