package com.omilia.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.omilia.service.BuLogic;

public class BuLogicTest {
	String userInput;
	
	BuLogic buLogic = new BuLogic();

	
	@Before
	public void before() {
		
		userInput = "";
				
	}
	
	@Test
	public void returnString() {
		
		assertEquals ("You didn't type anything. ", buLogic.userInputValidator(userInput));
		
	}

}
