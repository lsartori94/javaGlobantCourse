package com.javaCourse.LucaSartori.util;

import java.util.Set;
import java.util.TreeSet;

import com.javaCourse.LucaSartori.models.AuthenticatedUser;

/*
 * Singleton Set.
 * Contains a TreeSet of User
 */
public class UserDb {
	
	private static UserDb instance = null;
	private Set<AuthenticatedUser> users = new TreeSet<AuthenticatedUser>();
	
	protected UserDb() {
		// not used, singleton class
	}
	
	public static UserDb getInstance() {
		if (instance == null) {
			instance = new UserDb();
		}
		return instance;
	}
	
	public boolean addUser(AuthenticatedUser toAdd) {
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
	
	public boolean removeUser(AuthenticatedUser toRemove) {
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
	
	public AuthenticatedUser getUser(String name) {
		for (AuthenticatedUser user : users) {
			if (user.getName().compareTo(name) == 0) {
				return user;
			}
		}
		return null;
	}
}
