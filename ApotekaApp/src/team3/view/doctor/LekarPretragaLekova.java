package team3.view.doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.border.BevelBorder;

import team3.controller.MedicineController;
import team3.view.MainFrame;

public class LekarPretragaLekova extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public LekarPretragaLekova(JTable table) {

		setBackground(new Color(102, 153, 153));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon(("/resources/img/LogoM.png")));
		setLayout(null);

		add(lblNewLabel);
		DoctorUtils.addSidebar(this);

		JLabel lblNewLabel_1 = new JLabel("Pretraga lekova");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(217, 20, 309, 46);
		add(lblNewLabel_1);

		// setBackground(Color.WHITE);

		setBounds(100, 100, 800, 500);
		ArrayList list = new ArrayList();
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(484, 444, 104, 45);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Otka\u017Ei");
		btnNewButton_1.setBounds(622, 444, 117, 45);
		add(btnNewButton_1);

		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField.setBounds(534, 300, 187, 32);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_1.setBounds(534, 166, 187, 32);
		add(textField_1);
		textField_1.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u0160ifra");
		rdbtnNewRadioButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton.setBounds(298, 161, 187, 42);
		rdbtnNewRadioButton.setSelected(true);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ime");
		rdbtnNewRadioButton_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton_1.setBounds(298, 222, 187, 42);
		add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Proizvo\u0111a\u010D");
		rdbtnNewRadioButton_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton_2.setBounds(298, 294, 187, 45);
		add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Cena");
		rdbtnNewRadioButton_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		rdbtnNewRadioButton_3.setBounds(298, 370, 187, 46);
		add(rdbtnNewRadioButton_3);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton_3);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(534, 227, 187, 32);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(534, 377, 76, 32);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(644, 377, 76, 32);
		add(textField_4);

		JLabel label = new JLabel("-");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(621, 378, 13, 26);
		add(label);

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
				f.add(isDeletedFilter());
				if (rdbtnNewRadioButton_3.isSelected()) {// cena
					// f.add(containsMedicineFIlter(textField_3.getText()));
					String error = "";

					String minVal = textField_3.getText().trim();
					String maxVal = textField_4.getText().trim();

					float priceMin = Float.MIN_VALUE, priceMax = Float.MAX_VALUE;

					if (!minVal.equals("")) {
						try {
							priceMin = Float.parseFloat(minVal);
							if (priceMin <= 0) {
								error += "Minimalna vrednost mora biti pozitivna\r\n";
							}
						} catch (NumberFormatException ex) {
							error += "Minimalna vrednost nije u ispravnom formatu\r\n";
						}
					}
					if (!maxVal.equals("")) {
						try {
							priceMax = Float.parseFloat(maxVal);
							if (priceMax <= 0) {
								error += "Maksimalna vrednost mora biti pozitivna\r\n";
							}
						} catch (NumberFormatException ex) {
							error += "Maksimalna vrednost nije u ispravnom formatu\r\n";
						}
					}
					if (priceMin > priceMax)
						error += "Minimalna cena ne moze biti veca od maksimalne\r\n";
					if (!error.equals("")) {

						JOptionPane.showMessageDialog(null, error, "Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
					f.add(minMaxFilter(priceMin, priceMax));

				} else if (rdbtnNewRadioButton_2.isSelected()) {
					f.add(stringFilter(2, textField.getText()));

				} else if (rdbtnNewRadioButton_1.isSelected()) {
					f.add(stringFilter(1, textField_2.getText()));

				} else {
					f.add(stringFilter(0, textField_1.getText()));
				}
				sorter.setRowFilter(RowFilter.andFilter(f));
				MainFrame.getInstance().back();
			}
		});
	}

	public static RowFilter<Object, Object> minMaxFilter(float min, float max) {
		return new RowFilter<Object, Object>() {
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				MedicineTableModel t = (MedicineTableModel) entry.getModel();
				float price = (float) t.getValueAt((int) entry.getIdentifier(), 4);
				return price >= min && price <= max;
			}
		};

	}

	public static RowFilter stringFilter(int columnId, String text) {
		return RowFilter.regexFilter("(?i)" + text, columnId);// (?i) = case insensitive regex matching
	}

	public static RowFilter isDeletedFilter() {
		return new RowFilter<Object, Object>() {
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				MedicineTableModel t = (MedicineTableModel) entry.getModel();
				String id = (String) t.getValueAt((int) entry.getIdentifier(), 0);
				return !MedicineController.getById(id).isRemoved();
			}
		};
	}
}
