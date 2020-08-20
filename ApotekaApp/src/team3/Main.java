package team3;

import team3.view.MainFrame;

public class Main {

	public static void main(String[] args) {
		MainFrame mf = MainFrame.getInstance();
		mf.setLocationRelativeTo(null);
		mf.setVisible(true);
	}

}
