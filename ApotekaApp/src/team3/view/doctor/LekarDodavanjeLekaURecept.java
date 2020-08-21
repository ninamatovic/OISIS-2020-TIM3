package team3.view.doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import team3.controller.MedicineController;
import team3.controller.PrescriptionController;
import team3.model.Medicine;
import team3.view.MainFrame;

public class LekarDodavanjeLekaURecept extends JPanel {
	private JTextField textField;

	public LekarDodavanjeLekaURecept() {
		setForeground(new Color(0, 0, 51));

		setBackground(new Color(102, 153, 153));


	

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon("/resources/img/LogoM.png"));
		setLayout(null);
		/*add(btnPocetna);
		add(btnLekovi);
		add(btnRecepti);
		add(BtnDodajRecept);
		add(lblNewLabel);*/
		DoctorUtils.addSidebar(this);

		JLabel lblNewLabel_1 = new JLabel("Kreiranje novog recepta");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(187, 23, 360, 46);
		add(lblNewLabel_1);

		JButton BtnIzlogujSe = new JButton("Izloguj se");
		BtnIzlogujSe.setBackground(new Color(51, 102, 102));
		BtnIzlogujSe.setForeground(new Color(255, 255, 255));
		BtnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		BtnIzlogujSe.setBounds(603, 29, 150, 40);
		BtnIzlogujSe.setFocusPainted(false);
		///add(BtnIzlogujSe);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(190, 116, 558, 304);
		add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Dodaj");

		btnNewButton.setBounds(309, 262, 104, 27);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(153, 255, 102));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(0, 0, 51));

		JButton btnNewButton_1 = new JButton("Odustani");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().back();
			}
		});
		btnNewButton_1.setBounds(423, 262, 104, 27);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 153, 153));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setForeground(new Color(0, 0, 51));

		JComboBox comboBox = new JComboBox(MedicineController.getAll().toArray());
		comboBox.setBounds(215, 67, 227, 36);
		panel.add(comboBox);

		JLabel lblLek = new JLabel("Lek");
		lblLek.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblLek.setBounds(146, 63, 59, 39);
		panel.add(lblLek);

		JLabel lblKoliina = new JLabel("Koli\u010Dina");
		lblKoliina.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblKoliina.setBounds(119, 152, 80, 39);
		panel.add(lblKoliina);

		textField = new JTextField();
		textField.setBounds(215, 156, 227, 36);
		panel.add(textField);
		textField.setColumns(10);

		setBounds(100, 100, 800, 500);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicine med = (Medicine) comboBox.getSelectedItem();
				if (med == null) {
					JOptionPane.showMessageDialog(null, "Lek nije izabran");
					return;
				}
				try {
					int q = Integer.parseInt(textField.getText());
					if (q < 1) {
						JOptionPane.showMessageDialog(null, "Kolièina nije ispravna");
						return;
					}
					PrescriptionController.add(med, q);
					MainFrame.getInstance().back();

				} catch (Exception eq) {
					JOptionPane.showMessageDialog(null, "Kolièina nije ispravna");
					return;
				}

			}

		});

	}
}
