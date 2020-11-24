package com.aaronkirchhoff.displaydate.controllers;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
		DateTimeFormatter formatted = DateTimeFormatter.ofPattern("eeee-d-MMMM-y");
		formatted.format(myDate);
		String mydate2 = formatted.format(myDate);

		System.out.println(formatted.format(myDate));
		model.addAttribute("myDate", mydate2);
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
		DateTimeFormatter formatted = DateTimeFormatter.ofPattern("h:m a");
		formatted.format(myTime);
		String mytime2 = formatted.format(myTime);

		System.out.println(formatted.format(myTime));
		model.addAttribute("myTime", mytime2);
		return "time.jsp";		
	}

}
