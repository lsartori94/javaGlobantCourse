package com.javaCourse.LucaSartori.views;

public class AuthenticatedUserMenu extends UserMenu {

	public AuthenticatedUserMenu() {
		super();
		super.removeItem("4. Login");
		super.addItem("4. Request Loan");
		super.addItem("1000. Log Out");
	}
}
