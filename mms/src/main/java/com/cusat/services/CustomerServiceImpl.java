package com.cusat.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cusat.dao.CustomerDao;
import com.cusat.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao = new CustomerDao();
		
	/*public Customer customerProfile(Customer customer) {
		Customer c = customerDao.customerProfile(customer);
		if (null == customer) {
			//c.getPersonalInformation().setValid(0);
			c.getPersonalInformation().setValid(0);
		}
		return c;
	}*/

	public boolean customerLogin(Customer customer) {
		//Customer cust = null;
		boolean isValid=false;
		isValid = customerDao.customerLogin(customer);
		/*if (isValid) {
			customer.getPersonalInformation().getName();
			//cust = customer;
		}*/
		return isValid;
	}

}