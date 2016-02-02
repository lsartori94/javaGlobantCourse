package com.javaCourse.LucaSartori.models;

public class Comic implements Comparable<Comic>{

	private String name;
	private String author;
	private int year;
	private int issueNumber;
	private int cantCopies;
	
	public Comic(String name, String author) {
		setName(name);
		setAuthor(author);
	}
	
	public Comic(String name, String author, int year, int issueNumber) {
		setAuthor(author);
		setName(name);
		setYear(year);
		setIssueNumber(issueNumber);
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

}
