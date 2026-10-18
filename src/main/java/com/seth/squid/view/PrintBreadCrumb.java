// [FILENAME]: PrintBreadCrumb.java
package com.seth.squid.view;

import java.util.Deque;
import java.util.ArrayList;
import java.util.Collections;

import com.seth.squid.model.BreadCrumb;

public class PrintBreadCrumb {
	final static String DELIMITER = " > ";
	
	public PrintBreadCrumb(BreadCrumb breadCrumb) {
		if (breadCrumb != null) {
			System.out.println(formatBC(breadCrumb.getBreadCrumb()));
		}
	}
	
	/*
	 * Formats breadcrumb deque chronologically and with delimiters into a readable UI string.
	 * @param breadCrumb The navigation stack from the BreadCrumb model
	 * @return A formatted path stream string
	 */
	private String formatBC(Deque<String> breadCrumb) {
		if (breadCrumb == null || breadCrumb.isEmpty()) return "";
		
		// copy deque into a list for safe manipulation
		ArrayList<String> reverseList = new ArrayList<>(breadCrumb);
		
		// reverse the list
		Collections.reverse(reverseList);
		
		// join the crumbs into a string with the delimiter
		return String.join(DELIMITER, reverseList);
	}
	
}
