package team3.view.pharmacist;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import team3.controller.UserController;
import team3.view.MainFrame;

public class PharmacistUtils {
	public static void addSidebar(JPanel panel) {

		JButton btnLekovi = new JButton("Lekovi");
		btnLekovi.setBounds(30, 170, 150, 40);
		btnLekovi.setForeground(Color.WHITE);
		btnLekovi.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnLekovi.setFocusPainted(false);
		btnLekovi.setBackground(new Color(51, 102, 102));

		JButton btnRecepti = new JButton("Recepti");
		btnRecepti.setBounds(30, 230, 150, 40);
		btnRecepti.setForeground(Color.WHITE);
		btnRecepti.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnRecepti.setFocusPainted(false);
		btnRecepti.setBackground(new Color(51, 102, 102));

		btnLekovi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showMedicine();
			}
		});

		btnRecepti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showRecipes();

			}
		});

		panel.add(btnLekovi);
		//panel.add(btnRecepti);

		JButton BtnIzlogujSe = new JButton("Izloguj se");
		BtnIzlogujSe.setBackground(new Color(51, 102, 102));
		BtnIzlogujSe.setForeground(new Color(255, 255, 255));
		BtnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		BtnIzlogujSe.setBounds(603, 29, 150, 40);
		BtnIzlogujSe.setFocusPainted(false);

		BtnIzlogujSe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserController.logout();
			}
		});
		panel.add(BtnIzlogujSe);

		// ---

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));
		lblNewLabel.setBounds(40, 0, 149, 148);
		panel.add(lblNewLabel);

		Button button_4 = new Button("Korpa");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_4.setBackground(new Color(0, 128, 128));
		button_4.setBounds(30, 484, 171, 45);
		panel.add(button_4);
		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showCart(null);
			}
		});

		// -----

		/*
		 * JLabel lblNewLabel = new JLabel(""); lblNewLabel.setIcon(new
		 * ImageIcon(("/resources/img/LogoM.png"))); lblNewLabel.setBounds(40, 0, 149,
		 * 148); panel.add(lblNewLabel);
		 * 
		 */

	}
}
