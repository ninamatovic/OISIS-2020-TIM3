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

public class LekarKreiranjeRecepta extends JPanel {
	private JTextField textField_2;
	private JTable table;

	public LekarKreiranjeRecepta() {
		setForeground(new Color(0, 0, 51));

		setBackground(new Color(102, 153, 153));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));
		setLayout(null);

		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Kreiranje novog recepta");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(187, 23, 360, 46);
		add(lblNewLabel_1);

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

		JButton btnNewButton_1 = new JButton("Poni\u0161ti");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.getInstance().setPrescription(new Prescription());
				table.setModel(new MedicineInPrescriptionTableModel(true, Database.getInstance().getPrescription()));
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
		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));

		table.setModel(new MedicineInPrescriptionTableModel(true, Database.getInstance().getPrescription()));
		scrollPane.setViewportView(table);
		/*
		 * table = new JTable(); table.setModel(new
		 * MedicineInPrescriptionTableModel(true,
		 * Database.getInstance().getPrescription())); table.setBounds(10, 45, 538,
		 * 206); panel.add(new JScrollPane(table)); // setBackground(Color.WHITE);
		 */

		setBounds(100, 100, 800, 500);

		JButton btnDodajLek = new JButton("Dodaj lek");
		btnDodajLek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showAddMedicineToPrescription();
			}
		});
		btnDodajLek.setForeground(Color.WHITE);
		btnDodajLek.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnDodajLek.setFocusPainted(false);
		btnDodajLek.setBackground(new Color(51, 102, 102));
		btnDodajLek.setBounds(187, 71, 150, 40);
		add(btnDodajLek);

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

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patient = textField_2.getText().trim();
				String error = "";
				if (patient.equals(""))
					error += "JMBG pacijenta nije unet\r\n";
				else if (patient.length() != 13)
					error += "JMBG mora imati 13 cifara\r\n";
				else if (!patient.matches("[0-9]+"))
					error += "JMBG mora sadržati samo cifre\r\n";
				else if (Database.getInstance().getPrescription().getMeds().size() == 0)
					error += "Nije dodat nijedan lek\r\n";
				if (!error.equals("")) {
					JOptionPane.showMessageDialog(null, error);
					return;
				}
				Database.getInstance().getPrescription().setPatientId(patient);
				PrescriptionController.create();
				MainFrame.getInstance().showRecipes();
				table.setModel(new MedicineInPrescriptionTableModel(true, Database.getInstance().getPrescription()));
			}
		});

	}
}
