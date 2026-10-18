// [FILENAME]: Main.java
package com.seth.squid;

import com.seth.squid.controller.AppController;

public class Main {
	
	/*
	 * Entry point of the application
	 * 
	 */
	public static void main(String[] args) {
		run();
	}
	
	/*
	 * Calls an access to AppController via AppController's run() method
	 * 
	 */
	private static void run() {
		System.out.println("Running Squid");
		AppController.run();
	}
}
