package com.cmpe281.project.process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cmpe281.project.beans.CartBean;
import com.cmpe281.project.beans.CartItemsBean;
import com.cmpe281.project.connection.DatabaseConnection;
import com.cmpe281.project.persistent.OrderItemPersistent;
import com.cmpe281.project.persistent.OrderPersistent;

public class CartProcess {
	public boolean addToCart(CartBean cartBean) {
		boolean isAdded = false;
		Connection connection = DatabaseConnection.getConnection();
		int orderId = -1;
		try {
			if (!connection.isClosed()) {
				OrderPersistent orderPersistent = new OrderPersistent();
				orderId = orderPersistent.getOrderId(connection, cartBean.getUserId(), cartBean.getTenantId());
				if (orderId == -1) {
					orderId = orderPersistent.createOrder(connection, cartBean);
				}
				cartBean.setOrderId(orderId);
				if (orderId != -1) {
					isAdded = new OrderItemPersistent().addItem(connection, cartBean);
				} else {
					System.out.println("No order created!!!");
				}
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
		return isAdded;
	}

	public List<CartItemsBean> getCartItems(int tenantId, int userId) {
		List<CartItemsBean> cartItemsList = null;
		Connection connection = DatabaseConnection.getConnection();
		try {
			if (!connection.isClosed()) {
				OrderPersistent orderPersistent = new OrderPersistent();
				cartItemsList = orderPersistent.getCartItems(connection, tenantId, userId);
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
		return cartItemsList;
	}
}
