package niitprash.ecommerceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import niitprash.ecommercebackend.dao.CategoryDAO;
import niitprash.ecommercebackend.dao.ProductDAO;
import niitprash.ecommercebackend.dto.Category;
import niitprash.ecommercebackend.dto.Product;

@Controller
public class PageController {
	
		@Autowired
		private CategoryDAO categoryDAO;
		
		@Autowired
		private ProductDAO productDAO;
		
		@RequestMapping(value= {"/","/home","/index"})
		public ModelAndView index() {
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("title","Home");
			mv.addObject("userClickHome",true);
			//passing list of categories
			mv.addObject("categories", categoryDAO.list());
			return mv;
		}
		
		@RequestMapping(value= {"/about"})
		public ModelAndView about() {
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("title","About Us");
			mv.addObject("userClickAbout",true);
			
			return mv;
		}
		
		@RequestMapping(value= {"contact"})
		public ModelAndView contact() {
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("title","Contact Us");
			mv.addObject("userClickContact",true);
			
			return mv;
		}
		
		// list all products 
		
		@RequestMapping(value= {"/show/all/products"})
		public ModelAndView showAllProducts() {
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("title","All Products");
			mv.addObject("categories",categoryDAO.list());
			mv.addObject("userClickAllProducts",true);
			
			return mv;
		}
		
		@RequestMapping(value= {"/show/category/{id}/products"})
		public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
			ModelAndView mv=new ModelAndView("page");
			
			//fetch single category
			Category category =null;
			category=categoryDAO.get(id);
			
			mv.addObject("title",category.getName());
			mv.addObject("categories",categoryDAO.list());
			mv.addObject("category",category);
			mv.addObject("userClickCategoryProducts",true);
			
			return mv;
		}
		
		@RequestMapping(value= {"/show/cart"})
		public ModelAndView cart() {
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("title","Cart");
			mv.addObject("userClickCart",true);
			
			return mv;
		}
		
		//view single product
		
		@RequestMapping(value= "/show/{id}/product")
		public ModelAndView showSinglePage(@PathVariable int id) {
			ModelAndView mv=new ModelAndView("page");
			Product product=productDAO.get(id);
			product.setViews(product.getViews()+1);
			
			//update view count
			productDAO.update(product);
			
			mv.addObject("title",product.getName());
			mv.addObject("product",product);
			mv.addObject("userClickShowProduct",true);
			
			return mv;
		}
		
		@RequestMapping(value= {"/login"})
		public ModelAndView login() {
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("title","Login");
			
			return mv;
		}
		
		@RequestMapping(value= {"/logout"})
		public ModelAndView logout() {
			ModelAndView mv=new ModelAndView("logout");
			mv.addObject("title","Logged Out!");
			
			return mv;
		}
		
		
}