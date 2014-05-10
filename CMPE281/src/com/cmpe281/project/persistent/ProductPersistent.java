package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cmpe281.project.beans.BookBean;
import com.cmpe281.project.beans.CarBean;
import com.cmpe281.project.beans.LaptopBean;
import com.cmpe281.project.beans.MobileBean;
import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.beans.SportsBean;
import com.cmpe281.project.connection.DatabaseConnection;

public class ProductPersistent {
	private final String BOOK_LIST = " SELECT TENANT_ID, ROW_ID,COLUMN1,COLUMN2,COLUMN3,COLUMN4,COLUMN5 FROM PRODUCT WHERE TENANT_ID = ?";
	private final String MOBILE_LIST = " SELECT TENANT_ID, ROW_ID,COLUMN1,COLUMN2,COLUMN3,COLUMN4,COLUMN5,COLUMN6 FROM PRODUCT WHERE TENANT_ID = ? ";
	private final String LAPTOP_LIST = " SELECT TENANT_ID, ROW_ID,COLUMN1,COLUMN2,COLUMN3,COLUMN4,COLUMN5,COLUMN6 FROM PRODUCT WHERE TENANT_ID = ? ";
	private final String CAR_LIST = " SELECT TENANT_ID, ROW_ID,COLUMN1,COLUMN2,COLUMN3,COLUMN4,COLUMN5,COLUMN6,COLUMN6 FROM PRODUCT WHERE TENANT_ID = ? ";
	private final String UPDATE_PRODUCT_QUANTITY = " UPDATE PRODUCT AS PROD INNER JOIN ORDER_ITEMS  AS ITEM ON PROD.ROW_ID = ITEM.PRODUCT_ID  SET PROD.COLUMN4 = CAST( (CAST(PROD.COLUMN4 AS UNSIGNED) - CAST(ITEM.COLUMN1 AS UNSIGNED)) AS CHAR(100)) WHERE ORDER_ID = ? ";
	
	public List<? extends ProductBean> getBookList(Connection connection, int tenantId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<BookBean> bookList = new ArrayList<BookBean>();
		BookBean bookBean = null;
		try {
			statement = connection.prepareStatement(BOOK_LIST);
			statement.setInt(1, tenantId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				bookBean = new BookBean();
				bookBean.setTenantId(tenantId);
				bookBean.setBookId(resultSet.getInt("ROW_ID"));
				bookBean.setBookName(resultSet.getString("COLUMN1"));
				bookBean.setAuthor(resultSet.getString("COLUMN2"));
				bookBean.setPrice(Float.parseFloat(resultSet.getString("COLUMN3")));
				bookBean.setQuantity(Integer.parseInt(resultSet.getString("COLUMN4")));
				bookList.add(bookBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		List<? extends ProductBean> productList = bookList;
		return productList;
	}

	public List<? extends ProductBean> getMobileList(Connection connection, int tenantId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<MobileBean> mobileList = new ArrayList<MobileBean>();
		MobileBean mobileBean = null;
		try {
			statement = connection.prepareStatement(MOBILE_LIST);
			statement.setInt(1, tenantId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				mobileBean = new MobileBean();
				mobileBean.setTenantId(tenantId);
				mobileBean.setMobileId(resultSet.getInt("ROW_ID"));
				mobileBean.setBrandName(resultSet.getString("COLUMN1"));
				mobileBean.setMobileName(resultSet.getString("COLUMN2"));
				mobileBean.setPrice(Float.parseFloat(resultSet.getString("COLUMN3")));
				mobileBean.setQuantity(Integer.parseInt(resultSet.getString("COLUMN4")));
				mobileBean.setOperatingSystem(resultSet.getString("COLUMN5"));
				mobileList.add(mobileBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		List<? extends ProductBean> productList = mobileList;
		return productList;
	}

	public List<? extends ProductBean> getCarList(Connection connection, int tenantId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<CarBean> carList = new ArrayList<CarBean>();
		CarBean carBean = new CarBean();
		try {
			statement = connection.prepareStatement(CAR_LIST);
			statement.setInt(1, tenantId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				carBean = new CarBean();
				carBean.setTenantId(tenantId);
				carBean.setCarId(resultSet.getInt("ROW_ID"));
				carBean.setBrandName(resultSet.getString("COLUMN1"));
				carBean.setCarName(resultSet.getString("COLUMN2"));
				carBean.setPrice(Float.parseFloat(resultSet.getString("COLUMN3")));
				carBean.setQuantity(Integer.parseInt(resultSet.getString("COLUMN4")));
				carBean.setType(resultSet.getString("COLUMN5"));
				carBean.setColor(resultSet.getString("COLUMN6"));
				carList.add(carBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		List<? extends ProductBean> productList = carList;
		return productList;
	}
	
	public boolean updateQuantity(Connection connection, int orderId){
		boolean isSuccess = true;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_PRODUCT_QUANTITY);
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
	public List<? extends ProductBean> getLaptopList(Connection connection, int tenantId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<LaptopBean> laptopList = new ArrayList<LaptopBean>();
		LaptopBean laptopBean = null;
		try {
			statement = connection.prepareStatement(MOBILE_LIST);
			statement.setInt(1, tenantId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				laptopBean = new LaptopBean();
				laptopBean.setTenantId(tenantId);
				laptopBean.setLaptopId(resultSet.getInt("ROW_ID"));
				laptopBean.setBrandName(resultSet.getString("COLUMN1"));
				laptopBean.setLaptopName(resultSet.getString("COLUMN2"));
				laptopBean.setPrice(Float.parseFloat(resultSet.getString("COLUMN3")));
				laptopBean.setQuantity(Integer.parseInt(resultSet.getString("COLUMN4")));
				laptopBean.setOperatingSystem(resultSet.getString("COLUMN5"));
				laptopList.add(laptopBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		List<? extends ProductBean> productList = laptopList;
		return productList;
	}

	public List<? extends ProductBean> getSportsList(Connection connection, int tenantId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<SportsBean> sportsList = new ArrayList<SportsBean>();
		SportsBean sportsBean = null;
		try {
			statement = connection.prepareStatement(MOBILE_LIST);
			statement.setInt(1, tenantId);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				sportsBean = new SportsBean();
				sportsBean.setTenantId(tenantId);
				sportsBean.setItemId(resultSet.getInt("ROW_ID"));
				sportsBean.setBrandName(resultSet.getString("COLUMN1"));
				sportsBean.setItemName(resultSet.getString("COLUMN2"));
				sportsBean.setPrice(Float.parseFloat(resultSet.getString("COLUMN3")));
				sportsBean.setQuantity(Integer.parseInt(resultSet.getString("COLUMN4")));
				sportsBean.setSports(resultSet.getString("COLUMN5"));
				sportsList.add(sportsBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}
		List<? extends ProductBean> productList = sportsList;
		return productList;
	}

}
