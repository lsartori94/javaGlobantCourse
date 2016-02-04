package com.javaCourse.LucaSartori.views;

import java.util.ArrayList;

public class UserMenu {
	private ArrayList<String> options = new ArrayList<String>();
	
	public UserMenu() {
		options.add("0. Exit");
		options.add("1. List Comics");
		options.add("2. List Genres");
		options.add("3. Comics by Genre");
		options.add("4. Login");
	}
	
	public void print() {
		for (String string : options) {
			System.out.println(string);
		}
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	public void addItem(String item) {
		options.add(item);
	}
	
	public void removeItem(String item) {
		options.remove(options.indexOf(item));
	}
	
}
