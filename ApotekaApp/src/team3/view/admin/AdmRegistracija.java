package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import team3.controller.UserController;
import team3.model.User;
import team3.view.MainFrame;

public class AdmRegistracija extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public AdmRegistracija() {
		setPreferredSize(new Dimension(904, 626));
		setSize(new Dimension(904, 626));

		setBackground(new Color(95, 158, 160));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		panel.setBackground(new Color(95, 158, 160));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));
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

		JButton button_2 = new JButton("Recepti");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 128, 128));
		button_2.setBounds(30, 319, 171, 45);
		panel.add(button_2);

		JButton button_3 = new JButton("Korisnici");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_3.setBackground(new Color(0, 128, 128));
		button_3.setBounds(30, 399, 171, 45);
		panel.add(button_3);

		JButton button_4 = new JButton("Korpa");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_4.setBackground(new Color(0, 128, 128));
		button_4.setBounds(30, 484, 171, 45);
		panel.add(button_4);

		JButton button_5 = new JButton("Izloguj se");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserController.logout();
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_5.setBackground(new Color(0, 128, 128));
		button_5.setBounds(675, 29, 171, 45);
		panel.add(button_5);

		JLabel lblNewLabel_1 = new JLabel("Korisnici");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 240, 111);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Lista korisnika ");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(248, 96, 171, 28);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Registracija ");
		lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(423, 96, 171, 28);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_2 = new JLabel("Ime:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2.setBounds(365, 162, 77, 37);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(446, 154, 233, 45);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Prezime:");
		lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1.setBounds(317, 228, 125, 37);
		panel.add(lblNewLabel_2_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(446, 220, 233, 45);
		panel.add(textField_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Zanimanje:");
		lblNewLabel_2_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_1.setBounds(293, 292, 149, 37);
		panel.add(lblNewLabel_2_1_1);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Admin");
		comboBox.addItem("Apotekar");
		comboBox.addItem("Lekar");

		comboBox.setBounds(446, 284, 233, 45);
		panel.add(comboBox);

		JLabel lblNewLabel_2_1_2 = new JLabel("Korisnicko ime:");
		lblNewLabel_2_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_2.setBounds(241, 360, 201, 37);
		panel.add(lblNewLabel_2_1_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(446, 352, 233, 45);
		panel.add(textField_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("Lozinka:");
		lblNewLabel_2_1_3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_3.setBounds(329, 430, 110, 37);
		panel.add(lblNewLabel_2_1_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(446, 422, 233, 45);
		panel.add(textField_3);

		JButton button_6 = new JButton("Otkazi");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showUsers();
			}
		});

		button_6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button_6.setBackground(new Color(255, 182, 193));
		button_6.setBounds(721, 501, 125, 37);
		panel.add(button_6);

		JButton button_6_1 = new JButton("Potvrdi");
		button_6_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setUsername(textField_2.getText().trim());
				u.setPassword(textField_3.getText().trim());
				u.setFirstName(textField.getText().trim());
				u.setLastName(textField_1.getText().trim());
				u.setRole(comboBox.getSelectedItem().toString());
				String message = UserController.validate(u);
				if (!message.equals("")) {
					JOptionPane.showMessageDialog(null, message);
					return;
				}
				UserController.register(u);
				MainFrame.getInstance().showUsers();

			}
		});
		button_6_1.setForeground(Color.WHITE);
		button_6_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button_6_1.setBackground(new Color(102, 205, 170));
		button_6_1.setBounds(574, 501, 125, 37);
		panel.add(button_6_1);
	}
}
