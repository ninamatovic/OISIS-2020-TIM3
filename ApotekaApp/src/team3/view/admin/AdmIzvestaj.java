package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team3.controller.MedicineController;
import team3.controller.ReportsController;
import team3.controller.UserController;
import team3.view.MainFrame;

public class AdmIzvestaj extends JPanel {

	private JTable table;

	public AdmIzvestaj() {

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

		table = new JTable();
		table.setBackground(new Color(176, 224, 230));
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		table.setModel(new UserTableModel());
		// table.getColumnModel().getColumn(2).setPreferredWidth(25);
		scrollPane.setViewportView(table);

		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));

		JLabel lblNewLabel_1 = new JLabel("Izveštaj");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 240, 111);
		panel.add(lblNewLabel_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ukupna prodaja svih lekova");
		rdbtnNewRadioButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		rdbtnNewRadioButton.setBackground(new Color(102, 153, 153));
		rdbtnNewRadioButton.setBounds(286, 82, 327, 23);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnUkupnaProdajaSvih = new JRadioButton(
				"Ukupna prodaja svih lekova odabranog proizvo\u0111a\u010D");
		rdbtnUkupnaProdajaSvih.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		rdbtnUkupnaProdajaSvih.setBackground(new Color(102, 153, 153));
		rdbtnUkupnaProdajaSvih.setBounds(286, 122, 354, 23);
		panel.add(rdbtnUkupnaProdajaSvih);

		JRadioButton rdbtnUkupnaProdajaSvih_1 = new JRadioButton(
				"Ukupna prodaja svih lekova koje je odabrani apotekar prodao");
		rdbtnUkupnaProdajaSvih_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		rdbtnUkupnaProdajaSvih_1.setBackground(new Color(102, 153, 153));
		rdbtnUkupnaProdajaSvih_1.setBounds(286, 164, 421, 23);
		panel.add(rdbtnUkupnaProdajaSvih_1);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		bg.add(rdbtnUkupnaProdajaSvih_1);

		bg.add(rdbtnUkupnaProdajaSvih);

		List<String> manuf = MedicineController.geAllManuf();
		JComboBox comboBox = new JComboBox(manuf.toArray());
		if (manuf.size() == 0) {
			comboBox.setEnabled(false);
			rdbtnUkupnaProdajaSvih.setEnabled(false);
		}
		comboBox.setBounds(713, 125, 133, 20);
		panel.add(comboBox);

		List<String> pharma = UserController.getAllPharmacists();
		JComboBox comboBox_1 = new JComboBox(pharma.toArray());
		if (pharma.size() == 0) {
			comboBox_1.setEnabled(false);
			rdbtnUkupnaProdajaSvih_1.setEnabled(false);
		}

		comboBox_1.setBounds(713, 167, 133, 20);
		panel.add(comboBox_1);

		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new ReportTableModel(ReportsController.getReport(null, null)));

			}
		});

		rdbtnUkupnaProdajaSvih_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(
						new ReportTableModel(ReportsController.getReport(null, (String) comboBox_1.getSelectedItem())));
			}
		});
		rdbtnUkupnaProdajaSvih.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(
						new ReportTableModel(ReportsController.getReport((String) comboBox.getSelectedItem(), null)));
			}
		});

		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnUkupnaProdajaSvih_1.doClick();
			}
		});

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnUkupnaProdajaSvih.doClick();
			}
		});

		rdbtnNewRadioButton.doClick();
		// setBounds(100, 100, 800, 500);
	}

}