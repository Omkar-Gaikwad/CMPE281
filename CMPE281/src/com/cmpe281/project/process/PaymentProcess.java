package com.cmpe281.project.process;

import java.sql.Connection;
import java.sql.SQLException;

import com.cmpe281.project.connection.DatabaseConnection;
import com.cmpe281.project.persistent.OrderItemPersistent;
import com.cmpe281.project.persistent.OrderPersistent;
import com.cmpe281.project.persistent.PaymentPersistent;

public class PaymentProcess {
public boolean makePayment(long cardNumber, int csvNumber, int tenantId, int userId) {
	boolean isSuccess = false;
	Connection connection = DatabaseConnection.getConnection();
	int orderId = -1;
	try {
		if (!connection.isClosed()) {
			OrderPersistent orderPersistent = new OrderPersistent();
			orderId = orderPersistent.getOrderId(connection, userId, tenantId);
			isSuccess = new PaymentPersistent().makePayment(connection, cardNumber, csvNumber, tenantId, userId, orderId);
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
	return isSuccess;
}
}
