
package team3.view.doctor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
import team3.model.Prescription;
import team3.view.MainFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class LekarPretragaRecepata extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public LekarPretragaRecepata(JTable table) {
		setForeground(new Color(0, 0, 51));

		setBackground(new Color(102, 153, 153));
		DoctorUtils.addSidebar(this);
		setLayout(null);

		/*
		 * textField = new JTextField(); textField.setBounds(292, 85, 303, 19);
		 * add(textField); textField.setColumns(10);
		 */

		JLabel lblNewLabel_2 = new JLabel("Pretraga recepata");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setBounds(217, 11, 309, 46);
		add(lblNewLabel_2);

		setBounds(100, 100, 800, 500);

		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(331, 440, 89, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Otka\u017Ei");
		btnNewButton_1.setBounds(450, 440, 89, 23);
		add(btnNewButton_1);

		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField.setBounds(430, 276, 187, 32);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_1.setBounds(430, 142, 187, 32);
		add(textField_1);
		textField_1.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u0160ifra");
		rdbtnNewRadioButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton.setBounds(194, 137, 187, 42);
		rdbtnNewRadioButton.setSelected(true);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Lekar");
		rdbtnNewRadioButton_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton_1.setBounds(194, 198, 187, 42);
		add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("JMBG pacijenta");
		rdbtnNewRadioButton_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton_2.setBounds(194, 270, 187, 45);
		add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Lek");
		rdbtnNewRadioButton_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton_3.setBounds(194, 346, 187, 46);
		add(rdbtnNewRadioButton_3);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton_3);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(430, 203, 187, 32);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(430, 353, 187, 32);
		add(textField_3);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().back();
			}
		});

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultRowSorter sorter = ((DefaultRowSorter) table.getRowSorter());

				List<RowFilter<Object, Object>> f = new LinkedList<>();
				f.add(isDeletedFilter());// sakriva izbirsane

				if (rdbtnNewRadioButton_3.isSelected()) {
					f.add(containsMedicineFIlter(textField_3.getText()));

				} else if (rdbtnNewRadioButton_2.isSelected()) {
					f.add(stringFilter(3, textField.getText()));

				} else if (rdbtnNewRadioButton_1.isSelected()) {
					f.add(stringFilter(2, textField_2.getText()));

				} else {
					f.add(stringFilter(0, textField_1.getText()));
				}
				sorter.setRowFilter(RowFilter.andFilter(f));
				MainFrame.getInstance().back();
			}
		});

	}

	public static RowFilter isDeletedFilter() {
		return new RowFilter<Object, Object>() {
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				PrescriptionTableModel t = (PrescriptionTableModel) entry.getModel();
				int id = (int) t.getValueAt((int) entry.getIdentifier(), 0);
				return !PrescriptionController.getById((id)).isRemoved();

			}
		};
	}

	public static RowFilter stringFilter(int columnId, String text) {
		return RowFilter.regexFilter("(?i)" + text, columnId);// (?i) = case insensitive regex matching
	}

	public static RowFilter<Object, Object> containsMedicineFIlter(String medId) {
		return new RowFilter<Object, Object>() {
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				Prescription p = Database.getInstance().getPrescriptions().get((int) entry.getIdentifier());
				for (String id : p.getMeds().keySet()) {
					if (id.toLowerCase().contains((medId.toLowerCase())))
						return true;
				}
				return false;
			}
		};

	}

}
