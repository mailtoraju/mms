package com.cusat.model;

import java.util.Date;

public class CustomerFsMappingView {
	private int  foodId;
	private boolean isAvailability;
	private float price;
	private Date date;
	/**
	 * @return the foodId
	 */
	public int getFoodId() {
		return foodId;
	}
	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	/**
	 * @return the isAvailability
	 */
	public boolean getIsAvailability() {
		return isAvailability;
	}
	/**
	 * @param isAvailability the isAvailability to set
	 */
	public void setIsAvailability(boolean isAvailability) {
		this.isAvailability = isAvailability;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
