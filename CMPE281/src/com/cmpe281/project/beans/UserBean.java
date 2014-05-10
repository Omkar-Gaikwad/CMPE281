package com.cmpe281.project.beans;

public class UserBean {
	int userId;
	String email;
	String userPassword;
	String firstName;
	String lastName;

	public UserBean(String email, String password, String firstName, String lastName) {
		this.email = email;
		this.userPassword = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserBean() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
