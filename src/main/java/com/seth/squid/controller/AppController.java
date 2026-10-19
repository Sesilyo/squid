// [FILENAME]: AppController.java
package com.seth.squid.controller;

import java.util.Scanner;

import com.seth.squid.view.InputIndicator;

public class AppController {
	
	// the single scanner instance for the app life-cycle
	private static final Scanner scanner = new Scanner(System.in);
	
	
	/*
	 * Safely reads a line from standard input
	 * @return The Raw command entered by user or empty sting is no input
	 */
	private static String scanCL() {
		try {
			if (scanner.hasNextLine()) {
				return scanner.nextLine();							
			}
		} catch (Exception e) {
			System.err.println("Error reading input: " + e.getMessage());
		}
		
		return "";
	}
	
	/*
	 * Entry point of the AppController class.
	 * Akin to Main.java's main() function.
	 *
	 */
	public static void run() {
		System.out.println("AppController running");
		
		// instantiate token parser component
		PromptScanner promptScanner = new PromptScanner();
		
		// execution loop
		while (true) {
			System.out.print(InputIndicator.MAIN_INP_INDICATOR);
			String rawInput = scanCL();
			System.out.println(rawInput);
		}
	}
}
