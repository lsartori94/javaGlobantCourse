package com.javaCourse.LucaSartori.models;

import java.util.Set;
import java.util.TreeSet;

public class Genre {

	private String name;
	private int cantComics;
	private Set<Comic> comics = new TreeSet<Comic>();

	public Genre(String name){
		setCantComics(0);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCantComics() {
		return cantComics;
	}

	public void setCantComics(int cantComics) {
		this.cantComics = cantComics;
	}

	public Set<Comic> getComics() {
		return comics;
	}

	public void setComics(Set<Comic> comics) {
		this.comics = comics;
	}
	
	public void addComic(Comic com) {
		if (comics.contains(com)) {
			cantComics++;
		}
		else {
			comics.add(com);
		}
	}
	
	public void removeComic(Comic comic) {
		try{
			comics.remove(comic);
			System.out.println("Comic removed.");
		}
		catch (NullPointerException e) {
			System.out.println("Comic does not exist in this genre");
		}
	}
	
	public void print() {
		System.out.println(" ");
		System.out.println("------------------------------------------------------");
		System.out.println("--------    NAME= "+name);
		System.out.println("--------    # COMICS= "+cantComics);
		System.out.println("------------------------------------------------------");
	}
	
	public void printComics() {
		System.out.println("##############       COMIC LIST       ################");
		for (Comic comic : comics) {
			comic.print();
		}
	}
	
}
