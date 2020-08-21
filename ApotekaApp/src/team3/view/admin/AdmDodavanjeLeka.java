package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import team3.controller.MedicineController;
import team3.model.Medicine;
import team3.view.MainFrame;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class AdmDodavanjeLeka extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public AdmDodavanjeLeka() {
		setBounds(100, 100, 904, 626);
		setBackground(new Color(95, 158, 160));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		panel.setBackground(new Color(95, 158, 160));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		AdminUtils.addSidebar(panel);

		JLabel lblNewLabel_2 = new JLabel("Naziv:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2.setBounds(380, 183, 88, 37);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(484, 175, 233, 45);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Sifra:");
		lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1.setBounds(392, 249, 88, 37);
		panel.add(lblNewLabel_2_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(484, 241, 233, 45);
		panel.add(textField_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Proizvodjac:");
		lblNewLabel_2_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_1.setBounds(316, 313, 164, 37);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Cena:");
		lblNewLabel_2_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_2.setBounds(398, 381, 82, 37);
		panel.add(lblNewLabel_2_1_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(484, 373, 233, 45);
		panel.add(textField_2);

		JButton button_6 = new JButton("Otkazi");
		button_6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button_6.setBackground(new Color(255, 182, 193));
		button_6.setBounds(628, 513, 125, 37);
		panel.add(button_6);
		button_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showMedicine();
			}
		});

		JButton button_6_1 = new JButton("Potvrdi");
		button_6_1.setForeground(Color.WHITE);
		button_6_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button_6_1.setBackground(new Color(102, 205, 170));
		button_6_1.setBounds(444, 513, 125, 37);
		panel.add(button_6_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(484, 305, 233, 45);
		panel.add(textField_3);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Recept");
		chckbxNewCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		chckbxNewCheckBox.setBounds(548, 445, 97, 37);
		panel.add(chckbxNewCheckBox);

		button_6_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Medicine med = new Medicine();
				med.setId(textField_1.getText().trim());
				med.setName(textField.getText().trim());
				med.setMadeBy(textField_3.getText().trim());
				med.setPrescription(chckbxNewCheckBox.isSelected());
				try {
					Float f = Float.parseFloat(textField_2.getText());
					med.setPrice(f);
				} catch (Exception exc) {
					med.setPrice(0f);
				}
				String error = MedicineController.add(med);
				if (!error.equals("")) {
					JOptionPane.showMessageDialog(null, error);
					return;
				}
				MainFrame.getInstance().showMedicine();
			}
		});

	}
}
