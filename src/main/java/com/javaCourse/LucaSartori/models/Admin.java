package com.javaCourse.LucaSartori.models;

import com.javaCourse.LucaSartori.util.UserEnum;

public class Admin extends AuthenticatedUser {
	
	public Admin(String name, String password) {
		super(name, password);
		super.setType(UserEnum.ADMIN);
	}
	
}
