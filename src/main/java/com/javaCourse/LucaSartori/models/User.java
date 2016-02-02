package com.javaCourse.LucaSartori.models;

import com.javaCourse.LucaSartori.util.UserEnum;

public class User {
	private UserEnum type;
	
	public User() {
		setType(UserEnum.NORMAL);
	}

	public UserEnum getType() {
		return type;
	}

	public void setType(UserEnum type) {
		this.type = type;
	}
	
}
