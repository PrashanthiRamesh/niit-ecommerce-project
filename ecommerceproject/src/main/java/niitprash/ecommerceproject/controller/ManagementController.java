package niitprash.ecommerceproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import niitprash.ecommercebackend.dao.CategoryDAO;
import niitprash.ecommercebackend.dao.ProductDAO;
import niitprash.ecommercebackend.dto.Category;
import niitprash.ecommercebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO; 
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger=LoggerFactory.logger(ManagementController.class);
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title","Manage Products");
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		if(operation !=null) {
			if(operation.equals("product")) {
			mv.addObject("message","Sucess: Product Added! ");	  
			}
		} 
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		 return categoryDAO.list();
	}
	
	//POST - to store products in db
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String storeProducts(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model) {
		
		//validate product attributes
		
		if(results.hasErrors()) {
	
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message", "Validation Failed !");
			return "page";
		}
		logger.info(mProduct.toString());
		productDAO.add(mProduct);
	
		return "redirect:/manage/products?operation=product";
	}
}
