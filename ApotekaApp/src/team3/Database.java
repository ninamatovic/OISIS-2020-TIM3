package team3;


import java.util.LinkedList;
import java.util.List;

import team3.model.User;

public class Database {
	private List<User> users = new LinkedList<>();
	private static Database instance;

	private Database() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");
		users.add(u);
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public List<User> getUsers() {
		return users;
	}

}
