package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Category;
import com.project.bl.AdminBL;

public class ViewCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(ViewCategory.class);
	
	AdminBL adminBL = new AdminBL();;
	List<Category> categoryList = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("view category working!!");
		
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		try {
			if(adminBL.viewCategory() != null) {
				categoryList = adminBL.viewCategory();
				System.out.println(categoryList);
				System.out.println("stestingghfghfghghghghghghghghghghghghghfdtukkkkkkkkkkkkkkkkkkkkkfggggggggggggggggggggggj;oufyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfyfys");
				getServletContext().setAttribute("categoryList", categoryList);
			}
			else {
				request.setAttribute("errorMessage", "Unable to Process request");
				//request.getRequestDispatcher("error404admin.jsp").include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			//request.setAttribute("errorMessage", "Unable to Process bill");
			//request.getRequestDispatcher("error404admin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
