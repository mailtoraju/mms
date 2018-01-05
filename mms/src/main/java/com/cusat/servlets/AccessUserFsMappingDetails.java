package com.cusat.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cusat.model.Customer;
import com.cusat.model.CustomerFSMapping;
import com.cusat.model.CustomerFsMappingView;
import com.cusat.model.Payment;
import com.cusat.model.PersonalInformation;
import com.cusat.services.FsMappingService;
import com.cusat.services.FsMappingServiceImpl;
import com.cusat.services.PaymentService;
import com.cusat.services.PaymentServiceImpl;

public class AccessUserFsMappingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email="anil@gmail.com";
		ArrayList<Customer> al=new ArrayList<Customer>();			
		Customer customer=new Customer();
		PersonalInformation pi=new PersonalInformation();
		pi.setEmail(email);		
		customer.setPersonalInformation(pi);
		FsMappingService fms=new FsMappingServiceImpl();
		al=fms.customerFsMapping(customer);
		
		Customer cust=new Customer();
		Payment payment=new Payment();
		payment.setEmail(email);
		cust.setPayment(payment);
		PaymentService customerService=new PaymentServiceImpl();
		cust=customerService.customerPaymentService(cust);
		
		request.setAttribute("dues", cust.getPayment().getDue());
		request.setAttribute("paid", cust.getPayment().getPaid());
		
		//request.setAttribute("customer",cust);
		
		request.setAttribute("list", al);
		request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
		
		//response.sendRedirect("success.jsp?user="+user); 
		//response.sendRedirect("AfterLogin.jsp");
		//System.out.println("Due : "+cust.getPayment().getDue()+" Paid : "+cust.getPayment().getPaid());
	}
	/*void myFunction()
	{
		String email="anil@gmail.com";
		Customer cust=new Customer();
		Payment payment=new Payment();
		payment.setEmail(email);
		cust.setPayment(payment);
		PaymentService customerService=new PaymentServiceImpl();
		cust=customerService.customerPaymentService(cust);
		System.out.println("Due : "+cust.getPayment().getDue()+" Paid : "+cust.getPayment().getPaid());
	}
	public static void main(String []ar)
	{
		new AccessUserFsMappingDetails().myFunction();
	}*/
}