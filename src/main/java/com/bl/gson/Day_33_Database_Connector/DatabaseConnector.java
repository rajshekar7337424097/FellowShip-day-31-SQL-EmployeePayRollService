package com.bl.gson.Day_33_Database_Connector;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DatabaseConnector {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://Localhost:3306/employee_db";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mySql connector is not loaded");
			e.printStackTrace();
		}
		
		Connection con;
		try {
			con = DriverManager.getConnection(jdbcURL, username, password);
		} catch (SQLException e) {
			System.out.println("Connnection establish failed");
			e.printStackTrace();
		}
	}
	
	public static void listDrivers() {
		Enumeration<Driver> listDrivers = DriverManager.getDrivers();
		
		while(listDrivers.hasMoreElements()) {
			Driver d = listDrivers.nextElement();
			System.out.println(d.getClass().getName());
		}
	}
}
