package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cmpe281.project.beans.TenantBean;
import com.cmpe281.project.connection.DatabaseConnection;

public class TenantPersistant {
	private final String TENANT_ID = " SELECT TENANT_ID FROM TENANT WHERE TENANT_NAME = ? OR TENANT_NAME = ? ";

	public TenantBean getTenantId(Connection connection, String tenant) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		TenantBean tenantBean = null;
		try {
			statement = connection.prepareStatement(TENANT_ID);
			statement.setString(1, tenant.toLowerCase());
			statement.setString(2, tenant.toUpperCase());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				tenantBean = new TenantBean();
				tenantBean.setTenantId(resultSet.getInt("TENANT_ID"));
				tenantBean.setTenantName(tenant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		return tenantBean;
	}
}
