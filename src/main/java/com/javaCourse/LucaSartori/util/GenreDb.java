package com.javaCourse.LucaSartori.util;

import java.util.Set;
import java.util.TreeSet;

import com.javaCourse.LucaSartori.models.Genre;

public class GenreDb {

	private static GenreDb instance = null;
	private Set<Genre> genres = new TreeSet<Genre>();
	
	private GenreDb() {
		// empty, singleton class
	}
	
	public static GenreDb getInstance() {
		if (instance == null) {
			instance = new GenreDb();
		}
		return instance;
	}
	
	public boolean addGenre(Genre toAdd) {
		if (genres.contains(toAdd)) {
			System.out.println("Genre Already Exists");
			return false;
		}
		else {
			System.out.println("Genre added");
			genres.add(toAdd);
			return true;
		}
	}
	
	public boolean removeGenre(String toRemove) {
		for (Genre gen : genres) {
			if (gen.getName().compareTo(toRemove) == 0) {
				genres.remove(gen);
				System.out.println("Genre Removed");
				return true;
			}
		}
			System.out.println("Genre does not exists");
			return false;
	}
	
	public Genre getGenre(String name) {
		for (Genre gen : genres) {
			if (gen.getName().compareTo(name) == 0) {
				return gen;
			}
		}
		return null;
	}
}
