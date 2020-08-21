package team3.view.doctor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class LekarSpisakLekova extends JPanel {

	private JTable table;
	private JTextField textField;

	public LekarSpisakLekova() {

		setBackground(new Color(102, 153, 153));

		JButton btnPo = new JButton("Po\u010Detna");
		btnPo.setBounds(30, 110, 150, 40);
		btnPo.setBackground(new Color(51, 102, 102));
		btnPo.setForeground(new Color(255, 255, 255));
		btnPo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPo.setFocusPainted(false);

		JButton btnPo_1 = new JButton("Lekovi");
		btnPo_1.setBounds(30, 170, 150, 40);
		btnPo_1.setForeground(Color.WHITE);
		btnPo_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPo_1.setFocusPainted(false);
		btnPo_1.setBackground(new Color(51, 102, 102));

		JButton btnPo_1_1 = new JButton("Recepti");
		btnPo_1_1.setBounds(30, 230, 150, 40);
		btnPo_1_1.setForeground(Color.WHITE);
		btnPo_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPo_1_1.setFocusPainted(false);
		btnPo_1_1.setBackground(new Color(51, 102, 102));

		JButton btnPo_1_1_1_1 = new JButton("Dodaj lek");
		btnPo_1_1_1_1.setBounds(30, 290, 150, 40);
		btnPo_1_1_1_1.setForeground(Color.WHITE);
		btnPo_1_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPo_1_1_1_1.setFocusPainted(false);
		btnPo_1_1_1_1.setBackground(new Color(51, 102, 102));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon(("/resources/img/LogoM.png")));
		setLayout(null);
		add(btnPo);
		add(btnPo_1);
		add(btnPo_1_1);
		add(btnPo_1_1_1_1);
		add(lblNewLabel);

		JTextArea txtrPretraga = new JTextArea();
		txtrPretraga.setText("Pretraga");
		txtrPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		txtrPretraga.setBackground(new Color(102, 153, 153));
		txtrPretraga.setBounds(217, 78, 88, 27);
		add(txtrPretraga);

		textField = new JTextField();
		textField.setBounds(292, 85, 303, 19);
		add(textField);
		textField.setColumns(10);

		JButton btnIzlogujSe = new JButton("Izloguj se");
		btnIzlogujSe.setForeground(new Color(255, 255, 255));
		btnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnIzlogujSe.setFocusPainted(false);
		btnIzlogujSe.setBackground(new Color(204, 204, 255));
		btnIzlogujSe.setBounds(603, 29, 150, 40);
		add(btnIzlogujSe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(217, 110, 536, 309);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		table.setModel(new MedicineTableModel());

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));

		JLabel lblNewLabel_1 = new JLabel("Spisak Lekova");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(217, 20, 309, 46);
		add(lblNewLabel_1);

		setBackground(Color.WHITE);

		setBounds(100, 100, 800, 500);
	}

}
