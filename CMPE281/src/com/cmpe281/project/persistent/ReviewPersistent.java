package com.cmpe281.project.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cmpe281.project.beans.Reviews;
import com.cmpe281.project.connection.DatabaseConnection;

public class ReviewPersistent {
	private final String GET_REVIEWS = " SELECT * FROM REVIEWS WHERE BOOK_ID = ? ";

	public List<Reviews> getReviews(Connection connection, int bookId) {
		List<Reviews> reviewList = new ArrayList<Reviews>();
		Reviews reviews = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(GET_REVIEWS);
			statement.setInt(1, bookId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reviews = new Reviews();
				reviews.setReviewId(resultSet.getInt(1));
				reviews.setBookId(resultSet.getInt(2));
				reviews.setUserName(resultSet.getString(3));
				reviews.setReview(resultSet.getString(4));
				reviews.setRating(resultSet.getFloat(5));
				reviewList.add(reviews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeConnection(statement, resultSet);
		}		
		return reviewList;
	}
}
