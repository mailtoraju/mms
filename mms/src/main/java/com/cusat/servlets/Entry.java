package com.cusat.servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cusat.model.Customer;
import com.cusat.model.CustomerFSMapping;
import com.cusat.services.FsMappingService;
import com.cusat.services.FsMappingServiceImpl;
import com.cusat.util.Utility;
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Entry() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email="anil@gmail.com";		
		String foodId1 =request.getParameter("food1");
		String foodId2 = request.getParameter("food2");
		String foodId3 = request.getParameter("food3");
		String entryDate=request.getParameter("entryDate");
		float extra=Float.parseFloat(request.getParameter("extra"));
		Customer customer=new Customer();
		CustomerFSMapping customerFSMapping=new CustomerFSMapping();
		customerFSMapping.setEmail(email);
		customerFSMapping.setFoodId1(foodId1);
		customerFSMapping.setFoodId2(foodId2);
		customerFSMapping.setFoodId3(foodId3);
		customerFSMapping.setExtra(extra);
		try {
			customerFSMapping.setDate(Utility.getDate(entryDate));
		} catch (ParseException e) {
			
			System.out.println(e);
			
		}
		customer.setCustomerFSMapping(customerFSMapping);
		FsMappingService fsMappingService=new FsMappingServiceImpl();
		fsMappingService.customerFoodEntery(customer);
		
		
		/*if(foodIds!=null)
		for(String food : foodIds)
		{
			System.out.println("Food1 : "+Integer.parseInt(food));
		}
		if(extra!=null)
			System.out.println("Extra2 : "+extra.toString());
		else 
			System.out.println("Extra1 : "+extra);*/
		/*if(foodIds!=null)
			System.out.println("Food : "+foodIds.length);*/
	}
}