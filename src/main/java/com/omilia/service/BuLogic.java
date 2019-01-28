package com.omilia.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BuLogic {
	
	//Method that checks if the user entered any data or not		
	public String userInputValidator(String userInput) {

		if(userInput != null && !userInput.isEmpty()) {
			return isNaturalNumber(userInput);			
		}else {
			return "You didn't type anything. ";
		}		
	}

	//Method that verifies if the data is a natural number	
	private String isNaturalNumber(String userInput) {
		int count = 0;
		String[] numbers = userInput.trim().split("\\s+");
		for (String temp : numbers) {
			if(!temp.matches("[0-9]+")) {				
				count++;				
			}
		}
		if(count == 0) {
			return numberFormatValidator(userInput);
		}else {
			return "Please provide a valid number. ";
		}
	}

	//Method that verifies if the provided number is in the requested format	
	private String numberFormatValidator(String userInput) {
		int occurence = 0;

		List<String> dividedNumbers = new ArrayList<>();

		dividedNumbers.addAll(Arrays.asList(userInput.trim().split("\\s+")));

		for (String temp : dividedNumbers) {
			if(temp.length() > 3) {
				occurence++;
			}
		}

		if(occurence == 0) {
			return "The input " + userInput + " you provided is valid. " +
			"\nProvided number contains " +dividedNumbers.size() + " block(s) of numbers: " +
			"\n"+dividedNumbers + "\n"+
			isGreekTelNumber(dividedNumbers);
		}else {
			return "The number you provided is not in the acceptable format. " +
			"\nNumber consists of " + occurence + " block(s) containing more than 3 digits: " +
			"\n"+dividedNumbers;
		}		
	}
	
	//Method that verifies if the provided number is a valid Greek telephone number	
	private String isGreekTelNumber(List<String> dividedNumbers) {
		
		StringBuilder telNumber = new StringBuilder();

		for (String s : dividedNumbers)
			telNumber.append(s);
							
	    return "\nIs " + telNumber + " a valid Greek phone number : " + telNumber.toString().matches("^(2[0-9]{9}$|^69[0-9]{8}$|^00302[0-9]{9}$|^003069[0-9]{8})$" );
		}
	
	
//	private void ambiguityChecker(List<String> dividedNumbers) {
//
//		StringBuilder telNumber = new StringBuilder();
//
//		List<String> ambiguousNumbers = new ArrayList<>();		
//
//		String[] stringArray = dividedNumbers.toArray(new String[0]);
//
//		int[] integers = new int[stringArray.length];
//
//		for (int i = 0; i < integers.length; i++){
//			integers[i] = Integer.parseInt(stringArray[i]); 
//		}
//
//
//		for (int i = 0; i < stringArray.length; i++) {
//			if(stringArray[i].length() == 1) {
//				telNumber.append(stringArray[i]);
//
//				if(stringArray[i].length() == 2) {
//					if(stringArray[i].charAt(0) != 1) {
//						telNumber.append(stringArray[i].)
//					}
//
//				}
//			}
//		}
//	}

}
