package com.javaCourse.LucaSartori.util;

import java.util.Set;
import java.util.TreeSet;

import com.javaCourse.LucaSartori.models.User;


/*
 * Singleton Set.
 * Contains a TreeSet of User
 */
public class UserSet {
	
	private static UserSet instance = null;
	private Set<User> users = new TreeSet<User>();
	
	protected UserSet() {
		// not used, singleton class
	}
	
	public static UserSet getInstance() {
		if (instance == null) {
			instance = new UserSet();
		}
		return instance;
	}
	
	public boolean addUser(User toAdd) {
		if (users.contains(toAdd)) {
			System.out.println("User Already Exists");
			return false;
		}
		else {
			System.out.println("User added");
			users.add(toAdd);
			return true;
		}
	}
	
	public boolean removeUser(User toRemove) {
		try {
			users.remove(toRemove);
			System.out.println("User removed");
			return true;
		}
		catch (NullPointerException e) {
			System.out.println("User does not exists");
			return false;
		}
	}
}
