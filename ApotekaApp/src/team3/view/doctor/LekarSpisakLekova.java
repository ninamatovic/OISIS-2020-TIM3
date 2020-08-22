package team3.view.doctor;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;

import team3.Main;
import team3.controller.MedicineController;
import team3.view.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LekarSpisakLekova extends JPanel {

	private JTable table;

	public LekarSpisakLekova() {

		setBackground(new Color(102, 153, 153));

		JLabel lblNewLabel = new JLabel(new ImageIcon(("/resources/img/LogoM.png")));
		lblNewLabel.setBounds(29, 11, 150, 112);
	//	lblNewLabel.setIcon();
		setLayout(null);

		add(lblNewLabel);
		DoctorUtils.addSidebar(this);

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
		table.setAutoCreateRowSorter(true);

		JLabel lblNewLabel_1 = new JLabel("Spisak Lekova");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(217, 11, 309, 46);
		add(lblNewLabel_1);

		// setBackground(Color.WHITE);

		setBounds(100, 100, 800, 500);

		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().searchMedicine(table);
			}
		});
		btnPretraga.setForeground(Color.WHITE);
		btnPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPretraga.setFocusPainted(false);
		btnPretraga.setBackground(new Color(51, 102, 102));
		btnPretraga.setBounds(217, 59, 133, 43);
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
				MedicineTableModel t = (MedicineTableModel) entry.getModel();
				// adminu se sve prikaze, ostalima samo ako nije izbriano
				String id = (String) t.getValueAt((int) entry.getIdentifier(), 0);
				return !MedicineController.getById(id).isRemoved();

			}
		};
	}
}
