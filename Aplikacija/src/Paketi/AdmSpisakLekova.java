package Paketi;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdmSpisakLekova extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField txtLekovi;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmSpisakLekova frame = new AdmSpisakLekova();
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
	public AdmSpisakLekova() {
	
			
			
			getContentPane().setBackground(new Color(102, 153, 153));
			
			JButton btnPo = new JButton("Po\u010Detna");
			btnPo.setBounds(30, 110, 150, 40);
			btnPo.setBackground(new Color(51, 102, 102));
			btnPo.setForeground(new Color(255, 255, 255));
			btnPo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnPo.setFocusPainted(false);
			
			JButton btnPo_1 = new JButton("Lekovi");
			btnPo_1.setBounds(30, 170, 150, 40);
			btnPo_1.setForeground(Color.WHITE);
			btnPo_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnPo_1.setFocusPainted(false);
			btnPo_1.setBackground(new Color(51, 102, 102));
			
			JButton btnPo_1_1 = new JButton("Recepti");
			btnPo_1_1.setBounds(30, 230, 150, 40);
			btnPo_1_1.setForeground(Color.WHITE);
			btnPo_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnPo_1_1.setFocusPainted(false);
			btnPo_1_1.setBackground(new Color(51, 102, 102));
			
			JButton btnPo_1_1_1_1 = new JButton("Prodaja");
			btnPo_1_1_1_1.setBounds(30, 380, 150, 40);
			btnPo_1_1_1_1.setForeground(Color.WHITE);
			btnPo_1_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnPo_1_1_1_1.setFocusPainted(false);
			btnPo_1_1_1_1.setBackground(new Color(51, 102, 102));
			
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(27, 5, 150, 112);
			lblNewLabel.setIcon(new ImageIcon(Strana1.class.getResource("/Slike/LogoM.png")));
			getContentPane().setLayout(null);
			getContentPane().add(btnPo);
			getContentPane().add(btnPo_1);
			getContentPane().add(btnPo_1_1);
			getContentPane().add(btnPo_1_1_1_1);
			getContentPane().add(lblNewLabel);
			
			JTextArea txtrPretraga = new JTextArea();
			txtrPretraga.setText("Pretraga");
			txtrPretraga.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			txtrPretraga.setBackground(new Color(102, 153, 153));
			txtrPretraga.setBounds(217, 78, 88, 27);
			getContentPane().add(txtrPretraga);
			
			textField = new JTextField();
			textField.setBounds(292, 85, 303, 19);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton btnIzlogujSe = new JButton("Izloguj se");
			btnIzlogujSe.setForeground(new Color(255, 255, 255));
			btnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnIzlogujSe.setFocusPainted(false);
			btnIzlogujSe.setBackground(new Color(204, 204, 255));
			btnIzlogujSe.setBounds(603, 29, 150, 40);
			getContentPane().add(btnIzlogujSe);
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(null);
			scrollPane.setBounds(217, 110, 536, 309);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
			table.setFillsViewportHeight(true);
			table.setEnabled(false);
			scrollPane.setViewportView(table);
			
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"\u0160ifra leka", "Naziv", "Proizvo\u0111a\u010D", "Recept", "Cena"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, Boolean.class, Float.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(0).setPreferredWidth(78);
			table.getColumnModel().getColumn(1).setPreferredWidth(178);
			table.getColumnModel().getColumn(2).setPreferredWidth(197);
			table.getColumnModel().getColumn(3).setPreferredWidth(82);
			table.getColumnModel().getColumn(4).setPreferredWidth(106);
			table.setForeground(new Color(0, 51, 102));
			table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102), new Color(0, 51, 102), new Color(0, 51, 102)));
			table.setBackground(new Color(204, 204, 255));
			
			JLabel lblNewLabel_1 = new JLabel("Spisak Lekova");
			lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			lblNewLabel_1.setBounds(217, 20, 309, 46);
			getContentPane().add(lblNewLabel_1);
			
			JButton btnPo_1_1_1 = new JButton("Korisnici");
			btnPo_1_1_1.setForeground(Color.WHITE);
			btnPo_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnPo_1_1_1.setFocusPainted(false);
			btnPo_1_1_1.setBackground(new Color(51, 102, 102));
			btnPo_1_1_1.setBounds(30, 292, 150, 40);
			getContentPane().add(btnPo_1_1_1);
			
			
			setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			
			
			setBounds(100, 100, 800, 500);
		}

		private ImageIcon createImage(String string) {
			// TODO Auto-generated method stub
			return null;
	}
}
