package com.cmpe281.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/*connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmpe281", "root", "Janataraja-384");*/
			connection = DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_cmpe281project", "b7e78d351fa60a", "c8c03a02");
			System.out.println("success" + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection con){
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(PreparedStatement statement, ResultSet resultSet){
		try {
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(PreparedStatement statement,ResultSet set, Connection connection){
		try {
			if (statement != null) {
				statement.close();
			}
			if (set != null) {
				set.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
