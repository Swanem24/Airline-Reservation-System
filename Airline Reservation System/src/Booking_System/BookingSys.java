package Booking_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;

import java.sql.*;
import javax.swing.*;

public class BookingSys {

	private JFrame frame;
	private JTextField txtTotalCost;
	private JTextField txtTicketInfo;
	
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingSys window = new BookingSys();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingSys() {
		initialize();
		conn = SqliteConnection.ConnectDb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 763, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Airline Reservation System");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(225, 11, 314, 33);
		frame.getContentPane().add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 725, 11);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Ticket Class");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 69, 155, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBoxTicketClass = new JComboBox();
		comboBoxTicketClass.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Business", "First"}));
		comboBoxTicketClass.setBounds(41, 100, 93, 22);
		frame.getContentPane().add(comboBoxTicketClass);
		
		JComboBox comboBoxFrom = new JComboBox();
		comboBoxFrom.setModel(new DefaultComboBoxModel(new String[] {"London", "Paris", "Berlin", "Tokyo", "Rio", "Denver", "Kathmandu"}));
		comboBoxFrom.setBounds(41, 177, 93, 22);
		frame.getContentPane().add(comboBoxFrom);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFrom.setBounds(10, 133, 155, 33);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(10, 210, 155, 33);
		frame.getContentPane().add(lblTo);
		
		JComboBox comboBoxTo = new JComboBox();
		comboBoxTo.setModel(new DefaultComboBoxModel(new String[] {"London", "Paris", "Berlin", "Tokyo", "Rio", "Denver", "Kathmandu"}));
		comboBoxTo.setSelectedIndex(2);
		comboBoxTo.setBounds(41, 254, 93, 22);
		frame.getContentPane().add(comboBoxTo);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(144, 101, 30, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnSearchFlights = new JButton("Search Fligths");
		btnSearchFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String x = String.valueOf(comboBoxTicketClass.getSelectedItem());

				if(x == "Economy")
				{
					txtTotalCost.setText("£100");
					txtTicketInfo.setText("From London to Berline ");
				}
				else if(x == "Business")
				{
					txtTotalCost.setText("£500");
				}
				else
				{
					txtTotalCost.setText("£1000");
				}
			}
		});
		btnSearchFlights.setBounds(45, 450, 120, 23);
		frame.getContentPane().add(btnSearchFlights);
		
		JLabel lblNewLabel_1 = new JLabel("Total Cost:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(389, 360, 75, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtTotalCost = new JTextField();
		txtTotalCost.setEditable(false);
		txtTotalCost.setBounds(467, 362, 86, 20);
		frame.getContentPane().add(txtTotalCost);
		txtTotalCost.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(386, 283, 349, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTicketInfo = new JTextField();
		txtTicketInfo.setEditable(false);
		txtTicketInfo.setBounds(10, 11, 329, 44);
		panel.add(txtTicketInfo);
		txtTicketInfo.setColumns(10);
	}
}
