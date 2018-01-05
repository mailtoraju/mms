package com.cusat.model;

public class Customer {
	private PersonalInformation personalInformation;
	private Payment payment;
	private CustomerFsMappingView customerFsMappingView;
	private CustomerFSMapping customerFSMapping;
	
	/**
	 * @return the customerFSMapping
	 */
	public CustomerFSMapping getCustomerFSMapping() {
		return customerFSMapping;
	}


	/**
	 * @param customerFSMapping the customerFSMapping to set
	 */
	public void setCustomerFSMapping(CustomerFSMapping customerFSMapping) {
		this.customerFSMapping = customerFSMapping;
	}


	/**
	 * @return the customerFsMappingView
	 */
	public CustomerFsMappingView getCustomerFsMappingView() {
		return customerFsMappingView;
	}


	/**
	 * @param customerFsMappingView the customerFsMappingView to set
	 */
	public void setCustomerFsMappingView(CustomerFsMappingView customerFsMappingView) {
		this.customerFsMappingView = customerFsMappingView;
	}


	public Payment getPayment() {
		return payment;
	}

	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

}
