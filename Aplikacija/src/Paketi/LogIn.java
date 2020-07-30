package Paketi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.TextField;
import java.awt.Panel;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel getContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		
		getContentPane().setBackground(new Color(102, 153, 153));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		panel.setBounds(0, 0, 786, 463);
		getContentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Korisni\u010Dko ime");
		lblNewLabel_2.setBounds(242, 232, 131, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		
		JLabel lblNewLabel_3 = new JLabel("Lozinka");
		lblNewLabel_3.setBounds(294, 280, 79, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Dobro do\u0161li");
		lblNewLabel_1.setBounds(294, 143, 171, 43);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		
		TextField textField = new TextField();
		textField.setBounds(388, 232, 131, 21);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(388, 280, 131, 21);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(320, 351, 112, 35);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.setForeground(new Color(0, 0, 51));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(300, 33, 143, 121);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/Slike/LogoM.png")));
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
	}
		
		private ImageIcon createImage(String string) {
			// TODO Auto-generated method stub
			return null;
		
	}
}
