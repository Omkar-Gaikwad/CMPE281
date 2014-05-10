package com.cmpe281.project.process;

import java.sql.Connection;
import java.sql.SQLException;

import com.cmpe281.project.beans.UserBean;
import com.cmpe281.project.connection.DatabaseConnection;
import com.cmpe281.project.persistent.UserPersistent;

public class LoginUserProcess {
	public UserBean loginUser(UserBean bean) {
		Connection connection = DatabaseConnection.getConnection();
		UserBean userBean = null;
		try {
			if (!connection.isClosed()) {
				UserPersistent userPersistent = new UserPersistent();
				userBean = userPersistent.loginUser(connection, bean);
			} else {
				System.out.println("Connection problem");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(connection);
		}
		return userBean;
	}
}
