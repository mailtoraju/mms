package com.cusat.services;

import java.util.ArrayList;

import com.cusat.model.Customer;

public interface FsMappingService {
	public ArrayList<Customer> customerFsMapping(Customer customer);
	public void customerFoodEntery(Customer customer);
}
