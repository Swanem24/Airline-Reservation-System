package Booking_System;
import java.sql.*;
import javax.swing.*;

public class SqliteConnection 
{
	public static Connection ConnectDb()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:\\C:\\Users\\thewa\\eclipse-workspace\\Airline Reservation System\\Flights.db");
			JOptionPane.showMessageDialog(null, "Database Connected");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,  e);
			return null;
		}
		
	}
}
