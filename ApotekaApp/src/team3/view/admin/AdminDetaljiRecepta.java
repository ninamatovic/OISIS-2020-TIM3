package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import team3.controller.PrescriptionController;
import team3.model.Prescription;
import team3.view.MainFrame;
import team3.view.doctor.MedicineInPrescriptionTableModel;

public class AdminDetaljiRecepta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8423901399968833528L;
	private JTable table;

	public AdminDetaljiRecepta(Prescription p) {

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
		AdminUtils.addSidebar(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 210, 560, 322);
		panel.add(scrollPane);

		table = new JTable(new MedicineInPrescriptionTableModel(false, p));
		table.setBackground(new Color(176, 224, 230));

		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		// table.setEnabled(false);
		scrollPane.setViewportView(table);

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));

		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Recept");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 538, 111);
		panel.add(lblNewLabel_1);

		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().back();
			}
		});
		btnNazad.setBounds(745, 543, 101, 43);
		btnNazad.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		panel.add(btnNazad);

		JLabel lblPacijent = new JLabel("Pacijent: " + p.getPatientId());
		lblPacijent.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPacijent.setBounds(286, 88, 538, 35);
		panel.add(lblPacijent);

		JLabel lblUkupnaCena = new JLabel("Ukupna cena: " + PrescriptionController.totalPrice(p));
		lblUkupnaCena.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblUkupnaCena.setBounds(286, 147, 538, 35);
		panel.add(lblUkupnaCena);

	}
}
