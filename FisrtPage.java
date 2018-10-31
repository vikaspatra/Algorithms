import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FisrtPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FisrtPage frame = new FisrtPage();
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
	public FisrtPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustome = new JLabel("Customer");
		lblCustome.setForeground(Color.ORANGE);
		lblCustome.setFont(new Font("Dialog", Font.BOLD, 41));
		lblCustome.setBounds(167, 138, 373, 44);
		contentPane.add(lblCustome);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setForeground(Color.ORANGE);
		lblEmployee.setFont(new Font("Dialog", Font.BOLD, 41));
		lblEmployee.setBounds(170, 219, 370, 53);
		contentPane.add(lblEmployee);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setForeground(Color.ORANGE);
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 41));
		rdbtnNewRadioButton.setBounds(413, 161, 127, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setForeground(Color.ORANGE);
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 41));
		rdbtnNewRadioButton_1.setBounds(413, 228, 127, 44);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNext.setBounds(304, 323, 85, 21);
		contentPane.add(btnNext);
	}
}
