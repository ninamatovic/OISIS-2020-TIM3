package team3.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import team3.controller.UserController;

public class LogIn extends JPanel {

	private static final long serialVersionUID = 1L;

	public LogIn() {

		setBounds(100, 100, 800, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		panel.setBounds(0, 0, 786, 463);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Korisni\u010Dko ime");
		lblNewLabel_2.setBounds(242, 232, 131, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));

		JLabel lblNewLabel_3 = new JLabel("Lozinka");
		lblNewLabel_3.setBounds(294, 280, 79, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

		JLabel lblNewLabel_1 = new JLabel("Dobro do\u0161li");
		lblNewLabel_1.setBounds(294, 143, 171, 43);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 29));

		TextField textField = new TextField();
		textField.setBounds(388, 232, 131, 21);
		panel.add(textField);

		JPasswordField textField_1 = new JPasswordField();
		textField_1.setBounds(388, 280, 131, 21);
		panel.add(textField_1);

		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(320, 351, 112, 35);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (UserController.login(textField.getText().trim(), textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "Ulogovan");
				} else {
					JOptionPane.showMessageDialog(null, "Pogrešno korisnièko ime i/ili lozinka");

				}
			}
		});
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(300, 33, 143, 121);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));

		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
	}

}
