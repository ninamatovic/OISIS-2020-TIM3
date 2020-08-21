package team3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import team3.model.Medicine;
import team3.model.Prescription;
import team3.model.SellInfo;
import team3.model.User;

public class Database {
	private List<User> users;
	private List<Medicine> medicine;
	private List<Prescription> prescriptions;
	private List<SellInfo> sells;
	private Prescription prescription = new Prescription();// recept koji se trenutno pravi

	private SellInfo cart = new SellInfo();

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	private static Database instance;
	private User loggedIn;

	private Database() {
		users = (List<User>) load("./users.data");
		if (users == null) {
			users = new LinkedList<>();
			User u = new User();
			u.setUsername("admin");
			u.setFirstName("admin");
			u.setLastName("admin");
			u.setPassword("admin");
			u.setRole("Admin");
			users.add(u);
		}
		medicine = (List<Medicine>) load("./medicine.data");
		if (medicine == null)
			medicine = new LinkedList<>();

		prescriptions = (List<Prescription>) load("./prescriptions.data");
		if (prescriptions == null)
			prescriptions = new LinkedList<>();

		sells = (List<SellInfo>) load("./sells.data");
		if (sells == null)
			sells = new LinkedList<>();
		/*
		 * Medicine med = new Medicine(); med.setId("a"); med.setMadeBy("asd");
		 * med.setName("name"); med.setPrice(45); med.setRemoved(false);
		 * medicine.add(med);
		 */

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

	public static void save(Object what, String where) {
		File f = new File(where);
		ObjectOutputStream objOutStream = null;
		try {
			objOutStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			objOutStream.writeObject(what);
		} catch (IOException e1) {
		} finally {

			try {
				if (objOutStream != null)
					objOutStream.close();
			} catch (Exception e) {
			}
		}
	}

	private static Object load(String where) {
		File f = new File(where);
		ObjectInputStream objInStream = null;
		Object ret = null;
		try {
			objInStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			ret = objInStream.readObject();
		} catch (Exception e) {
			System.out.println();
		} finally {
			try {
				if (objInStream != null)
					objInStream.close();
			} catch (Exception e) {
			}
		}
		return ret;
	}

	public void restart() {
		instance = new Database();
	}
}
