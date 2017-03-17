package com.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Category;
import com.project.bean.Product;
import com.project.bl.CustomerBl;

@Controller
@SessionAttributes({"pcategory"})
public class GetProductsController  {

@RequestMapping(value="/GetProducts")
	public ModelAndView myLogin(@RequestParam("selectedCategory") String selectedCategory,ModelMap model){
		ModelAndView mv=new ModelAndView();
	
	
		String email=(String)model.get("email");
		CustomerBl customerBl = new CustomerBl();
		ArrayList<Product> proList =null;
		String pcategory=null;
		ArrayList<Category> category = null;
		try {
			category = (ArrayList<Category>) customerBl.viewCategory();
			proList = (ArrayList<Product>)customerBl.viewProduct(selectedCategory);
			System.out.println(proList);
			mv.addObject("productList",proList);
			mv.setViewName("women");
			mv.addObject("categoryList", category);
			return mv;
		} catch (ClassNotFoundException | SQLException e) {
		
		System.out.println(e);
		}
		if(email!=null){
			
			mv.addObject("currentCategory", pcategory);
		}
		
            mv.addObject("productList",proList);
            mv.setViewName("women");
		
		      return mv;
				}

			

		}
	
