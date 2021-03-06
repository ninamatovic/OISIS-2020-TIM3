package team3.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team3.controller.UserController;
import team3.view.MainFrame;

public class AdmSpisakKorisnika extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7548570708207322324L;
	private JTable table;

	public AdmSpisakKorisnika() {
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
		//table.getColumnModel().getColumn(2).setPreferredWidth(25);
		scrollPane.setViewportView(table);

		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		table.setAutoCreateRowSorter(true);


		JLabel lblNewLabel_1 = new JLabel("Korisnici");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 240, 111);
		panel.add(lblNewLabel_1);

		/*
		 * JLabel lblNewLabel_3_1 = new JLabel("Registracija ");
		 * lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		 * lblNewLabel_3_1.setBounds(423, 96, 171, 28); panel.add(lblNewLabel_3_1);
		 */

		JButton a = new JButton("Registracija");
		a.setForeground(Color.WHITE);
		a.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		a.setBackground(new Color(0, 128, 128));
		a.setBounds(286, 125, 171, 51);
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().showRegistrationPage();
			}
		});
		panel.add(a);
	}
}
