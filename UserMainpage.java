import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;

public class UserMainpage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField textField_3;
	public  JTextField t4;
	public String s1,s2;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainpage frame = new UserMainpage();
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
	public UserMainpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("1");
		label.setBounds(27, 163, 12, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(27, 191, 11, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(27, 216, 11, 14);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setBounds(27, 241, 11, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("5");
		lblNewLabel_4.setBounds(27, 266, 11, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Battery Issues");
		lblNewLabel_5.setBounds(71, 191, 137, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Display Issiues / Broken Display");
		lblNewLabel_6.setBounds(71, 163, 184, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile Service");
		lblNewLabel_7.setBounds(71, 216, 137, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Audio Problems");
		lblNewLabel_8.setBounds(71, 241, 137, 14);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Camera Issues");
		lblNewLabel_9.setBounds(71, 266, 137, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(261, 158, 109, 23);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(261, 186, 49, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(261, 211, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setBounds(261, 236, 49, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
		rdbtnNewRadioButton_4.setBounds(261, 257, 36, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(122, 291, 196, 2);
		contentPane.add(separator);
		
		JButton btnTotal = new JButton("TOTAL");
		btnTotal.setBounds(48, 315, 89, 23);
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result1=200,result2=300,result3=999,result4=199,result5=399,total=0;
				
					if(rdbtnNewRadioButton.isSelected()) 
				{
				total=total+result1;
				s1="Display issue";
				
				}	
			else
				{
				total=0;
				}
			if(rdbtnNewRadioButton_1.isSelected())
			{
				total=result2+total;
				s1="battery issue";
			}
			else 
			{
				total=total;
			}
			if(rdbtnNewRadioButton_2.isSelected())
				{
				total=result3+total;
				s1="Mobile Service";
				}
			else {
				total=total;
			}
			if(rdbtnNewRadioButton_3.isSelected())
				{
				total=result4+total;
				s1="audio issue";
				}
			else
				{
				total=total;
				}
			if(rdbtnNewRadioButton_4.isSelected())
				{
				total=result5+total;
				s1="Camera issue";
				}
			else 
			{
				total=total;
			}
			
				textField_3.setText(Integer.toString(total));

				try {
					
					// sql query
					
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dell\\eclipse-workspace\\UserData.sqlite");
				PreparedStatement pst =conn.prepareStatement("insert into Issues values (?,?,?)");
				s2="Processing";
				pst.setString(1,t4.getText().toString() );
				pst.setString(2,s1);
				pst.setString(3,s2);			
				int rs=pst.executeUpdate();
			if(rs > 0) {
				
					JOptionPane.showMessageDialog(null,"NEW USER ADD");
					pst.close();
				  // rs.close();
			}
			else {
				JOptionPane.showMessageDialog(null,"DATA NOT SAVED");
				
			}
							
					
			
			}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"e");
				
				}
				
			
			
		
			}
			}
			
			);
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnTotal);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(246, 325, 49, 2);
		contentPane.add(separator_1);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setBounds(166, 350, 89, 23);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame fees=new fees();
				fees.setVisible(true);

				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnNext);
		
		textField_3 = new JTextField();
		textField_3.setBounds(232, 318, 86, 20);
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(196, 113, 101, 23);
		contentPane.add(t4);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setBounds(239, 21, 221, 59);
		lblWelcome.setForeground(Color.YELLOW);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 37));
		contentPane.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Check Status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	try {
					
					// sql query
					
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dell\\eclipse-workspace\\UserData.sqlite");
				PreparedStatement pst =conn.prepareStatement("select * from Issues");		
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			if(rs.next()) {
				
					JOptionPane.showMessageDialog(null,"NEW USER ADD");
					pst.close();
				  // rs.close();
			}
			else {
				JOptionPane.showMessageDialog(null,"DATA NOT SAVED");
				
			}
							
					
			
			}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"e");
				
				}
				
				
			}
		});
		btnNewButton.setBounds(27, 418, 146, 21);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(27, 476, 625, 136);
		contentPane.add(table);
		
		JLabel lblName = new JLabel("NAME : ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(122, 104, 75, 35);
		contentPane.add(lblName);
	}
}
