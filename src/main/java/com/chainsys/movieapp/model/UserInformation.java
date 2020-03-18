package com.chainsys.movieapp.model;

public class UserInformation {
	private int userId;
	@Override
	public String toString() {
		return "UserInformation [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", gender=" + gender + "]";
	}
	private String userName;
	private String emailId;
	private String password;
	private Long mobileNumber;
	private String gender;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public String setEmailId(String emailId) {
		return this.emailId = emailId;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mobileNumber
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 * @return 
	 */
	public long setMobileNumber(Long mobileNumber) {
		return this.mobileNumber = mobileNumber;
	}
	
}
