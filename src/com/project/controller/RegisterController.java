package com.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;

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


public class RegisterController {

	
	/*
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
	}*/
	
	
	@RequestMapping(value="/register")
	public ModelAndView myLogin(){
		ModelAndView mv=new ModelAndView();
		System.out.println("ererer>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		mv.setViewName("./register"); 
		/*
		try {
			if(customerBL.signUp(customer)>0){
				mv.addObject("customer", customer);
				mv.setViewName("index");
			}
			else{
				mv.addObject("message", "<a href=\"index.jsp\">Invalid User, please retry again</a>");
				mv.setViewName("register");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}*/
		System.out.println("ererer");
		return mv;
		
}
}