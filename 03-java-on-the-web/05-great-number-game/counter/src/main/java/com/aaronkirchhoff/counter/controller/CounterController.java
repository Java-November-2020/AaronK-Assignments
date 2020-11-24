package com.aaronkirchhoff.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpSession session, Model viewModel) {
		if(session.getAttribute("userCounter") == null) {
			session.setAttribute("userCounter", 0);
		}
		
		viewModel.addAttribute("viewCounter", session.getAttribute("userCounter"));
		System.out.println("viewCounter");
		return "index.jsp";
	}

}
