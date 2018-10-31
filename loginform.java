import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

public class loginform extends UserMainpage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginform window = new loginform();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	private JPasswordField passwordField;
	private JTextField textField;
	JTextField textField_MN = null;
	JTextField textField_MD = null;
	JTextField passwordField_PASS = null;
	JTextField textField_LN = null;
	JTextField textField_FN = null;
	JTextField textField_UN=null;
	private JTextField txtMscidMo;
	private JTextField txtsakecgmailcom;
	private JTextField txtContactNo;

	/**
	 * Create the application.
	 */
	public loginform() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(139, 0, 139));
		frame.setBounds(100, 100, 554, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName  :");
		lblUsername.setBackground(new Color(230, 230, 250));
		lblUsername.setForeground(new Color(255, 20, 147));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblUsername.setBounds(127, 79, 123, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setBackground(new Color(230, 230, 250));
		lblPassword.setForeground(new Color(255, 20, 147));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(127, 119, 123, 27);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButtonlogin = new JButton("LOGIN");
		btnNewButtonlogin.setForeground(new Color(50, 205, 50));
		btnNewButtonlogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from UserData where UserName=? and Password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count =0;
					while(rs.next()) {
						count=count+1;
						
					}
					if(count ==1)
					{
						JOptionPane.showMessageDialog(null,"username and password is correct");
						JFrame UserMainpage=new JFrame();
						UserMainpage.setVisible(true);
						loginform frame = new loginform();
						frame.setVisible(true);	
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"username and password is not correct try again");
					}
					rs.close();
					pst.close();
						
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"UserMainpage is open");
				}
				
			}
		});
		btnNewButtonlogin.setBounds(196, 182, 93, 30);
		frame.getContentPane().add(btnNewButtonlogin);
		
		JButton btnNewButtonsu = new JButton("SIGNUP");
		btnNewButtonsu.setForeground(new Color(210, 105, 30));
		btnNewButtonsu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtonsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame registerform=new registerform();
				registerform.setVisible(true);
			}
		});
		
		btnNewButtonsu.setBounds(314, 182, 103, 30);
		frame.getContentPane().add(btnNewButtonsu);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(274, 119, 158, 27);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(274, 79, 158, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSakecMobileService = new JLabel("SPEED Mobile Service Center");
		lblSakecMobileService.setForeground(new Color(65, 105, 225));
		lblSakecMobileService.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 28));
		lblSakecMobileService.setBounds(95, 11, 401, 31);
		frame.getContentPane().add(lblSakecMobileService);
		
		JLabel lblAddressShop = new JLabel("ADDRESS : \r\nSHOP NO -7 , GROWELL'S MALl ,\r\nKANDIVALI (E),MUMBAI - 400097 ,\r\nMAHARASHTRA .");
		lblAddressShop.setForeground(new Color(255, 0, 51));
		lblAddressShop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddressShop.setBounds(0, 356, 559, 14);
		frame.getContentPane().add(lblAddressShop);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(30, 144, 255));
		separator.setForeground(new Color(32, 178, 170));
		separator.setBounds(276, 53, 1, 132);
		frame.getContentPane().add(separator);
		
		txtMscidMo = new JTextField();
		txtMscidMo.setForeground(new Color(255, 51, 0));
		txtMscidMo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		txtMscidMo.setText("MSC_ID : MO_1578");
		txtMscidMo.setBounds(0, 222, 154, 20);
		frame.getContentPane().add(txtMscidMo);
		txtMscidMo.setColumns(10);
		
		txtsakecgmailcom = new JTextField();
		txtsakecgmailcom.setForeground(new Color(255, 51, 0));
		txtsakecgmailcom.setFont(new Font("Sitka Small", Font.BOLD, 11));
		txtsakecgmailcom.setText("123sakec@gmail.com");
		txtsakecgmailcom.setBounds(0, 262, 158, 20);
		frame.getContentPane().add(txtsakecgmailcom);
		txtsakecgmailcom.setColumns(10);
		
		txtContactNo = new JTextField();
		txtContactNo.setForeground(new Color(255, 51, 0));
		txtContactNo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		txtContactNo.setText("Contact no. : 9082338605");
		txtContactNo.setBounds(0, 308, 158, 20);
		frame.getContentPane().add(txtContactNo);
		txtContactNo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Downloads\\mobilephone.jpg"));
		lblNewLabel.setBounds(0, 0, 538, 370);
		frame.getContentPane().add(lblNewLabel);
	}
}
