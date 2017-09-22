package niitprash.ecommerceproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

		@RequestMapping(value= {"/","/home","/index"})
		public ModelAndView index() {
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("msg","Hey You! :)");
			return mv;
		}
		
//		@RequestMapping(value="/test")
//		public ModelAndView test(@RequestParam(value="msg", required=false)String msg) {
//			if(msg==null) {
//				msg="Prash";
//			}
//			ModelAndView mv=new ModelAndView("page");
//			mv.addObject("msg",msg);
//			return mv;
//		}
		
//		@RequestMapping(value="/test/{msg}")
//		public ModelAndView test(@PathVariable("msg")String msg) {
//			if(msg==null) {
//				msg="Prash";
//			}
//			ModelAndView mv=new ModelAndView("page");
//			mv.addObject("msg",msg);
//			return mv;
//		}
}
