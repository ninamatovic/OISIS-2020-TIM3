package Paketi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LekarKreiranjeReceptna extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LekarKreiranjeReceptna frame = new LekarKreiranjeReceptna();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LekarKreiranjeReceptna() {
getContentPane().setForeground(new Color(0, 0, 51));
		
		
		getContentPane().setBackground(new Color(102, 153, 153));
		
		JButton btnPocetna = new JButton("Po\u010Detna");
		btnPocetna.setBounds(30, 110, 150, 40);
		btnPocetna.setBackground(new Color(51, 102, 102));
		btnPocetna.setForeground(new Color(255, 255, 255));
		btnPocetna.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPocetna.setFocusPainted(false);
		
		JButton btnLekovi = new JButton("Lekovi");
		btnLekovi.setBounds(30, 170, 150, 40);
		btnLekovi.setForeground(Color.WHITE);
		btnLekovi.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnLekovi.setFocusPainted(false);
		btnLekovi.setBackground(new Color(51, 102, 102));
		
		JButton btnRecepti = new JButton("Recepti");
		btnRecepti.setBounds(30, 230, 150, 40);
		btnRecepti.setForeground(Color.WHITE);
		btnRecepti.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnRecepti.setFocusPainted(false);
		btnRecepti.setBackground(new Color(51, 102, 102));
		
		JButton BtnDodajRecept = new JButton("Dodaj recept");
		BtnDodajRecept.setBounds(30, 290, 150, 40);
		BtnDodajRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnDodajRecept.setForeground(Color.WHITE);
		BtnDodajRecept.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		BtnDodajRecept.setFocusPainted(false);
		BtnDodajRecept.setBackground(new Color(51, 102, 102));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 5, 150, 112);
		lblNewLabel.setIcon(new ImageIcon(LekarSpisakRecepata.class.getResource("/Slike/LogoM.png")));
		getContentPane().setLayout(null);
		getContentPane().add(btnPocetna);
		getContentPane().add(btnLekovi);
		getContentPane().add(btnRecepti);
		getContentPane().add(BtnDodajRecept);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Kreiranje novog recepta");
		lblNewLabel_1.setForeground(new Color(51, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(187, 23, 360, 46);
		getContentPane().add(lblNewLabel_1);
		
		JButton BtnIzlogujSe = new JButton("Izloguj se");
		BtnIzlogujSe.setBackground(new Color(51, 102, 102));
		BtnIzlogujSe.setForeground(new Color(255, 255, 255));
		BtnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		BtnIzlogujSe.setBounds(603, 29, 150, 40);
		BtnIzlogujSe.setFocusPainted(false);
		getContentPane().add(BtnIzlogujSe);
		
		JLabel lblNewLabel_2 = new JLabel("JMBG pacijenta");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setBounds(215, 179, 141, 23);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("\u0160ifra leka");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 51));
		lblNewLabel_5.setBounds(525, 149, 95, 23);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ime leka");
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(new Color(0, 0, 51));
		lblNewLabel_6.setBounds(533, 119, 76, 23);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kolicina ");
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_7.setForeground(new Color(0, 0, 51));
		lblNewLabel_7.setBounds(550, 266, 70, 23);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ime pacijenta");
		lblNewLabel_8.setForeground(new Color(0, 0, 51));
		lblNewLabel_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(229, 118, 127, 24);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Prezime pacijenta");
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_9.setForeground(new Color(0, 0, 51));
		lblNewLabel_9.setBounds(199, 149, 157, 23);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Ime lekara");
		lblNewLabel_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_10.setForeground(new Color(0, 0, 51));
		lblNewLabel_10.setBounds(252, 239, 104, 23);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Prezime lekara");
		lblNewLabel_11.setForeground(new Color(0, 0, 51));
		lblNewLabel_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(221, 267, 134, 20);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\u0160ifra recepta");
		lblNewLabel_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_12.setForeground(new Color(0, 0, 51));
		lblNewLabel_12.setBounds(496, 239, 124, 23);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Cena leka");
		lblNewLabel_13.setForeground(new Color(0, 0, 51));
		lblNewLabel_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_13.setBounds(530, 179, 82, 23);
		getContentPane().add(lblNewLabel_13);
		
		textField_3 = new JTextField();
		textField_3.setBounds(619, 124, 104, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(619, 154, 104, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(619, 184, 104, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(619, 271, 104, 19);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(619, 244, 104, 19);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(190, 110, 558, 310);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Vreme izdavanja");
		lblNewLabel_4.setBounds(20, 272, 150, 23);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(0, 0, 51));
		
		textField_11 = new JTextField();
		textField_11.setBounds(166, 277, 104, 19);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Datum izdavanja");
		lblNewLabel_3.setBounds(20, 244, 153, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		textField_10 = new JTextField();
		textField_10.setBounds(166, 248, 104, 19);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("\u0160ifra lekara");
		lblNewLabel_14.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_14.setForeground(new Color(0, 0, 51));
		lblNewLabel_14.setBounds(51, 198, 107, 23);
		panel.add(lblNewLabel_14);
		
		textField_12 = new JTextField();
		textField_12.setBounds(166, 203, 104, 19);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(309, 262, 104, 27);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(153, 255, 102));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(0, 0, 51));
		
		JButton btnNewButton_1 = new JButton("Otka\u017Ei");
		btnNewButton_1.setBounds(423, 262, 104, 27);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(255, 153, 153));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton_1.setForeground(new Color(0, 0, 51));
		
		textField_9 = new JTextField();
		textField_9.setBounds(166, 174, 104, 19);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(166, 146, 104, 19);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 84, 104, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 55, 104, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(166, 24, 104, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 800, 500);
	}

	private ImageIcon createImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
