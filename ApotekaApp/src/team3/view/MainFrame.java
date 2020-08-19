package team3.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel s = (JPanel) new LogIn();
		add((s));
		setSize(s.getWidth(), s.getHeight());
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
