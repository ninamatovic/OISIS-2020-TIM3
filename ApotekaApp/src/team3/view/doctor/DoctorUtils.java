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

		JButton btnLekovi = new JButton("Lekovi");
		btnLekovi.setBounds(25, 170, 155, 40);
		btnLekovi.setForeground(Color.WHITE);
		btnLekovi.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnLekovi.setFocusPainted(false);
		btnLekovi.setBackground(new Color(51, 102, 102));

		JButton btnRecepti = new JButton("Recepti");
		btnRecepti.setBounds(25, 230, 155, 40);
		btnRecepti.setForeground(Color.WHITE);
		btnRecepti.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnRecepti.setFocusPainted(false);
		btnRecepti.setBackground(new Color(51, 102, 102));

		JButton BtnDodajRecept = new JButton("Kreiraj recept");
		BtnDodajRecept.setBounds(25, 290, 155, 40);
		BtnDodajRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/*
		 * JLabel lblNewLabel = new JLabel(""); lblNewLabel.setIcon(new
		 * ImageIcon(("/resources/img/LogoM.png"))); lblNewLabel.setBounds(40, 0, 149,
		 * 148); panel.add(lblNewLabel);
		 * 
		 */

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

		BtnDodajRecept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showNewRecipe();

			}
		});

		BtnDodajRecept.setForeground(Color.WHITE);
		BtnDodajRecept.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		BtnDodajRecept.setFocusPainted(false);
		BtnDodajRecept.setBackground(new Color(51, 102, 102));

		panel.add(btnLekovi);
		panel.add(btnRecepti);
		panel.add(BtnDodajRecept);

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

	}
}
