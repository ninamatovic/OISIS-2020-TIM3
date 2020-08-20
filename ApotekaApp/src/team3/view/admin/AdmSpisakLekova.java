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
	private JTextField textField;

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
		JLabel lblNewLabel_3 = new JLabel("Lista lekova ");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(248, 96, 171, 28);
		panel.add(lblNewLabel_3);

		JButton lblNewLabel_3_1 = new JButton("Dodaj novi");
		lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(392, 96, 171, 28);
		panel.add(lblNewLabel_3_1);

		lblNewLabel_3_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showNewMedicinePage();
			}
		});

		JLabel lblNewLabel_3_2 = new JLabel("Izmeni postojeci");
		lblNewLabel_3_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(528, 96, 171, 28);
		panel.add(lblNewLabel_3_2);

		// ----------------------------------------

		setBackground(new Color(102, 153, 153));

		JLabel txtrPretraga = new JLabel();
		txtrPretraga.setText("Pretraga");
		txtrPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		txtrPretraga.setBackground(new Color(102, 153, 153));
		txtrPretraga.setBounds(286, 154, 84, 45);
		panel.add(txtrPretraga);

		/*
		 * lblNewLabel_2 panel.add(lblNewLabel_2);
		 * 
		 * textField = new JTextField(); textField.setBounds(374, 161, 329, 28);
		 * 
		 */

		textField = new JTextField();
		textField.setBounds(374, 161, 329, 28);
		panel.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(286, 210, 560, 322);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		//table.setEnabled(false);
		scrollPane.setViewportView(table);

		table.setModel(new MedicineTableModel());

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));

	}
}
