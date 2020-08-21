package team3.view.doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import team3.controller.UserController;
import team3.view.MainFrame;

public class DoctorUtils {
	public static void addSidebar(JPanel panel) {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(("/resources/img/LogoM.png")));
		lblNewLabel.setBounds(40, 0, 149, 148);
		panel.add(lblNewLabel);

		JButton button = new JButton("Pocetna");
		button.setForeground(UIManager.getColor("JButton.highlight"));
		button.setBackground(new Color(0, 128, 128));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button.setBounds(30, 154, 171, 45);
		panel.add(button);

		JButton button_1 = new JButton("Lekovi");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(30, 237, 171, 45);
		panel.add(button_1);

		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showMedicine();
			}
		});

		JButton button_2 = new JButton("Recepti");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 128, 128));
		button_2.setBounds(30, 319, 171, 45);
		panel.add(button_2);

		JButton button_5 = new JButton("Izloguj se");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_5.setBackground(new Color(0, 128, 128));
		button_5.setBounds(675, 29, 171, 45);
		panel.add(button_5);
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserController.logout();
			}
		});

	}
}
