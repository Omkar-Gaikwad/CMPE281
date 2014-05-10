package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cmpe281.project.beans.CartBean;
import com.cmpe281.project.beans.CartItemsBean;
import com.cmpe281.project.connection.DatabaseConnection;

public class OrderPersistent {
	private final String ORDER_ID = " SELECT ORDER_ID FROM ORDER_DETAILS WHERE (COLUMN1 = 'FALSE' OR COLUMN1 = 'false') AND  TENANT_ID = ? AND USER_ID = ? ";
	private final String CREATE_ORDER = " INSERT INTO  ORDER_DETAILS(USER_ID,TENANT_ID,COLUMN1) VALUES (?, ?, 'FALSE') ";

	private final String GET_ORDER = " SELECT ORDER_DETAILS.ORDER_ID AS ORDER_ID, ORDER_DETAILS.USER_ID AS USER_ID, ORDER_ITEMS.ORDER_ITEM_ID AS ORDER_ITEM_ID, ORDER_ITEMS.PRODUCT_ID AS PRODUCT_ID,CAST(ORDER_ITEMS.COLUMN1 AS UNSIGNED) AS QUANTITY,CAST(PRODUCT.COLUMN3 AS DECIMAL(10,2)) AS PRICE, "
			+ " CAST(ORDER_ITEMS.COLUMN1 AS UNSIGNED) * CAST(PRODUCT.COLUMN3 AS DECIMAL(10,2)) AS AMOUNT, PRODUCT.COLUMN1,PRODUCT.COLUMN2,PRODUCT.COLUMN3,PRODUCT.COLUMN4,PRODUCT.COLUMN5,PRODUCT.COLUMN6,PRODUCT.COLUMN7 "
			+ " FROM ORDER_DETAILS INNER JOIN ORDER_ITEMS ON ORDER_DETAILS.ORDER_ID = ORDER_ITEMS.ORDER_ID INNER JOIN PRODUCT ON ORDER_ITEMS.PRODUCT_ID = PRODUCT.ROW_ID "
			+ " WHERE (ORDER_DETAILS.COLUMN1 = 'FALSE' OR ORDER_DETAILS.COLUMN1 = 'FALSE') AND ORDER_DETAILS.TENANT_ID = ? AND ORDER_DETAILS.USER_ID = ?";
	
	private final String UPDATE_ORDER_STATUS = " UPDATE ORDER_DETAILS SET COLUMN1 = 'TRUE' WHERE ORDER_ID = ? ";
	public int getOrderId(Connection connection, int userId, int tenantId) {
		int orderId = -1;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(ORDER_ID);
			statement.setInt(1, tenantId);
			statement.setInt(2, userId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				orderId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		return orderId;
	}

	public int createOrder(Connection connection, CartBean cartBean) {
		int orderId = -1;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, cartBean.getUserId());
			statement.setInt(2, cartBean.getTenantId());
			System.out.println(statement);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				orderId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		return orderId;
	}

	public List<CartItemsBean> getCartItems(Connection connection, int tenantId, int userId) {
		List<CartItemsBean> cartItemsList = new ArrayList<CartItemsBean>();
		CartItemsBean cartItemsBean = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(GET_ORDER);
			statement.setInt(1, tenantId);
			statement.setInt(2, userId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				/*
				 * " SELECT ORDER_DETAILS.ORDER_ID AS ORDER_ID,
				 * ORDER_DETAILS.USER_ID AS USER_ID, ORDER_ITEMS.ORDER_ITEM_ID
				 * AS ORDER_ITEM_ID, ORDER_ITEMS.PRODUCT_ID AS PRODUCT_ID,
				 * CAST(ORDER_ITEMS.COLUMN1 AS UNSIGNED) AS QUANTITY,
				 * CAST(PRODUCT.COLUMN3 AS DECIMAL(4,2)) AS PRICE, " + "
				 * CAST(ORDER_ITEMS.COLUMN1 AS UNSIGNED) * CAST(PRODUCT.COLUMN3
				 * AS DECIMAL(4,2)) AS AMOUNT,
				 * PRODUCT.COLUMN1,PRODUCT.COLUMN2,PRODUCT
				 * .COLUMN3,PRODUCT.COLUMN4
				 * ,PRODUCT.COLUMN5,PRODUCT.COLUMN6,PRODUCT.COLUMN7 " +
				 * " FROM ORDER_DETAILS INNER J" + "
				 */cartItemsBean = new CartItemsBean();
				cartItemsBean.setOrderId(resultSet.getInt("ORDER_ID"));
				cartItemsBean.setUserId(resultSet.getInt("USER_ID"));
				cartItemsBean.setOrderItemId(resultSet.getInt("ORDER_ITEM_ID"));
				cartItemsBean.setProductId(resultSet.getInt("PRODUCT_ID"));
				cartItemsBean.setQuantity(resultSet.getInt("QUANTITY"));
				cartItemsBean.setPrice(resultSet.getFloat("PRICE"));
				cartItemsBean.setAmount(resultSet.getFloat("AMOUNT"));
				cartItemsBean.setColumn1(resultSet.getString("COLUMN1"));
				cartItemsBean.setColumn2(resultSet.getString("COLUMN2"));
				cartItemsBean.setColumn3(resultSet.getString("COLUMN3"));
				cartItemsBean.setColumn4(resultSet.getString("COLUMN4"));
				if (null != resultSet.getString("COLUMN5") && (!"".equals(resultSet.getString("COLUMN5")))) {
					cartItemsBean.setColumn5(resultSet.getString("COLUMN5"));
				}
				if (null != resultSet.getString("COLUMN6") && (!"".equals(resultSet.getString("COLUMN6")))) {
					cartItemsBean.setColumn6(resultSet.getString("COLUMN6"));
				}
				if (null != resultSet.getString("COLUMN7") && (!"".equals(resultSet.getString("COLUMN7")))) {
					cartItemsBean.setColumn7(resultSet.getString("COLUMN7"));
				}
				cartItemsList.add(cartItemsBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		return cartItemsList;
	}
	
	public boolean updateOrderDetails(Connection connection, int orderId){
		boolean isSuccess = true;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_ORDER_STATUS);
			statement.setInt(1, orderId);
			System.out.println(statement);
			statement.executeUpdate();
			isSuccess = true;
			
			
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
