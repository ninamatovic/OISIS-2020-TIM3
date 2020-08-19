package team3.controller;

import team3.Database;
import team3.model.User;

public class UserController {

	public static boolean register(User u) {
		if (isUsernameTaken(u.getUsername()))
			return false;
		Database d = Database.getInstance();
		d.getUsers().add(u);
		return true;
	}

	public static boolean login(String username, String pass) {
		Database d = Database.getInstance();
		for (User u : d.getUsers()) {
			if (u.isRemoved())
				continue;
			if (u.getUsername().equals(username) && u.getPassword().equals(pass))
				return true;
		}
		return false;
	}

	private static boolean isUsernameTaken(String username) {
		Database d = Database.getInstance();
		for (User u : d.getUsers()) {
			if (u.getUsername().equals(username))
				return true;
		}
		return false;
	}

}
