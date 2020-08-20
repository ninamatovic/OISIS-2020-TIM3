package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team3.controller.UserController;
import team3.view.MainFrame;

public class AdmSpisakKorisnika extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7548570708207322324L;
	private JTable table;
	private JTextField textField;

	public AdmSpisakKorisnika() {
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
		button.setForeground(UIManager.getColor("Button.highlight"));
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 210, 560, 322);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(176, 224, 230));
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		table.setModel(new UserTableModel());
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Korisnici");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 240, 111);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pretraga:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(286, 154, 84, 45);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(374, 161, 329, 28);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Lista korisnika ");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(248, 96, 171, 28);
		panel.add(lblNewLabel_3);

		/*
		 * JLabel lblNewLabel_3_1 = new JLabel("Registracija ");
		 * lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		 * lblNewLabel_3_1.setBounds(423, 96, 171, 28); panel.add(lblNewLabel_3_1);
		 */

		JButton a = new JButton("Registracija");
		a.setForeground(Color.WHITE);
		a.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		a.setBackground(new Color(0, 128, 128));
		a.setBounds(423, 96, 171, 28);
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showRegistrationPage();
			}
		});
		panel.add(a);
	}
}
