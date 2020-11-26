package com.aaronkirchhoff.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String Index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count", 1);
		}
		else {
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}

}
