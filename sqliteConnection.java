import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	Connection conn=null;
	public static Connection dbConnector() 
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dell\\eclipse-workspace\\UserData.sqlite");
			JOptionPane.showMessageDialog(null,"Connection successful");
			return conn;
		}
		catch(Exception connectionunsuccessful)
		{
			JOptionPane.showMessageDialog(null,connectionunsuccessful);
			return null; 
		}
	}
}
