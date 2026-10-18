// [FILENAME]: PromptScanner.java
package com.seth.squid.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.seth.squid.model.ArgToken;

public class PromptScanner {
	static ArrayList args = new ArrayList<String>();
	static Scanner scanner;
	
	public PromptScanner() {
		
	}
	
	/**
	 * Gets arguments from user using Scanner
	 * @return 
	 */ 
	private String getArgs() {
		return scanner.nextLine();
	}
	
	private void tokenizeArgs() {
		String args = getArgs();
		
		if (args == null || args.isBlank()) {
			
		}
		
		String[] initialTokens = args.split("\\s+");
		
		for (String token : initialTokens) {
			switch(token) {
				case ArgToken.INIT_LOG:
			}
		}
		
	}
}
