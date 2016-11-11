package com.library.util;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class ConnectDB {
	// JDBC driver name and database URL
	static final String ABC = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	Connection conn = null;
    public static Connection getConnection() {
        try {
            Class.forName(ABC); //register jdbc driver
            Connection conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            // JOptionPane.showMessageDialog(null, "Connected to db");
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}