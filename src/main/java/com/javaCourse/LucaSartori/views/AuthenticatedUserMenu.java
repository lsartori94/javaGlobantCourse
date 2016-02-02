package com.javaCourse.LucaSartori.views;

public class AuthenticatedUserMenu extends UserMenu {

	public AuthenticatedUserMenu() {
		super();
		super.removeItem("3. Login");
		super.addItem("3. Request Loan");
	}
}
