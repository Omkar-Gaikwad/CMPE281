package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cmpe281.project.beans.CartBean;
import com.cmpe281.project.connection.DatabaseConnection;

public class OrderItemPersistent {
	private final String ADD_ITEM = " INSERT INTO  order_items(ORDER_ID,PRODUCT_ID,COLUMN1) VALUES (?, ?, ?)  ";
	private final String CHECK_ITEM = " SELECT ORDER_ITEM_ID FROM  order_items WHERE  ORDER_ID = ? AND PRODUCT_ID = ? ";
	private final String UPDATE_QUANTITY = " UPDATE  order_items SET COLUMN1 = ? WHERE  ORDER_ITEM_ID = ? ";

	public boolean addItem(Connection connection, CartBean cartBean) {
		boolean isAdded = false;
		PreparedStatement statement = null;
		PreparedStatement checkStatement = null;
		PreparedStatement updateStatement = null;
		int orderItemId = -1;
		ResultSet resultSet = null;
		boolean isPresent = false;
		try {
			checkStatement = connection.prepareStatement(CHECK_ITEM);
			checkStatement.setInt(1, cartBean.getOrderId());
			checkStatement.setInt(2, cartBean.getItemId());
			System.out.println(checkStatement);
			resultSet = checkStatement.executeQuery();
			if (resultSet.next()) {
				orderItemId = resultSet.getInt(1);
				isPresent = true;
			}
			if (isPresent) {
				updateStatement  = connection.prepareStatement(UPDATE_QUANTITY);
				updateStatement.setString(1, cartBean.getQuantity() + "");
				updateStatement.setInt(2, orderItemId);
				System.out.println(checkStatement);
				updateStatement.executeUpdate();
				isAdded = true;
			} else {
				statement = connection.prepareStatement(ADD_ITEM);
				statement.setInt(1, cartBean.getOrderId());
				statement.setInt(2, cartBean.getItemId());
				statement.setString(3, cartBean.getQuantity() + "");
				System.out.println(statement);
				statement.executeUpdate();
				isAdded = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, null);
			DatabaseConnection.closeConnection(checkStatement, resultSet);
			DatabaseConnection.closeConnection(updateStatement, null);			
		}
		return isAdded;
	}
}
