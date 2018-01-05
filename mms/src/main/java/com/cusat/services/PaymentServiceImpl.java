package com.cusat.services;

import com.cusat.dao.CustomerDao;
import com.cusat.model.Customer;

public class PaymentServiceImpl  implements PaymentService{
	CustomerDao customerDao=new CustomerDao();
	public Customer customerPaymentService(Customer customer)
	{
		return customerDao.customerPaymentService(customer);
	}
}
