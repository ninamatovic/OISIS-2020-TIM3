package team3;

import java.util.LinkedList;
import java.util.List;

import team3.model.Medicine;
import team3.model.Prescription;
import team3.model.SellInfo;
import team3.model.User;

public class Database {
	private List<User> users = new LinkedList<>();
	private List<Medicine> medicine = new LinkedList<>();
	private List<Prescription> prescriptions = new LinkedList<Prescription>();
	private List<SellInfo> sells = new LinkedList<>();
	private Prescription prescription = new Prescription();// recept koji se trenutno pravi

	private SellInfo cart = new SellInfo();

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	private static Database instance;
	private User loggedIn;

	private Database() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");
		u.setRole("Admin");
		users.add(u);
		Medicine med = new Medicine();
		med.setId("a");
		med.setMadeBy("asd");
		med.setName("name");
		med.setPrice(45);
		med.setRemoved(false);
		medicine.add(med);
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public User getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(User loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<SellInfo> getSells() {
		return sells;
	}

	public SellInfo getCart() {
		return cart;
	}

	public void setCart(SellInfo cart) {
		this.cart = cart;
	}

}
