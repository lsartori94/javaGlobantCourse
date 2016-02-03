package com.javaCourse.LucaSartori.controller;

import com.javaCourse.LucaSartori.models.Admin;
import com.javaCourse.LucaSartori.models.AuthenticatedUser;
import com.javaCourse.LucaSartori.models.Comic;
import com.javaCourse.LucaSartori.models.User;
import com.javaCourse.LucaSartori.util.ComicDb;
import com.javaCourse.LucaSartori.util.UserDb;

public class Controller {

	private final String userAdmin = "Sheldon";
	private final String passAdmin = "Bazinga";
	private UserDb userDb = UserDb.getInstance();
	private ComicDb comicDb = ComicDb.getInstance();
	
	
	public Controller() {
		Admin adm = new Admin(userAdmin, passAdmin);
		userDb.addUser(adm);
		User usr = new User();
		AuthenticatedUser auth = new AuthenticatedUser("Luca", "asdf1234");
		userDb.addUser(auth);
		createSomeComics();
	}


	private void createSomeComics() {
		Comic com = new Comic("CAPITAN AMERICA", "MARVEL", "SUPERHERO");
		comicDb.addComic(com);
		Comic com2 = new Comic("IRON MAN", "MARVEL", "SUPERHERO", 1994, 002);
		comicDb.addComic(com2);
		
	}
	
	
}
