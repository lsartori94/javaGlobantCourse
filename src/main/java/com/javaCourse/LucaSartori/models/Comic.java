package com.javaCourse.LucaSartori.models;

public class Comic implements Comparable<Comic>{

	private String name;
	private String author;
	private int year;
	private int issueNumber;
	private int cantCopies;
	private String genre;
	
	public Comic(String name, String author, String genre) {
		setName(name);
		setAuthor(author);
		setGenre(genre);
		setCantCopies(1);
	}
	
	public Comic(String name, String author, String genre, int year, int issueNumber) {
		setAuthor(author);
		setName(name);
		setGenre(genre);
		setYear(year);
		setIssueNumber(issueNumber);
		setCantCopies(1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getCantCopies() {
		return cantCopies;
	}

	public void setCantCopies(int cantCopies) {
		this.cantCopies = cantCopies;
	}

	public int compareTo(Comic arg0) {
		return this.name.compareTo(arg0.name);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void print() {
		System.out.println("------------------------------------------------------");
		System.out.println("--------    TITLE= "+name);
		System.out.println("--------    Author= "+author);
		System.out.println("--------    YEAR= "+year);
		System.out.println("--------    ISSUE NUMBER= ");
		System.out.println("--------    AVAILABILITY= ");
		System.out.println("--------    GENRE= "+genre);
		System.out.println("------------------------------------------------------");
	}

}
