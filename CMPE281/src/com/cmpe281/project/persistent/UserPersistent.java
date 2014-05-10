package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cmpe281.project.beans.UserBean;
import com.cmpe281.project.connection.DatabaseConnection;

public class UserPersistent {
	private final String CREATE_USER = " INSERT INTO USER(FIRST_NAME,LAST_NAME,EMAIL,USER_PASSWORD) values (?,?,?,?)";
	private final String LOGIN_USER = " SELECT USER_ID,FIRST_NAME,LAST_NAME,EMAIL FROM USER WHERE EMAIL = ? AND USER_PASSWORD = ? ";

	public int createUser(Connection connection, UserBean userBean) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int userId = -1;
		try {
			if (!connection.isClosed()) {
				statement = connection.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, userBean.getFirstName());
				statement.setString(2, userBean.getLastName());
				statement.setString(3, userBean.getEmail());
				statement.setString(4, userBean.getUserPassword());
				statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					userId = resultSet.getInt(1);
				}
				System.out.println("Registration Successfull and user id is ::" + userId);
			} else {
				System.out.println("Connection is closed!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		return userId;
	}

	public UserBean loginUser(Connection connection, UserBean bean) {
		UserBean userBean = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(LOGIN_USER);
			statement.setString(1, bean.getEmail());
			statement.setString(2, bean.getUserPassword());			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				userBean = new UserBean();
				userBean.setUserId(resultSet.getInt("USER_ID"));
				userBean.setEmail(resultSet.getString("EMAIL"));
				userBean.setFirstName(resultSet.getString("FIRST_NAME"));
				userBean.setLastName(resultSet.getString("LAST_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		return userBean;
	}
}
