package team3.controller;

import java.util.List;
import java.util.stream.Collectors;

import team3.Database;
import team3.model.User;
import team3.view.MainFrame;

public class UserController {

	public static boolean register(User u) {
		if (isUsernameTaken(u.getUsername()))
			return false;
		Database d = Database.getInstance();
		d.getUsers().add(u);
		Database.save(d.getUsers(), "./users.data");

		return true;
	}

	public static boolean login(String username, String pass) {
		Database d = Database.getInstance();
		for (User u : d.getUsers()) {
			if (u.isRemoved())
				continue;
			if (u.getUsername().equals(username) && u.getPassword().equals(pass)) {
				Database.getInstance().setLoggedIn(u);
				MainFrame.getInstance().handleLogin(u.getRole());
				return true;
			}
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

	public static void logout() {
		Database.getInstance().setLoggedIn(null);
		MainFrame.getInstance().handleLogout();
	}

	public static String validate(User u) {
		String message = "";
		if (u.getUsername().equals(""))
			message += "Korisnièko ime nije uneto\r\n";
		if (u.getPassword().equals(""))
			message += "Lozinka nije uneta\r\n";
		if (u.getFirstName().equals(""))
			message += "Ime nije uneto\r\n";
		if (u.getLastName().equals(""))
			message += "Prezime nije uneto\r\n";
		if (UserController.isUsernameTaken(u.getUsername()))
			message += "Korisnièko ime vec posotji\r\n";
		return message;
	}

	public static List<String> getAllPharmacists() {
		return Database.getInstance().getUsers().stream().filter(user -> user.getRole().equals("Apotekar"))
				.map(user -> user.getUsername()).distinct().collect(Collectors.toList());
	}

}
