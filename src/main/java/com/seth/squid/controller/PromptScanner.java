// [FILENAME]: PromptScanner.java
package com.seth.squid.controller;

import java.util.ArrayList;

import com.seth.squid.model.ArgToken;

public class PromptScanner {
	static ArrayList<String> args = new ArrayList();
	
	public PromptScanner() {
		
	}
	
	private void tokenizeArgs(String rawInput) {
		if (rawInput == null || rawInput.isBlank()) {
			return;
		}
		
		// Clean out previous loop cycles
		args.clear();
		
		String[] initialTokens = rawInput.split("\\s+");
		
		// checks if tokens
		for (String token : initialTokens) {
			switch(token) {
				case ArgToken.INIT_LOG:
			}
		}
		
	}
}
