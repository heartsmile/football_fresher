package com.quanta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	protected Connection conn;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (conn == null)
				conn = DriverManager
						.getConnection("jdbc:mysql://localhost/football?user=root&password=");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		if (conn != null) {
			try {
				if (conn.isClosed()) {
					conn = DriverManager
							.getConnection("jdbc:mysql://localhost/football?user=root&password=");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
