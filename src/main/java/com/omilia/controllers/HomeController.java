package com.omilia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//HomeController returns the index.jsp. The first view/page of the application

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {

		return "index";
	}	
}
