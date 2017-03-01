package com.project.controller;
 import java.io.IOException;
 import java.io.PrintWriter;
 import javax.servlet.Filter;
 import javax.servlet.FilterChain;
 import javax.servlet.FilterConfig;
 import javax.servlet.ServletException;
 import javax.servlet.ServletRequest;
 import javax.servlet.ServletResponse;
 import javax.servlet.annotation.WebFilter;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 
 @WebFilter
 public class Logout extends HttpServlet implements Filter {
 	private static final long serialVersionUID = 1L;
 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.setContentType("text/html");
 		
 		HttpSession session = request.getSession(false);
		 String mail=(String)session.getAttribute("email");
		System.out.println("MAIL\n\n\n\n\n"+mail);	
		 if(mail==null){
				request.setAttribute("errorMessage", "<a href=\"index.jsp\">Please Login</a> ");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		 else{
 		session.invalidate();
 		request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		 }
 		
 	@Override
 	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
 		HttpServletResponse response = (HttpServletResponse) res;
 		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
 		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
 		response.setDateHeader("Expires", 0); // Proxies
 		chain.doFilter(req, res);
 	}
 	
 	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
 		doGet(request, response);
 	}
 
 	@Override
 	public void init(FilterConfig arg0) throws ServletException {
 	}
 
 }