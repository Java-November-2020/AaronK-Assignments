package com.aaronkirchhoff.displaydate.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDate myDate = LocalDate.now();
		model.addAttribute("myDate", myDate);
		return "date.jsp";		
	}
//	ok the method above, date, is passing a parameter we can call in our view file. on line 20, 
//	we instantiate first a variable name for our import date and make a new date().
//	then we need to set up that variabel myDate and let our view page have it's own variable name to call, 
//	we'll name it the same thing, myDate and in our view we'll call it using ${myDate}.
//	and then on line uh, uh , in don't know.
	
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalTime myTime = LocalTime.now();
		model.addAttribute("myTime", myTime);
		return "time.jsp";		
	}

}
