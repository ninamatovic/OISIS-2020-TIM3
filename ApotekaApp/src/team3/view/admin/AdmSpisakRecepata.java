
package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import team3.Database;
import team3.view.MainFrame;

public class AdmSpisakRecepata extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	public AdmSpisakRecepata() {

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

		// ----------------------------------------

		setBackground(new Color(102, 153, 153));

		/*
		 * lblNewLabel_2 panel.add(lblNewLabel_2);
		 * 
		 * textField = new JTextField(); textField.setBounds(374, 161, 329, 28);
		 * 
		 */

		JLabel lblNewLabel_1 = new JLabel("Recepti");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(246, -6, 240, 111);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_1);

		JButton lblNewLabel_11 = new JButton("Detalji");
		lblNewLabel_11.addActionListener(new ActionListener() {

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
		lblNewLabel_11.setForeground(new Color(0, 0, 51));
		lblNewLabel_11.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_11.setBounds(284, 130, 130, 49);
		panel.add(lblNewLabel_11);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(286, 210, 560, 322);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		// table.setEnabled(false);
		scrollPane.setViewportView(table);

		table.setModel(new PrescriptionTableModel());

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		
		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.setForeground(new Color(0, 0, 51));
		btnPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnPretraga.setBounds(440, 130, 130, 49);
		panel.add(btnPretraga);

	}

}
