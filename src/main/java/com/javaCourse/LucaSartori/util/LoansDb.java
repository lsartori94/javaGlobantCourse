package com.javaCourse.LucaSartori.util;

import java.util.HashSet;
import java.util.Set;

import com.javaCourse.LucaSartori.models.Loan;


public class LoansDb {
	
	private static LoansDb instance = null;
	private Set<Loan> loans = new HashSet<Loan>();
	
	private LoansDb() {
		// not used, singleton class
	}
	
	public static LoansDb getInstance() {
		if (instance == null) {
			instance = new LoansDb();
		}
		return instance;
	}
	
	public boolean addLoan(Loan toAdd) {
		if (loans.contains(toAdd)) {
			System.out.println("Loan Already Exists");
			return false;
		}
		else {
			System.out.println("Loan added");
			loans.add(toAdd);
			return true;
		}
	}
	
	public boolean removeLoan(int idToKill) {
		for (Loan loan : loans) {
			if (loan.getId() == idToKill) {
				loan.print();
				loans.remove(loan);
				return true;
			}
		}
			System.out.println("Loan does not exists");
			return false;
	}
	
	public Loan getLoan(int id) {
		for (Loan loan : loans) {
			if (loan.getId() == id) {
				return loan;
			}
		}
		return null;
	}
	
	public boolean userHasLoan(String user) {
		for (Loan loan : loans) {
			if (loan.getUser().getName().compareTo(user) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		if (!loans.isEmpty()) {
			for (Loan loan : loans) {
				loan.print();
			}
		}
		else {
			System.out.println("There are not any Loans");
		}
	}
}
