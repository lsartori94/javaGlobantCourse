package com.javaCourse.LucaSartori.views;

public class AdminMenu extends UserMenu {

	public AdminMenu() {
		super();
		super.removeItem("3. Login");
		super.addItem("3. List Loans");
		super.addItem("4. Aprove Loan");
		super.addItem("5. Add Comic");
		super.addItem("6. Remove Comic");
		super.addItem("7. Add Genre");
		super.addItem("8. Remove Genre");
	}
	
}
