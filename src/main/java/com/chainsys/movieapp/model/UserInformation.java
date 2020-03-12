package com.chainsys.movieapp.model;

public class UserInformation {
	private int userId;
	private String userName;
	private String emailId;
	private String epassword;
	private Long mobileNum;
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
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public long setMobileNum(Long mobileNum) {
		return this.mobileNum = mobileNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
