package com.techies.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.launcher.PersonServiceImpl;

@Controller
public class HelloController {

	@Autowired 
	private BeanExample beanExample;
	
	@Autowired 
	private PersonServiceImpl personImpl;

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

	
	@RequestMapping(value="/passValues", method=RequestMethod.GET)
	public ModelAndView passValues(@RequestParam("name") String user, @RequestParam("country") String country, Model model) {

		System.out.println("User: " + user);
		System.out.println("Country:" + country);

		personImpl.persist(user, country);

		return new ModelAndView("success", "user", user);
	}
	
	@RequestMapping("/getLocations")
	public ModelAndView sendLocations(){
		
		//we will populate this data from the DB
		//using only sample co-ordinates
		Map<String, String> latLngMap = new HashMap<String, String>();
		latLngMap.put("Pithoragarh, Uttarakhand, India", "29.582861,80.218185");
		latLngMap.put("Pipariya, Madhya Pradesh, India", "22.762886,78.352478");
		latLngMap.put("Tiruvannamalai, Tamil Nadu, India", "12.228628,79.066544");
		
		 return new ModelAndView("showLocations", "latLngMap", latLngMap);
		
	}
}