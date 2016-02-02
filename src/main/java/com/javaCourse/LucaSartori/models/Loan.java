package com.javaCourse.LucaSartori.models;

public class Loan {

	private Comic comic;
	private AuthenticatedUser user;
	
	public Loan(Comic com, AuthenticatedUser user) {
		setComic(com);
		setUser(user);
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}

	public AuthenticatedUser getUser() {
		return user;
	}

	public void setUser(AuthenticatedUser user) {
		this.user = user;
	}
	
}
