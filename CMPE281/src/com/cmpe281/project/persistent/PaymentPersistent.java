package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cmpe281.project.connection.DatabaseConnection;

public class PaymentPersistent {
	private final String INSERT_TRANSACTION = "  INSERT INTO TRANSACTION_DETAIL(CARD_NUMBER,ORDER_ID,COLUMN1) VALUES (?, ?, 'SUCESS') ";
	
	public boolean makePayment(Connection connection, long cardNumber, int csvNumber, int tenantId, int userId, int orderId) {
		boolean isSuccess = false;
		boolean isUpdated = false;
		boolean isQuatity = false;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(INSERT_TRANSACTION);
			statement.setLong(1, cardNumber);
			statement.setInt(2, orderId);
			System.out.println(statement);
			statement.executeUpdate();
			isSuccess = true;
			if (isSuccess) {
				isUpdated = new OrderPersistent().updateOrderDetails(connection, orderId);
				isUpdated = true;
			}
			if (isSuccess && isUpdated) {
				isQuatity = new ProductPersistent().updateQuantity(connection, orderId);
				isQuatity = true;
			}
			if ( ! (isSuccess && isUpdated && isQuatity)) {
				isSuccess = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, null);
		}
		return isSuccess;
	}
}
