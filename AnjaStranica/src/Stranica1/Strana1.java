package Stranica1;

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

public class Strana1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Strana1 frame = new Strana1();
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
	public Strana1() {
		
		
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
		
		JButton btnPo_1_1_1 = new JButton("Dodaj recept");
		btnPo_1_1_1.setBounds(30, 290, 150, 40);
		btnPo_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPo_1_1_1.setForeground(Color.WHITE);
		btnPo_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		btnPo_1_1_1.setFocusPainted(false);
		btnPo_1_1_1.setBackground(new Color(51, 102, 102));
		
		JButton btnPo_1_1_1_1 = new JButton("Korpa");
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
		getContentPane().add(btnPo_1_1_1);
		getContentPane().add(btnPo_1_1_1_1);
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
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
	}

	private ImageIcon createImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
