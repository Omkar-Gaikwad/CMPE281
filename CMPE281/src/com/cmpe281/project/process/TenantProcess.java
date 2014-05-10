package com.cmpe281.project.process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cmpe281.project.beans.AccessoriesBean;
import com.cmpe281.project.beans.LaptopAccessoryBean;
import com.cmpe281.project.beans.Reviews;
import com.cmpe281.project.beans.TenantBean;
import com.cmpe281.project.connection.DatabaseConnection;
import com.cmpe281.project.persistent.AccessoryPersistent;
import com.cmpe281.project.persistent.ReviewPersistent;
import com.cmpe281.project.persistent.TenantPersistant;

public class TenantProcess {
	public TenantBean getTenantDetails(String tenantName) {
		Connection connection = DatabaseConnection.getConnection();
		TenantBean tenantBean = null;

		try {
			if (!connection.isClosed()) {
				tenantBean = new TenantBean();
				TenantPersistant tenantPersistant = new TenantPersistant();
				tenantBean = tenantPersistant.getTenantId(connection, tenantName);
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
		return tenantBean;
	}

	public List<Reviews> getReviews(int bookId) {
		Connection connection = DatabaseConnection.getConnection();
		List<Reviews> reviewList = new ArrayList<Reviews>();
		try {
			if (!connection.isClosed()) {
				reviewList = new ReviewPersistent().getReviews(connection, bookId);
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
		return reviewList;
	}

	public AccessoriesBean getAccessories( int mobileId) {
		AccessoriesBean accessoriesBean = null;
		Connection connection = DatabaseConnection.getConnection();
		List<Reviews> reviewList = new ArrayList<Reviews>();
		try {
			if (!connection.isClosed()) {
				accessoriesBean = new AccessoryPersistent().getAccessories(connection, mobileId);
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
		return accessoriesBean;
	}
	
	public LaptopAccessoryBean getLaptopAccessories( int laptopId) {
		LaptopAccessoryBean accessoriesBean = null;
		Connection connection = DatabaseConnection.getConnection();
		
		try {
			if (!connection.isClosed()) {
				accessoriesBean = new AccessoryPersistent().getLaptopAccessory(connection, laptopId);
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
		return accessoriesBean;
	}
}
