
package Paketi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LekarSpisakRecepata extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LekarSpisakRecepata frame = new LekarSpisakRecepata();
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
	public LekarSpisakRecepata() {
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
				"\u0160ifra leka", "Ime doktora", "Ime pacijenta", "Datum", "Ime leka"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(78);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setPreferredWidth(145);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(159);
		table.setForeground(new Color(0, 51, 102));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 51, 102), new Color(0, 51, 102), new Color(0, 51, 102), new Color(0, 51, 102)));
		table.setBackground(new Color(204, 204, 255));
		
		JLabel lblNewLabel_1 = new JLabel("Pretraga");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(217, 78, 88, 27);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(292, 85, 303, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton BtnIzlogujSe = new JButton("Izloguj se");
		BtnIzlogujSe.setBackground(new Color(204, 204, 255));
		BtnIzlogujSe.setForeground(new Color(0, 0, 51));
		BtnIzlogujSe.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		BtnIzlogujSe.setBounds(603, 29, 150, 40);
		getContentPane().add(BtnIzlogujSe);
		
		JLabel lblNewLabel_2 = new JLabel("Spisak recepata");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setBounds(217, 20, 309, 46);
		getContentPane().add(lblNewLabel_2);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 800, 500);
	}

	private ImageIcon createImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
