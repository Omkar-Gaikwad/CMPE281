package com.cmpe281.project.process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.connection.DatabaseConnection;
import com.cmpe281.project.persistent.ProductPersistent;

public class ProductProcess {
	public List<? extends ProductBean> getProductList(int tenantId) {
		Connection connection = DatabaseConnection.getConnection();
		List<? extends ProductBean> productList = null;
		
		try {
			if (!connection.isClosed()) {
				ProductPersistent productPersistent = new ProductPersistent();
				if(tenantId == 1){
					productList = productPersistent.getBookList(connection, tenantId);
				}
				if(tenantId == 2){
					productList = productPersistent.getMobileList(connection, tenantId);
				}
				if(tenantId == 3){
					productList = productPersistent.getCarList(connection, tenantId);
				}
				if(tenantId == 4){
					productList = productPersistent.getLaptopList(connection, tenantId);
				}
				if(tenantId == 5){
					productList = productPersistent.getSportsList(connection, tenantId);
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
		return productList;
	}
}
