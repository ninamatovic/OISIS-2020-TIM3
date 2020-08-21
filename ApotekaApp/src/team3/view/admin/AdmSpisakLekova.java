package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import team3.view.MainFrame;

public class AdmSpisakLekova extends JPanel {

	private JTable table;

	public AdmSpisakLekova() {

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

		JButton lblNewLabel_3_1 = new JButton("Dodaj novi");
		lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(286, 115, 160, 50);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_3_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_3_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showNewMedicinePage();
			}
		});

		// ----------------------------------------

		setBackground(new Color(102, 153, 153));

		/*
		 * lblNewLabel_2 panel.add(lblNewLabel_2);
		 * 
		 * textField = new JTextField(); textField.setBounds(374, 161, 329, 28);
		 * 
		 */

		JLabel lblNewLabel_1 = new JLabel("Lekovi");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 240, 111);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(286, 210, 560, 322);
		panel.add(scrollPane);

		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		// table.setEnabled(false);
		scrollPane.setViewportView(table);

		table.setModel(new MedicineTableModel());

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		
		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		btnPretraga.setBounds(467, 115, 160, 50);
		panel.add(btnPretraga);
		btnPretraga.setForeground(Color.WHITE);
		btnPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnPretraga.setBackground(new Color(0, 128, 128));
	}
}
