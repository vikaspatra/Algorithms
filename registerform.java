import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class registerform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_FN;
	private JTextField textField_LN;
	private JTextField textField_UN;
	private JTextField textField_MD;
	public JTextField textField_MN;
	private JPasswordField passwordField_PASS;
	PreparedStatement pst=null;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerform frame = new registerform();
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
	public registerform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(45, 44, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("last  Name  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(41, 90, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User name  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(41, 132, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password   :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(41, 180, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile  Device  :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(41, 224, 113, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile  no.   :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(41, 266, 93, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(70, 328, 107, 23);
		contentPane.add(btnNewButton);
		
		textField_FN = new JTextField();
		textField_FN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textField_FN.setBounds(176, 41, 157, 20);
		contentPane.add(textField_FN);
		textField_FN.setColumns(10);
		
		textField_LN = new JTextField();
		textField_LN.setBounds(176, 87, 157, 20);
		contentPane.add(textField_LN);
		textField_LN.setColumns(10);
		
		textField_UN = new JTextField();
		textField_UN.setBounds(176, 129, 157, 20);
		contentPane.add(textField_UN);
		textField_UN.setColumns(10);
		
		textField_MD = new JTextField();
		textField_MD.setBounds(176, 221, 157, 20);
		contentPane.add(textField_MD);
		textField_MD.setColumns(10);
		
		textField_MN = new JTextField();
		textField_MN.setBounds(176, 266, 157, 20);
		contentPane.add(textField_MN);
		textField_MN.setColumns(10);
		
		// register button
		
		
		JButton SIGNUP = new JButton("REGISTER");
		SIGNUP.setForeground(Color.RED);
		SIGNUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				// string variables
				String fname = textField_FN.getText();
				String lname = textField_LN.getText();
				String uname = textField_UN.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField_PASS.getText();
				String modev = textField_MD.getText();
				String mobileno = textField_MN.getText();
				PreparedStatement pst=null;

				

				try {
					
					// sql query
					
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dell\\eclipse-workspace\\UserData.sqlite");
				pst =conn.prepareStatement("insert into UserData values (?,?,?,?,?,?)");
				
				pst.setString(1, fname);
				pst.setString(2,lname);
				pst.setString(3,uname);
				pst.setString(4,pass);
				pst.setString(5,modev);
				pst.setString(6,mobileno);			
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
				
			
			
			}});
		SIGNUP.setFont(new Font("Tahoma", Font.BOLD, 14));
		SIGNUP.setBounds(187, 328, 132, 23);
		contentPane.add(SIGNUP);
		
		JLabel lblNewLabel_6 = new JLabel("REGISTER  FORM");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(114, 11, 182, 22);
		contentPane.add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(114, 31, 1, 2);
		contentPane.add(separator);
		
		passwordField_PASS = new JPasswordField();
		passwordField_PASS.setBounds(176, 177, 157, 20);
		contentPane.add(passwordField_PASS);
	}
}
