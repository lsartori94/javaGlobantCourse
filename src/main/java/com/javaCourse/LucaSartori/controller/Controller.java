package com.javaCourse.LucaSartori.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.javaCourse.LucaSartori.models.Admin;
import com.javaCourse.LucaSartori.models.AuthenticatedUser;
import com.javaCourse.LucaSartori.models.Comic;
import com.javaCourse.LucaSartori.models.Genre;
import com.javaCourse.LucaSartori.models.Loan;
import com.javaCourse.LucaSartori.models.User;
import com.javaCourse.LucaSartori.util.ComicDb;
import com.javaCourse.LucaSartori.util.GenreDb;
import com.javaCourse.LucaSartori.util.LoansDb;
import com.javaCourse.LucaSartori.util.UserDb;
import com.javaCourse.LucaSartori.views.AdminMenu;
import com.javaCourse.LucaSartori.views.AuthenticatedUserMenu;
import com.javaCourse.LucaSartori.views.UserMenu;

public class Controller {

	private final String userAdmin = "SHELDON";
	private final String passAdmin = "Bazzinga";
	private UserDb userDb = UserDb.getInstance();
	private ComicDb comicDb = ComicDb.getInstance();
	private GenreDb genreDb = GenreDb.getInstance();
	private LoansDb loanDb = LoansDb.getInstance();
	private UserMenu usrMenu = new UserMenu();
	private AuthenticatedUserMenu authMenu = new AuthenticatedUserMenu();
	private AdminMenu admMenu = new AdminMenu();
	private User currentUser = new User();
	
	
	public Controller() {
		Admin adm = new Admin(userAdmin, passAdmin);
		userDb.addUser(adm);
		AuthenticatedUser auth = new AuthenticatedUser("LUCA", "asdf1234");
		userDb.addUser(auth);
		createSomeGenres();
		createSomeComics();
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
		genreDb.getGenre("SUPERHERO").addComic(com);
		genreDb.getGenre("SUPERHERO").addComic(com2);
		genreDb.getGenre("SUPERHERO").setCantComics(2);
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
				System.out.println(" ");
				System.out.println("PRESS ENTER TO CONTINUE");
				System.in.read();
			}
			catch (InputMismatchException | IOException e) {
				System.out.println("Invalid option");
				prompt.next();
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
				
			// Comics by Genre
			case 3:
				System.out.println("###########       COMICS BY GENRE        #############");
				System.out.println(" ");
				comicsByGenre();
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
					
			// Reject Loan
			case 7:
				System.out.println("############       REJECT LOAN        ################");
				System.out.println(" ");
				rejectLoan();
				break;
					
			// Add Comic
			case 8:
				System.out.println("##############       ADD COMIC        ################");
				System.out.println(" ");
				addComic();
				break;
				
			// Remove Comic
			case 9:
				System.out.println("#############       REMOVE COMIC        ##############");
				System.out.println(" ");
				removeComic();
				break;
					
			// Add Genre
			case 10:
				System.out.println("##############       ADD GENRE        ################");
				System.out.println(" ");
				addGenre();
				break;
					
			// Remove Genre
			case 11:
				System.out.println("############        REMOVE GENRE       ###############");
				System.out.println(" ");
				removeGenre();
				break;
			
			// List Users
			case 12:
				System.out.println("############         USERS LIST       ################");
				System.out.println(" ");
				listUsers();
				break;
				
			// Add user
			case 13:
				System.out.println("#############         ADD USER        ################");
				System.out.println(" ");
				addUser();
				break;
				
			// Remove User
			case 14:
				System.out.println("############       REMOVE USER        ################");
				System.out.println(" ");
				removeUser();
				break;
				
			// Logout
			case 1000:
				logOut();
				break;
			}
			break;
			
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
				
			// Comics by Genre
			case 3:
				System.out.println("###########       COMICS BY GENRE        #############");
				System.out.println(" ");
				comicsByGenre();
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
				
			// Comics by Genre
			case 3:
				System.out.println("###########       COMICS BY GENRE        #############");
				System.out.println(" ");
				comicsByGenre();
				break;
			
			// Login
			case 4:
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
		for (int i = 0; i < 2; i++) {
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

	private boolean listComics() {
		return comicDb.printComics();
	}
	
	private boolean listGenres() {
		return genreDb.print();
	}
	
	private void comicsByGenre() {
		Scanner in = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				System.out.println("Enter a Genre: ");
				String genre = in.next().toUpperCase();
				Genre gen = genreDb.getGenre(genre);
				if (gen != null) {
					// GENRE EXISTS
					System.out.println(" ");
					System.out.println("##############       "+gen.getName()+"       ################");
					gen.printComics();
					loop = false;
				}
				else {
					System.out.println(" ");
					System.out.println("Genre does not exist");
					System.out.println("Try Again? y/n");
					String choise = in.next().toUpperCase();
					if (choise.compareTo("Y") != 0) {
						loop = false;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a Genre");
				System.out.println(" ");
			}
		}
	}
	
	private void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("USERNAME=  ");
		String usrName = in.nextLine().toUpperCase();
		System.out.println("PASSWORD= ");
		String usrPass = in.nextLine();
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
		boolean loop = true;
		while (loop) {
			try {
				Scanner in = new Scanner(System.in);
				System.out.println("Enter a Comic Name: ");
				String name = in.nextLine().toUpperCase();
				Comic toLoan = comicDb.getComic(name);
				// Comic found
				if (toLoan != null) {
					if (toLoan.getToRender() > 0) {
						AuthenticatedUser auth = (AuthenticatedUser) currentUser;
						Loan newLoan = new Loan(toLoan, auth);
						loanDb.addLoan(newLoan);
					}
					else {
						System.out.println("There are not copies left to lend");
					}
					loop = false;
				}
				else {
					System.out.println("Comic does not exists. Try again? y/n");
					String choise = in.nextLine().toUpperCase();
					// No
					if (choise.compareTo("Y") != 0) {
						loop = false;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a Comic name");
			}
		}
	}
	
	private boolean listLoans() {
		return loanDb.print();
	}
	
	private void approveLoan() {
		boolean loop = true;
		while (loop) {
			try {
				listLoans();
				Scanner in = new Scanner(System.in);
				System.out.println("Enter a Loan ID: ");
				int id = in.nextInt();
				Loan toApp = loanDb.getLoan(id);
				// Loan found
				if (toApp != null) {
					Comic cdb = comicDb.getComic(toApp.getComic().getName());
					if (cdb.getToRender() > 0) {
						toApp.setStatus("APPROVED");
						cdb.setToRender(cdb.getToRender()-1);;
						toApp.getComic().setToRender(toApp.getComic().getToRender()-1);
					}
					else {
						System.out.println("No more copies available to render");
					}
					loop = false;
				}
				else {
					System.out.println("Loan does not exists. Try again? y/n");
					String choise = in.nextLine().toUpperCase();
					// No
					if (choise.compareTo("Y") != 0) {
						loop = false;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a Loan ID");
			}
		}
	}
	
	private void rejectLoan() {
		boolean loop = true;
		while (loop) {
			try {
				if (listLoans()) {
					Scanner in = new Scanner(System.in);
					System.out.println("Enter a Loan ID: ");
					int id = in.nextInt();
					Loan toRem = loanDb.getLoan(id);
					// Loan found
					if (toRem != null) {
						loanDb.removeLoan(toRem.getId());
						Comic cdb = comicDb.getComic(toRem.getComic().getName());
						if (cdb.getCantCopies() <= cdb.getToRender()+1) {
							cdb.setToRender(cdb.getToRender()+1);
							System.out.println("LOAN REJECTED");
						}
						loop = false;
					}
					else {
						System.out.println("Loan does not exists. Try again? y/n");
						String choise = in.nextLine().toUpperCase();
						// No
						if (choise.compareTo("Y") != 0) {
							loop = false;
						}
					}
				}
				else {
					loop = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a Loan ID");
			}
		}
	}
	
	private void addComic() {
		boolean chance = true;
		while (chance) {
			try {
				System.out.println("CAMPS WITH '*' ARE MANDATORY GENRE MUST EXIST IN THE DATABASE");
				System.out.println(" ");
				Scanner in = new Scanner(System.in);
				System.out.println("*TITLE= ");
				String name = in.next().toUpperCase();
				System.out.println("*AUTHOR= ");
				String author = in.next().toUpperCase();
				System.out.println("YEAR= ");
				int year = in.nextInt();
				System.out.println("ISSUE NUMBER= ");
				int issueNum = in.nextInt();
				System.out.println("*GENRE= ");
				String genre = in.next().toUpperCase();
				Comic toAdd = new Comic(name, author, genre, year, issueNum);
				System.out.println(" ");
				System.out.println("Do you want to add more copies of this comic? y/n");
				String question = in.next();
				if (question.toUpperCase().compareTo("Y") == 0) {
					System.out.println(" ");
					System.out.println("Insert copies number= ");
					int copies = in.nextInt();
					toAdd.setCantCopies(copies);
				}
				comicDb.addComic(toAdd);
				// Genre not in database
				if (genreDb.getGenre(genre) == null) {
					System.out.println("Genre does not exists. Create? y/n");
					String choise = in.next().toUpperCase();
					if (choise.compareTo("Y") == 0) {
						addGenre();
						// Update genre database
						genreDb.getGenre(genre).addComic(toAdd);
						genreDb.getGenre(genre).setCantComics(genreDb.getGenre(genre).getCantComics()+1);
					}
				}
				else {
					// Update genre database
					genreDb.getGenre(genre).addComic(toAdd);
					genreDb.getGenre(genre).setCantComics(genreDb.getGenre(genre).getCantComics()+1);
				}
				chance = false;
			} catch (InputMismatchException e) {
				System.out.println("Some of the fields were wrong. Please try again.");
				System.out.println(" ");
			}
		}
	}
	
	private void removeComic() {
		Scanner inData = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				if (listComics()) {
					System.out.println("Enter a Comic name to delete: ");
					String toKill = inData.nextLine().toUpperCase();
					// Delete comic from Genre Database
					genreDb.getGenre(comicDb.getComic(toKill).getGenre()).setCantComics(genreDb.getGenre(comicDb.getComic(toKill).getGenre()).getCantComics()-1);
					genreDb.getGenre(comicDb.getComic(toKill).getGenre()).getComics().remove(comicDb.getComic(toKill));
					if (!comicDb.removeComic(toKill)) {
						System.out.println(" ");
						System.out.println("Do you want to try again? y/n");
						String choise = inData.nextLine().toUpperCase();
						if (choise.compareTo("Y") != 0) {
							loop = false;
						}
					}
					else {
						loop = false;
					}
				}
				else {
					loop = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a name for the Comic");
				System.out.println(" ");
			}
		}
	}
	
	private void addGenre() {
		Scanner in = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				System.out.println("Enter Genre to Add: ");
				String genre = in.next().toUpperCase();
				Genre toAdd = new Genre(genre);
				if (!genreDb.addGenre(toAdd)) {
					System.out.println(" ");
					System.out.println("Genre could not be added. Do you want to try again? y/n");
					String choise = in.next().toUpperCase();
					if (choise.compareTo("Y") != 0) {
						loop = false;
					}
				}
				else {
					loop = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a name for the Genre");
				System.out.println(" ");
			}
		}
	}
	
	private void removeGenre() {
		Scanner inData = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				if (listGenres()) {
					System.out.println("Enter a Genre name to delete: ");
					String toKill = inData.nextLine().toUpperCase();
					if (!genreDb.genreHasComics()) {
						if (!genreDb.removeGenre(toKill)) {
							System.out.println(" ");
							System.out.println("Do you want to try again? y/n");
							String choise = inData.nextLine().toUpperCase();
							if (choise.compareTo("Y") != 0) {
								loop = false;
							}
						}
						else {
							loop = false;
						}
					}
					else {
						System.out.println("Genre has Comics. First delete Comics.");
						loop = false;	
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a name for the Genre");
				System.out.println(" ");
			}
		}
	}
	
	private boolean listUsers() {
		return userDb.print();
	}
	
	private void addUser() {
		Scanner in = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				System.out.println("Enter User name to Add: ");
				String name = in.nextLine().toUpperCase();
				System.out.println("Enter a password: ");
				String pass = in.nextLine();
				AuthenticatedUser toAdd = new AuthenticatedUser(name, pass);
				if (!userDb.addUser(toAdd)) {
					System.out.println(" ");
					System.out.println("User could not be added. Do you want to try again? y/n");
					String choise = in.next().toUpperCase();
					if (choise.compareTo("Y") != 0) {
						loop = false;
					}
				}
				else {
					loop = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Plese try again");
				System.out.println(" ");
			}
		}
	}
	
	private void removeUser() {
		Scanner inData = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			try {
				if (listUsers()) {
					System.out.println("Enter a User name to delete: ");
					String toKill = inData.nextLine().toUpperCase();
					if (!loanDb.userHasLoan(toKill)) {
						if (!userDb.removeUser(toKill)) {
							System.out.println(" ");
							System.out.println("Do you want to try again? y/n");
							String choise = inData.nextLine().toUpperCase();
							if (choise.compareTo("Y") != 0) {
								loop = false;
							}
						}
						else {
							loop = false;
						}
					}
					else {
						System.out.println("User has Loans. First delete Loans.");
						loop = false;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a name for the Genre");
				System.out.println(" ");
			}
		}
	}
	
}
