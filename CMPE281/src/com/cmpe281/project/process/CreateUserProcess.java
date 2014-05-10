package com.cmpe281.project.process;

import java.sql.Connection;
import java.sql.SQLException;

import com.cmpe281.project.beans.UserBean;
import com.cmpe281.project.connection.DatabaseConnection;
import com.cmpe281.project.persistent.UserPersistent;

public class CreateUserProcess {
	public int createUser(UserBean userBean) {

		Connection connection = DatabaseConnection.getConnection();
		int userId = -1;
		try {
			if (!connection.isClosed()) {
				UserPersistent userPersistent = new UserPersistent();
				userId = userPersistent.createUser(connection, userBean);
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
		return userId;
	}
}
