package com.techies.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@Autowired 
	private BeanExample beanExample;
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String user = "Kumar";
		return new ModelAndView("welcome", "user", user);
	}
	
	@RequestMapping("/bean")
	public ModelAndView bean() {
 
		String user = beanExample.print();
		return new ModelAndView("welcome", "user", user);
	}
}