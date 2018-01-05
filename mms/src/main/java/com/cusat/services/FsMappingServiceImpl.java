package com.cusat.services;

import java.util.ArrayList;

import com.cusat.dao.CustomerDao;
import com.cusat.model.Customer;
import com.cusat.model.CustomerFSMapping;

public class FsMappingServiceImpl implements FsMappingService{
	CustomerDao customerDao=new CustomerDao();
	public ArrayList<Customer> customerFsMapping(Customer customer)
	{
		ArrayList<Customer> al=customerDao.customerFsMapping(customer);
		
		return al;
	}
	public void customerFoodEntery(Customer customer)
	{
		CustomerFSMapping cfm=new CustomerFSMapping();
		String email=cfm.getEmail();
		if(customer.getCustomerFSMapping().getFoodId1()!=null)
		{
			customer.getCustomerFSMapping().setbAvailability(1);
			customer.getCustomerFSMapping().setBreakFastPrice(17.0f);
		}
		else
		{
			customer.getCustomerFSMapping().setbAvailability(0);
			customer.getCustomerFSMapping().setBreakFastPrice(0.0f);
		}
		if(customer.getCustomerFSMapping().getFoodId2()!=null)
		{
			customer.getCustomerFSMapping().setlAvailability(1);
			customer.getCustomerFSMapping().setLunchPrice(35.0f);			
		}
		else
		{
			customer.getCustomerFSMapping().setlAvailability(0);
			customer.getCustomerFSMapping().setLunchPrice(0.0f);
		}
		if(customer.getCustomerFSMapping().getFoodId3()!=null)
		{
			customer.getCustomerFSMapping().setdAvailability(1);
			customer.getCustomerFSMapping().setDinnerPrice(35.0f);
		}
		else
		{
			customer.getCustomerFSMapping().setdAvailability(0);
			customer.getCustomerFSMapping().setDinnerPrice(0.0f);
		}
		if(customer.getCustomerFSMapping().getExtra()>0.0f)
		{
			customer.getCustomerFSMapping().seteAvailability(1);
			customer.getCustomerFSMapping().setExtra(customer.getCustomerFSMapping().getExtra());
		}
		else
		{
			customer.getCustomerFSMapping().seteAvailability(0);
			customer.getCustomerFSMapping().setExtra(0.0f);
		}
		
		customerDao.customerFoodEntery(customer);
	}
}