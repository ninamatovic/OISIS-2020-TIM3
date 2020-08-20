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
import javax.swing.JOptionPane;
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

import team3.Database;
import team3.Main;
import team3.controller.PrescriptionController;
import team3.model.Prescription;
import team3.view.MainFrame;
import team3.view.admin.UserTableModel;

public class LekarDetaljiRecepta extends JPanel {
	private JTextField textField_2;
	private JTable table;

	public LekarDetaljiRecepta(Prescription p) {
		setForeground(new Color(0, 0, 51));

		setBackground(new Color(102, 153, 153));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));
		setLayout(null);

		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Detalji recepta: " + p.getId());
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(187, 23, 360, 46);
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(190, 116, 558, 304);
		add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Nazad");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().back();
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 538, 201);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(176, 224, 230));
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		table.setModel(new MedicineInPrescriptionTableModel(true, p));
		scrollPane.setViewportView(table);
		/*
		 * table = new JTable(); table.setModel(new
		 * MedicineInPrescriptionTableModel(true,
		 * Database.getInstance().getPrescription())); table.setBounds(10, 45, 538,
		 * 206); panel.add(new JScrollPane(table)); // setBackground(Color.WHITE);
		 */

		setBounds(100, 100, 800, 500);

		DoctorUtils.addSidebar(this);

		JButton button = new JButton("Izbriši");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int r = table.getSelectedRow();
				if (r == -1) {
					JOptionPane.showMessageDialog(null, "Nijedan lek nije selektovan");
					return;
				}
				PrescriptionController.remove(r);
				((MedicineInPrescriptionTableModel) table.getModel()).fireTableRowsDeleted(r, r);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button.setFocusPainted(false);
		button.setBackground(new Color(51, 102, 102));
		button.setBounds(350, 71, 150, 40);
		add(button);

	}
}
