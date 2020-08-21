package team3.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import team3.Database;
import team3.model.Medicine;
import team3.model.Prescription;
import team3.model.User;
import team3.view.admin.AdmDodavanjeLeka;
import team3.view.admin.AdmRegistracija;
import team3.view.admin.AdmSpisakKorisnika;
import team3.view.admin.AdmSpisakLekova;
import team3.view.admin.AdmSpisakRecepata;
import team3.view.admin.AdminDetaljiRecepta;
import team3.view.doctor.LekarDetaljiRecepta;
import team3.view.doctor.LekarDodavanjeLekaURecept;
import team3.view.doctor.LekarKreiranjeRecepta;
import team3.view.doctor.LekarSpisakLekova;
import team3.view.doctor.LekarSpisakRecepata;
import team3.view.pharmacist.ApProdajaLek;
import team3.view.pharmacist.ApotekarSpisakLekova;

public class MainFrame extends JFrame {
	private static MainFrame instance;
	private JPanel lastFrame;

	private MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		handleLogout();
		// setResizable(false);
	}

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}

	public void handleLogin(String role) {
		if (role.equals("Admin")) {
			showUsers();
		} else if (role.equals("Lekar")) {
			showRecipes();
		} else {
			showCart(null);
		}
	}

	public void showCart(Medicine me) {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new ApProdajaLek(me);
		// JPanel panel = (JPanel) new LekarKreiranjeRecepta();
		lastFrame = panel;
		adjustSize(panel);
		add((panel));

	}

	public void handleLogout() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new LogIn();
		// JPanel panel = (JPanel) new LekarKreiranjeRecepta();
		lastFrame = panel;
		adjustSize(panel);
		add((panel));
	}

	private void adjustSize(JPanel p) {
		setSize(p.getWidth() + 1, p.getHeight() + 1);

		setSize(p.getWidth(), p.getHeight());
		revalidate();
		repaint();
	}

	public void showRegistrationPage() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new AdmRegistracija();
		adjustSize(panel);
		add(panel);
	}

	public void showUsers() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new AdmSpisakKorisnika();
		lastFrame = panel;
		adjustSize(panel);
		add(panel);
	}

	public void showMedicine() {
		User u = Database.getInstance().getLoggedIn();
		getContentPane().removeAll();
		JPanel panel = null;
		if (u.getRole().equals("Admin")) {

			panel = (JPanel) new AdmSpisakLekova();

		} else if (u.getRole().equals("Lekar")) {
			panel = (JPanel) new LekarSpisakLekova();

		} else
			panel = new ApotekarSpisakLekova();
		lastFrame = panel;
		adjustSize(panel);
		add(panel);
	}

	public void showNewMedicinePage() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new AdmDodavanjeLeka();
		adjustSize(panel);
		add(panel);
	}

	public void back() {
		getContentPane().removeAll();

		add(lastFrame);

		adjustSize(lastFrame);

	}

	public void showAddMedicineToPrescription() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new LekarDodavanjeLekaURecept();
		adjustSize(panel);
		add(panel);

	}

	public void showRecipes() {
		User u = Database.getInstance().getLoggedIn();
		getContentPane().removeAll();
		JPanel panel = null;
		if (u.getRole().equals("Admin")) {

			panel = (JPanel) new AdmSpisakRecepata();

		} else if (u.getRole().equals("Lekar")) {
			panel = (JPanel) new LekarSpisakRecepata();

		}

		adjustSize(panel);
		add(panel);
	}

	public void showNewRecipe() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new LekarKreiranjeRecepta();
		adjustSize(panel);
		lastFrame = panel;
		add(panel);

	}

	public void showPrescriptionDetails(Prescription prescription) {
		lastFrame = (JPanel) getContentPane().getComponent(0);
		JPanel panel = (JPanel) new LekarDetaljiRecepta(prescription);
		User u = Database.getInstance().getLoggedIn();
		getContentPane().removeAll();
		if (u.getRole().equals("Admin")) {

			panel = (JPanel) new AdminDetaljiRecepta(prescription);

		}

		getContentPane().removeAll();

		adjustSize(panel);
		add(panel);
	}
}
