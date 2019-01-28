package com.omilia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omilia.entity.UserInput;
import com.omilia.service.BuLogic;

//FormsController returns all the views/jsps according to the request 
@Controller
public class FormsController {

	//Autowiring to give access to business logic	
	@Autowired
	private BuLogic buLogic;


	//Controller method to show the input form		
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		//create a UserInput object
		UserInput userInput = new UserInput();

		//add userInput object to the model
		model.addAttribute("userInput", userInput);	

		return "input-form";
	}

	//Method that receives user's input, processes the data and returns the result /jsp
	//Functions by making a chain calling to the business logic methods	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("userInput")UserInput userInput, ModelMap model) {

		String result = buLogic.userInputValidator(userInput.getInput());

		model.addAttribute("message", result);

		return "output";
	}

}



