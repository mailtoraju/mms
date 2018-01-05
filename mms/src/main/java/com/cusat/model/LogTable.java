package com.cusat.model;

public class LogTable {
	private String email;
	private String ipAddress;
	private String loginTime;
	private String logOutTime;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the loginTime
	 */
	public String getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the logOutTime
	 */
	public String getLogOutTime() {
		return logOutTime;
	}
	/**
	 * @param logOutTime the logOutTime to set
	 */
	public void setLogOutTime(String logOutTime) {
		this.logOutTime = logOutTime;
	}
}
