package niitprash.ecommerceproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	
	@RequestMapping(value= {"/show/cart"})
	public ModelAndView cart() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Cart");
		mv.addObject("userClickCart",true);
		mv.addObject("cartLines",null);
		return mv;
	}
}
