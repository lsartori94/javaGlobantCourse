package com.javaCourse.LucaSartori.models;

import com.javaCourse.LucaSartori.util.UserEnum;

public class AuthenticatedUser extends User {

	private String name;
	private String password;
	
	public AuthenticatedUser(String name, String pass) {
		super();
		super.setType(UserEnum.AUTHENTICATED);
		setName(name);
		setPassword(pass);
		System.out.println(printUser()+" created.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String printUser() {
		return "Name: "+getName();
	}
	
}
