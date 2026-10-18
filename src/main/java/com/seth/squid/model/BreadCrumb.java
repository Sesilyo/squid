// [FILENAME]: BreadCrumb.java
package com.seth.squid.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class BreadCrumb {
	private final Deque<String> crumbs = new ArrayDeque<>();
	
	public BreadCrumb() {
		this.crumbs.push("Main");	// BreadCrumb initializes with Main by default
	}
	
	/*
	 * Adds a new crumb to the bread crumb
	 * 
	 * @param the name of the navigation step to add
	 */
	public void addCrumb(String crumb) {
		this.crumbs.push(crumb);
	}
	
	/*
	 * Removes the latest crumb from the bread crumb
	 */
	public void removeCrumb() {
		if (this.crumbs.size() > 1) this.crumbs.pop();	// guards the deque so "Main" will never be popped
	}
	
	public Deque<String> getBreadCrumb() {
		return this.crumbs;
	}
}
