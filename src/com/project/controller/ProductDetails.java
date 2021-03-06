package com.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Cart;
import com.project.bean.Customer;
import com.project.bean.Product;
import com.project.bl.CustomerBl;


public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustomerBl customerBL = new CustomerBl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		 
//		//HttpSession session = request.getSession(false);
//		//String mail=(String)session.getAttribute("email");
//		if (mail == null) {
//			request.setAttribute("errorMessage", "Please Login ");
//			request.getRequestDispatcher("error404page.jsp").forward(request, response);
//		}
//		Customer customer = (Customer) session.getAttribute("customerObject");
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		String pname = request.getParameter("pname");
		//String quantity = request.getParameter("quantity");
//  		Cart cart= new Cart();
//		cart.setCartDate(date);
//		cart.setCustomerId(customer.getCustomerId());
//		cart.setProductId(Integer.parseInt(pid));
//		cart.setQuantity(Integer.parseInt(quantity));
//		
//		ArrayList<Cart> cartList= new ArrayList<Cart>();
//		cartList.add(cart);
		//if(Integer.parseInt(quantity)==0){
			// selected quantity is 0
			//call error page
		//}
//		else{
		Product product=new Product();
		//boolean status= false;
		try {
			product=customerBL.searchProductByName(pname);
			
		} catch (ClassNotFoundException | SQLException e) {
		// call Error display View	
		
		
		}
		 if(product!=null){
			 request.setAttribute("pname", product);
			 request.getRequestDispatcher("details.jsp").forward(request, response);
		 }
		 else{
			 // call error message 
		 }
		}
		
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
