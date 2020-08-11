package Paketi;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Button;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ApDodavanjeLeka extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApDodavanjeLeka frame = new ApDodavanjeLeka();
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
	public ApDodavanjeLeka() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ApDodavanjeLeka.class.getResource("/Slike1/LogoM.png")));
		lblNewLabel.setBounds(40, 0, 149, 148);
		panel.add(lblNewLabel);
		
		Button button = new Button("Pocetna");
		button.setForeground(UIManager.getColor("Button.highlight"));
		button.setBackground(new Color(0, 128, 128));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button.setBounds(30, 154, 171, 45);
		panel.add(button);
		
		Button button_1 = new Button("Lekovi");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(30, 237, 171, 45);
		panel.add(button_1);
		
		Button button_2 = new Button("Recepti");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 128, 128));
		button_2.setBounds(30, 319, 171, 45);
		panel.add(button_2);
		
		Button button_4 = new Button("Korpa");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_4.setBackground(new Color(0, 128, 128));
		button_4.setBounds(30, 484, 171, 45);
		panel.add(button_4);
		
		Button button_5 = new Button("Izloguj se");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		button_5.setBackground(new Color(0, 128, 128));
		button_5.setBounds(675, 29, 171, 45);
		panel.add(button_5);
		
		JLabel lblNewLabel_1 = new JLabel("Lekovi");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblNewLabel_1.setBounds(248, -14, 240, 111);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Lista lekova ");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(248, 96, 171, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Dodaj novi");
		lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(392, 96, 171, 28);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("Naziv:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2.setBounds(380, 183, 88, 37);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(484, 175, 233, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sifra:");
		lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1.setBounds(392, 249, 88, 37);
		panel.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(484, 241, 233, 45);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Proizvodjac:");
		lblNewLabel_2_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_1.setBounds(316, 313, 164, 37);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Cena:");
		lblNewLabel_2_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel_2_1_2.setBounds(398, 381, 82, 37);
		panel.add(lblNewLabel_2_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(484, 373, 233, 45);
		panel.add(textField_2);
		
		Button button_6 = new Button("Otkazi");
		button_6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button_6.setBackground(new Color(255, 182, 193));
		button_6.setBounds(592, 492, 125, 37);
		panel.add(button_6);
		
		Button button_6_1 = new Button("Potvrdi");
		button_6_1.setForeground(Color.WHITE);
		button_6_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		button_6_1.setBackground(new Color(102, 205, 170));
		button_6_1.setBounds(408, 492, 125, 37);
		panel.add(button_6_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Izmeni postojeci");
		lblNewLabel_3_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(528, 96, 171, 28);
		panel.add(lblNewLabel_3_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(484, 305, 233, 45);
		panel.add(textField_3);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
}
