
package team3.view.doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultRowSorter;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.RowFilter.Entry;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import team3.Database;
import team3.controller.MedicineController;
import team3.controller.PrescriptionController;
import team3.view.MainFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

public class LekarSpisakRecepata extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	public LekarSpisakRecepata() {
		setForeground(new Color(0, 0, 51));

		setBackground(new Color(102, 153, 153));
		DoctorUtils.addSidebar(this);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon(("/resources/img/LogoM.png")));
		setLayout(null);

		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(217, 110, 536, 309);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		scrollPane.setViewportView(table);

		table.setModel(new PrescriptionTableModel());

		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		table.setAutoCreateRowSorter(true);


		JButton lblNewLabel_1 = new JButton("Detalji");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(51, 102, 102));
		lblNewLabel_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected = table.getSelectedRow();
				if (selected == -1) {
					JOptionPane.showMessageDialog(null, "Nijedan recept nije selektovan");
					return;
				}
				// JOptionPane.showMessageDialog(null, "TBD");
				MainFrame.getInstance()
						.showPrescriptionDetails(Database.getInstance().getPrescriptions().get(selected));

			}
		});

	//	lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(217, 64, 133, 43);
		add(lblNewLabel_1);

		/*
		 * textField = new JTextField(); textField.setBounds(292, 85, 303, 19);
		 * add(textField); textField.setColumns(10);
		 */

		JLabel lblNewLabel_2 = new JLabel("Spisak recepata");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setBounds(217, 11, 309, 46);
		add(lblNewLabel_2);

		// setBackground(Color.WHITE);
		/*
		 * JButton BtnDodajRecept = new JButton("Dodaj recept");
		 * BtnDodajRecept.setBounds(30, 290, 150, 40);
		 * BtnDodajRecept.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * } }); add(BtnDodajRecept);
		 */

		setBounds(100, 100, 800, 500);
		
		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().searchPrescriptions(table);
			}
		});
		btnPretraga.setForeground(Color.WHITE);
		btnPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnPretraga.setBackground(new Color(51, 102, 102));
		btnPretraga.setBounds(360, 64, 133, 43);
		add(btnPretraga);

		DefaultRowSorter sorter = ((DefaultRowSorter) table.getRowSorter());
		ArrayList list = new ArrayList();
		sorter.setSortKeys(list);
		sorter.sort();

		List<RowFilter<Object, Object>> f = new LinkedList<>();
		f.add(isDeletedFilter());// sakriva izbirsane
		sorter.setRowFilter(RowFilter.andFilter(f));
	}

	public static RowFilter isDeletedFilter() {
		return new RowFilter<Object, Object>() {
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				PrescriptionTableModel t = (PrescriptionTableModel) entry.getModel();
				// adminu se sve prikaze, ostalima samo ako nije izbriano
				int id = (int) t.getValueAt((int) entry.getIdentifier(), 0);
				return !PrescriptionController.getById((id)).isRemoved();

			}
		};
	}

}
