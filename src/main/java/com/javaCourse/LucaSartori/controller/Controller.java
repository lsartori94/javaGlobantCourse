package com.javaCourse.LucaSartori.controller;

import java.util.Scanner;

import com.javaCourse.LucaSartori.models.Admin;
import com.javaCourse.LucaSartori.models.AuthenticatedUser;
import com.javaCourse.LucaSartori.models.Comic;
import com.javaCourse.LucaSartori.models.Genre;
import com.javaCourse.LucaSartori.models.User;
import com.javaCourse.LucaSartori.util.ComicDb;
import com.javaCourse.LucaSartori.util.GenreDb;
import com.javaCourse.LucaSartori.util.UserDb;
import com.javaCourse.LucaSartori.views.AdminMenu;
import com.javaCourse.LucaSartori.views.AuthenticatedUserMenu;
import com.javaCourse.LucaSartori.views.UserMenu;

public class Controller {

	private final String userAdmin = "Sheldon";
	private final String passAdmin = "Bazzinga";
	private UserDb userDb = UserDb.getInstance();
	private ComicDb comicDb = ComicDb.getInstance();
	private GenreDb genreDb = GenreDb.getInstance();
	private UserMenu usrMenu = new UserMenu();
	private AuthenticatedUserMenu authMenu = new AuthenticatedUserMenu();
	private AdminMenu admMenu = new AdminMenu();
	private User currentUser = new User();
	
	
	public Controller() {
		Admin adm = new Admin(userAdmin, passAdmin);
		userDb.addUser(adm);
		AuthenticatedUser auth = new AuthenticatedUser("Luca", "asdf1234");
		userDb.addUser(auth);
		createSomeComics();
		createSomeGenres();
	}

	private void createSomeGenres() {
		Genre gen = new Genre("SUPERHERO");
		gen.setComics(comicDb.getGenre(gen.getName()));
		genreDb.addGenre(gen);
		
	}

	private void createSomeComics() {
		Comic com = new Comic("CAPITAN AMERICA", "MARVEL", "SUPERHERO");
		comicDb.addComic(com);
		Comic com2 = new Comic("IRON MAN", "MARVEL", "SUPERHERO", 1994, 002);
		comicDb.addComic(com2);
	}

	public void go() {
		boolean running = true;
		Scanner prompt = new Scanner(System.in);
		while (running) {
			printMenu();
			try {
				System.out.println(" ");
				System.out.println("Enter Option=  ");
				int option = prompt.nextInt();
				selectOption(option);
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid option");
			}
		}
		prompt.close();
	}

	private void selectOption(int option) {
		
		switch (currentUser.getType()) {
		case ADMIN:
			switch (option) {
			// Exit
			case 0:
				System.out.println(" ");
				System.out.println("Program Terminated");
				System.exit(0);;
				break;

			// List comics
			case 1:
				System.out.println("##############       COMIC LIST       ################");
				System.out.println(" ");
				listComics();
			    break;
			    
			// List genres
			case 2:
				System.out.println("##############       GENRE LIST       ################");
				System.out.println(" ");
				listGenres();
				break;
				
			// Login
			case 3:
				System.out.println("################       LOGIN        ##################");
				System.out.println(" ");
				login();
				break;
				
			// Request Loan
			case 4:
				System.out.println("############       REQUEST LOAN        ###############");
				System.out.println(" ");
				requestLoan();
				break;
					
			// List Loans
			case 5:
				System.out.println("#############        LIST LOANS        ###############");
				System.out.println(" ");
				listLoans();
				break;
					
			// Approve Loan
			case 6:
				System.out.println("############       APPROVE LOAN        ###############");
				System.out.println(" ");
				approveLoan();
				break;
					
			// Add Comic
			case 7:
				System.out.println("##############       ADD COMIC        ################");
				System.out.println(" ");
				addComic();
				break;
					
			// Remove Comic
			case 8:
				System.out.println("#############       REMOVE LOAN        ###############");
				System.out.println(" ");
				removeComic();
				break;
					
			// Add Genre
			case 9:
				System.out.println("##############       ADD GENRE        ################");
				System.out.println(" ");
				addGenre();
				break;
					
			// Remove Genre
			case 10:
				System.out.println("############        REMOVE GENRE       ###############");
				System.out.println(" ");
				removeGenre();
				break;
			
			// List Users
			case 11:
				System.out.println("############         USERS LIST       ################");
				System.out.println(" ");
				removeGenre();
				break;
				
			// Add user
			case 12:
				System.out.println("#############         ADD USER        ################");
				System.out.println(" ");
				removeGenre();
				break;
				
			// Remove User
			case 13:
				System.out.println("############       REMOVE USER        ################");
				System.out.println(" ");
				removeGenre();
				break;
				
			// Logout
			case 1000:
				logOut();
			break;
			}
			
		case AUTHENTICATED:
			switch (option) {
			// Exit
			case 0:
				System.out.println(" ");
				System.out.println("Program Terminated");
				System.exit(0);
				break;

			// List comics
			case 1:
				System.out.println("##############       COMIC LIST       ################");

				System.out.println(" ");
				listComics();
			    break;
			    
			// List genres
			case 2:
				System.out.println("##############       GENRE LIST       ################");

				System.out.println(" ");
				listGenres();
				break;
				
			// Login
			case 3:
				System.out.println("################       LOGIN        ##################");

				System.out.println(" ");
				login();
				break;
				
			// Request Loan
			case 4:
				System.out.println("############       REQUEST LOAN        ###############");

				System.out.println(" ");
				requestLoan();
				break;
				
			// Logout
			case 1000:
				logOut();
				break;
			}
			break;
			
		case NORMAL:
			switch (option) {
			// Exit
			case 0:
				System.out.println(" ");
				System.out.println("Program Terminated");
				System.exit(0);
				break;

			// List comics
			case 1:
				System.out.println("##############       COMIC LIST       ################");

				System.out.println(" ");
				listComics();
			    break;
			    
			// List genres
			case 2:
				System.out.println("##############       GENRE LIST       ################");

				System.out.println(" ");
				listGenres();
				break;
				
			// Login
			case 3:
				System.out.println("################       LOGIN        ##################");

				System.out.println(" ");
				login();
				break;
			
			default:
				System.out.println("Invalid Option. Re enter option");

				System.out.println(" ");
				break;
			}
			break;
		}
		
	}

	private void printMenu() {
		for (int i = 0; i < 5; i++) {
			System.out.println(" ");

		}
		System.out.println("##############       MAIN MENU       ################");
		System.out.println(" ");
		switch (currentUser.getType()) {
		case ADMIN:
			admMenu.print();
			break;
		case AUTHENTICATED:
			authMenu.print();
			break;
		case NORMAL:
			usrMenu.print();
			break;
		}
	}

	private void listComics() {
		comicDb.printComics();
	}
	
	private void listGenres() {
		genreDb.print();
	}
	
	private void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("USERNAME=  ");
		String usrName = in.next();
		System.out.println("PASSWORD= ");
		String usrPass = in.next();
		try {
			AuthenticatedUser aux = userDb.getUser(usrName);
			if (aux.getPassword().compareTo(usrPass) == 0) {
				currentUser = aux;
			}
			else {
				System.out.println("INCORRECT USERNAME OR PASSWORD!");
			}
			
		} catch (NullPointerException e) {
			System.out.println("INCORRECT USERNAME OR PASSWORD!");
		}
	}
	
	private void logOut() {
		currentUser = new User();
		System.out.println("##########       LOGOUT SUCCESFULL      ##############");
		System.out.println(" ");
	}
	
	private void requestLoan() {
		
	}
	
	private void listLoans() {
		
	}
	
	private void approveLoan() {
		
	}
	
	private void addComic() {
		
	}
	
	private void removeComic() {
		
	}
	
	private void addGenre() {
		
	}
	
	private void removeGenre() {
		
	}
	
	private void listUsers() {
		userDb.print();
	}
	
	private void addUser() {
		
	}
	
	private void removeUser() {
		
	}
	
}
