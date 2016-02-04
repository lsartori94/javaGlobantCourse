package com.javaCourse.LucaSartori.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Loan {

	private Comic comic;
	private AuthenticatedUser user;
	private static AtomicInteger id = new AtomicInteger();
	private int realId = id.intValue();
	private String status = "PENDING";
	
	public Loan(Comic com, AuthenticatedUser user) {
		setComic(com);
		setUser(user);
		Loan.id.incrementAndGet();
		
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
	
	public int getId() {
		return realId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void print() {
		System.out.println("------------------------------------------------------");
		System.out.println("--------    ID= "+getId());
		System.out.println("--------    RENDERED TO= "+getUser().getName());
		System.out.println("--------    Comic= "+getComic().getName());
		System.out.println("--------    Status= "+getStatus());
		System.out.println("------------------------------------------------------");
	}
	
}
