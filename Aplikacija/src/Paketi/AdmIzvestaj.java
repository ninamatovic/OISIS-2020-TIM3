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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;

public class AdmIzvestaj extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmIzvestaj frame = new AdmIzvestaj();
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
	public AdmIzvestaj() {
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
		
		
		
		
		
		JButton btnIzlogujSe = new JButton("Izloguj se");
		btnIzlogujSe.setForeground(new Color(255, 255, 255));
		btnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnIzlogujSe.setFocusPainted(false);
		btnIzlogujSe.setBackground(new Color(204, 204, 255));
		btnIzlogujSe.setBounds(603, 29, 150, 40);
		getContentPane().add(btnIzlogujSe);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Izve�taj");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(217, 20, 309, 46);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(216, 194, 507, 226);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
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
				"Naziv leka", "Proizvo\u0111a\u010D", "Lekar", "Koli\u010Dina", "Cena"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.getColumnModel().getColumn(1).setPreferredWidth(181);
		table.getColumnModel().getColumn(2).setPreferredWidth(139);
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ukupna prodaja svih lekova");
		rdbtnNewRadioButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		rdbtnNewRadioButton.setBackground(new Color(102, 153, 153));
		rdbtnNewRadioButton.setBounds(226, 82, 327, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnUkupnaProdajaSvih = new JRadioButton("Ukupna prodaja svih lekova odabranog proizvo\u0111a\u010D");
		rdbtnUkupnaProdajaSvih.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		rdbtnUkupnaProdajaSvih.setBackground(new Color(102, 153, 153));
		rdbtnUkupnaProdajaSvih.setBounds(226, 122, 446, 23);
		getContentPane().add(rdbtnUkupnaProdajaSvih);
		
		JRadioButton rdbtnUkupnaProdajaSvih_1 = new JRadioButton("Ukupna prodaja svih lekova koje je odabrani apotekar prodao");
		rdbtnUkupnaProdajaSvih_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		rdbtnUkupnaProdajaSvih_1.setBackground(new Color(102, 153, 153));
		rdbtnUkupnaProdajaSvih_1.setBounds(226, 164, 497, 23);
		getContentPane().add(rdbtnUkupnaProdajaSvih_1);
		
		JButton btnPo_1_1_1 = new JButton("Korisnici");
		btnPo_1_1_1.setForeground(Color.WHITE);
		btnPo_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPo_1_1_1.setFocusPainted(false);
		btnPo_1_1_1.setBackground(new Color(51, 102, 102));
		btnPo_1_1_1.setBounds(30, 295, 150, 40);
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
