
package team3.view.pharmacist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import team3.Database;
import team3.controller.MedicineController;
import team3.controller.PrescriptionController;
import team3.controller.SellController;
import team3.model.Medicine;
import team3.model.Prescription;
import team3.model.SellInfo;

public class ApProdajaLek extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField;

	public ApProdajaLek(Medicine row) {

		setBounds(100, 100, 904, 626);
		setBackground(new Color(95, 158, 160));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		panel.setBackground(new Color(95, 158, 160));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		PharmacistUtils.addSidebar(panel);

		// ----------------------------------------

		setBackground(new Color(102, 153, 153));

		/*
		 * lblNewLabel_2 panel.add(lblNewLabel_2);
		 * 
		 * textField = new JTextField(); textField.setBounds(374, 161, 329, 28);
		 * 
		 */

		JLabel lblNewLabel_1 = new JLabel("Korpa");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(249, -12, 240, 113);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(286, 210, 560, 322);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);
		// table.setEnabled(false);
		scrollPane.setViewportView(table);

		table.setModel(new CartTableModel());

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		table.setAutoCreateRowSorter(true);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		panel.add(lblNewLabel);

		// JLabel
		lblNewLabel_1 = new JLabel("\u0160ifra leka:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(267, 112, 105, 24);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Koli\u010Dina");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(499, 115, 73, 19);
		panel.add(lblNewLabel_2);
		SpinnerModel sm = new SpinnerNumberModel(1, 1, null, 1); // default value,lower bound,upper bound,increment by

		JSpinner spinner = new JSpinner(sm);
		spinner.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		spinner.setBounds(582, 114, 52, 20);
		panel.add(spinner);

		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setBounds(644, 113, 89, 23);
		panel.add(btnNewButton_1);

		Medicine[] a = MedicineController.getNoPrescription();

		JComboBox comboBox = new JComboBox(a);
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		if (row != null) {
			comboBox.setSelectedItem(row);

		}
		comboBox.setBounds(382, 111, 107, 24);
		panel.add(comboBox);

		JLabel lblifraRecepta = new JLabel("\u0160ifra recepta:");
		lblifraRecepta.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblifraRecepta.setBounds(272, 147, 107, 23);
		panel.add(lblifraRecepta);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(382, 147, 107, 23);
		panel.add(textField_1);

		JButton button = new JButton("Dodaj");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(644, 147, 89, 23);
		panel.add(button);

		JLabel lblKupac = new JLabel("Kupac:");
		lblKupac.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblKupac.setBounds(267, 181, 74, 18);
		panel.add(lblKupac);

		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(382, 179, 107, 23);
		panel.add(textField);

		JLabel lblPopust = new JLabel("Popust: 0%");
		lblPopust.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPopust.setBounds(644, 181, 89, 23);
		panel.add(lblPopust);

		JLabel lblUkupnaCena = new JLabel("Ukupna cena: 0.0");
		lblUkupnaCena.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblUkupnaCena.setBounds(296, 543, 160, 40);
		panel.add(lblUkupnaCena);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnPotvrdi.setBounds(551, 552, 89, 31);
		btnPotvrdi.setBackground(new Color(102, 205, 170));
		panel.add(btnPotvrdi);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_1.getText();
				try {
					int idd = Integer.parseInt(id);
					Prescription p = PrescriptionController.getById(idd);
					if (p == null)
						JOptionPane.showMessageDialog(null, "Neispravna šifra recepta");
					else {
						SellController.addPrescriptionToCart(p);
						((CartTableModel) table.getModel()).fireTableDataChanged();
						textField_1.setText("");
						int pr = SellController.calculatePercentOff(textField.getText());
						lblPopust.setText("Popust: " + pr + "%");
						lblUkupnaCena.setText("Ukupno: " + (SellController.getTotalPrice() * (1 - pr / 100.0)));
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Neispravna šifra recepta");
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int q = (int) spinner.getValue();
				Medicine med = (Medicine) comboBox.getSelectedItem();
				if (med == null) {
					JOptionPane.showMessageDialog(null, "Lek nije izabran");

					return;
				}
				SellController.addToCart(med, q);
				((CartTableModel) table.getModel()).fireTableDataChanged();
				int p = SellController.calculatePercentOff(textField.getText());
				lblPopust.setText("Popust: " + p + "%");
				lblUkupnaCena.setText("Ukupno: " + (SellController.getTotalPrice() * (1 - p / 100.0)));

			}
		});

		JButton btnPoniti = new JButton("Poni\u0161ti");
		btnPoniti.setBackground(new Color(255, 182, 193));
		btnPoniti.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnPoniti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.getInstance().setCart(new SellInfo());
				((CartTableModel) table.getModel()).fireTableDataChanged();
				textField.setText("");
			}
		});
		textField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				int p = SellController.calculatePercentOff(textField.getText());
				lblPopust.setText("Popust: " + p + "%");
				lblUkupnaCena.setText("Ukupno: " + (SellController.getTotalPrice() * (1 - p / 100.0)));
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				int p = SellController.calculatePercentOff(textField.getText());
				lblPopust.setText("Popust: " + p + "%");
				lblUkupnaCena.setText("Ukupno: " + (SellController.getTotalPrice() * (1 - p / 100.0)));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				int p = SellController.calculatePercentOff(textField.getText());
				lblPopust.setText("Popust: " + p + "%");
				lblUkupnaCena.setText("Ukupno: " + (SellController.getTotalPrice() * (1 - p / 100.0)));
			}
		});
		btnPoniti.setBounds(674, 552, 89, 31);
		panel.add(btnPoniti);
		table.setRowHeight(25);
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		table.setFillsViewportHeight(true);

		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102),
				new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Database.getInstance().getCart().getItems().size() == 0) {
					JOptionPane.showMessageDialog(null, "Korpa je prazna");
					return;
				}
				Database.getInstance().getCart().setBuyer(textField.getText());
				SellController.buy();
				btnPoniti.doClick();

			}
		});
	}
}
