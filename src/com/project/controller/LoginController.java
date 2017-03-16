package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Category;
import com.project.bean.Customer;
import com.project.bl.CustomerBl;


@Controller

@SessionAttributes({"email","customer"})
@RequestMapping("/")
public class LoginController {

	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView myMain(){
		ModelAndView mv=new ModelAndView();
		CustomerBl customerBL = new CustomerBl();
		ArrayList<Category> category= null;
		
		try{
			category=(ArrayList<Category>)customerBL.viewCategory();
		}
		catch(ClassNotFoundException|SQLException e){
			System.out.println(e);
		} 
		mv.addObject("categoryList", category);
		mv.setViewName("index");
		mv.addObject("customer", new Customer());
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/login")
	public ModelAndView myLogin(@ModelAttribute("customer")Customer customer){
		ModelAndView mv=new ModelAndView();
		CustomerBl customerBL = new CustomerBl();
		
		String email=customer.getEmail();
		String password=customer.getPassword();
		if(email.equals("admin@admin.com")&&password.equals("admin@123")){
			
		try{
			mv.setViewName("admin");
		}
		catch(Exception e){
			System.out.println(e);
		}
		}
	
		else{
			Customer customer1;
			try{
				customer1 = customerBL.signIn(email, password);
				System.out.println(customer);
			}
			catch(ClassNotFoundException | SQLException e){
				mv.addObject("message", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				mv.setViewName("index");
				System.out.println(e);
				return mv;    
			}
		
			if(customer==null){
				mv.addObject("message", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				mv.setViewName("error404page.jsp");
			}
			else{
				try{
					mv.addObject("customer", customer1);
				    mv.setViewName("index");
				    return mv;
				}
				catch(Exception e){
					System.out.println(e);
				}
				
			}
	}	
		
		return mv;
		
	}
}
