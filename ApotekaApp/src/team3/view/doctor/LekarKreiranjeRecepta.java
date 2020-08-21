package team3.view.doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LekarKreiranjeRecepta extends JPanel {
	private JTextField textField_2;
	private JTable table;

	public LekarKreiranjeRecepta() {
		setForeground(new Color(0, 0, 51));

		setBackground(new Color(102, 153, 153));

		JButton btnPocetna = new JButton("Po\u010Detna");
		btnPocetna.setBounds(30, 110, 150, 40);
		btnPocetna.setBackground(new Color(51, 102, 102));
		btnPocetna.setForeground(new Color(255, 255, 255));
		btnPocetna.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPocetna.setFocusPainted(false);

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

		JButton BtnDodajRecept = new JButton("Kreiraj recept");
		BtnDodajRecept.setBounds(30, 290, 150, 40);
		BtnDodajRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnDodajRecept.setForeground(Color.WHITE);
		BtnDodajRecept.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		BtnDodajRecept.setFocusPainted(false);
		BtnDodajRecept.setBackground(new Color(51, 102, 102));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));
		setLayout(null);
		add(btnPocetna);
		add(btnLekovi);
		add(btnRecepti);
		add(BtnDodajRecept);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Kreiranje novog recepta");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(187, 23, 360, 46);
		add(lblNewLabel_1);

		JButton BtnIzlogujSe = new JButton("Izloguj se");
		BtnIzlogujSe.setBackground(new Color(51, 102, 102));
		BtnIzlogujSe.setForeground(new Color(255, 255, 255));
		BtnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		BtnIzlogujSe.setBounds(603, 29, 150, 40);
		BtnIzlogujSe.setFocusPainted(false);
		add(BtnIzlogujSe);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(190, 116, 558, 304);
		add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(309, 262, 104, 27);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(153, 255, 102));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(0, 0, 51));

		JButton btnNewButton_1 = new JButton("Izbri\u0161i");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(423, 262, 104, 27);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 153, 153));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setForeground(new Color(0, 0, 51));

		textField_2 = new JTextField();
		textField_2.setBounds(161, 11, 141, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("JMBG pacijenta");
		lblNewLabel_2.setBounds(10, 11, 141, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));

		table = new JTable();
		table.setBounds(10, 45, 538, 206);
		panel.add(table);

		// setBackground(Color.WHITE);

		setBounds(100, 100, 800, 500);

		JButton btnDodajLek = new JButton("Dodaj lek");
		btnDodajLek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDodajLek.setForeground(Color.WHITE);
		btnDodajLek.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnDodajLek.setFocusPainted(false);
		btnDodajLek.setBackground(new Color(51, 102, 102));
		btnDodajLek.setBounds(187, 71, 150, 40);
		add(btnDodajLek);

		JButton btnDodajRecept = new JButton("Dodaj recept");
		btnDodajRecept.setForeground(Color.WHITE);
		btnDodajRecept.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnDodajRecept.setFocusPainted(false);
		btnDodajRecept.setBackground(new Color(51, 102, 102));
		btnDodajRecept.setBounds(347, 71, 150, 40);
		add(btnDodajRecept);
	}
}
