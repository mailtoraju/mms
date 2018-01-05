package com.cusat.model;

public class Payment {
	private String email;
	private float paid;
	private float due;
	private int noOfDays;
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
	 * @return the paid
	 */
	public float getPaid() {
		return paid;
	}
	/**
	 * @param paid the paid to set
	 */
	public void setPaid(float paid) {
		this.paid = paid;
	}
	/**
	 * @return the due
	 */
	public float getDue() {
		return due;
	}
	/**
	 * @param due the due to set
	 */
	public void setDue(float due) {
		this.due = due;
	}
	/**
	 * @return the noOfDays
	 */
	public int getNoOfDays() {
		return noOfDays;
	}
	/**
	 * @param noOfDays the noOfDays to set
	 */
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

}
