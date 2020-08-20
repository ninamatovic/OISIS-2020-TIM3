package team3.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import team3.Database;
import team3.model.User;
import team3.view.admin.AdmDodavanjeLeka;
import team3.view.admin.AdmRegistracija;
import team3.view.admin.AdmSpisakKorisnika;
import team3.view.admin.AdmSpisakLekova;

public class MainFrame extends JFrame {
	private static MainFrame instance;

	private MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		handleLogout();
	}

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}

	public void handleLogin(String role) {
		if (role.equals("Admin")) {
			showUsers();
		}
	}

	public void handleLogout() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new LogIn();
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
		adjustSize(panel);
		add(panel);

	}

	public void showMedicine() {
		User u = Database.getInstance().getLoggedIn();
		if (u.getRole().equals("Admin")) {
			getContentPane().removeAll();
			JPanel panel = (JPanel) new AdmSpisakLekova();
			adjustSize(panel);
			add(panel);
		}
	}

	public void showNewMedicinePage() {
		getContentPane().removeAll();
		JPanel panel = (JPanel) new AdmDodavanjeLeka();
		adjustSize(panel);
		add(panel);

	}
}
