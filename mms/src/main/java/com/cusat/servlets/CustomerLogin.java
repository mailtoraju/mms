package com.cusat.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cusat.model.Customer;
import com.cusat.model.PersonalInformation;
import com.cusat.services.CustomerService;
import com.cusat.services.CustomerServiceImpl;
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CustomerLogin() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw= response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		boolean isValid=false;
		Customer customer=new Customer();
		PersonalInformation pi=new PersonalInformation();
		pi.setEmail(email);
		pi.setPassword(password);
		customer.setPersonalInformation(pi);
		CustomerService customerService= new CustomerServiceImpl();
		isValid = customerService.customerLogin(customer);///userService.userLogin(user);
		String name=customer.getPersonalInformation().getName();
		//request.setAttribute("name", name);				
		if(isValid){	
			request.setAttribute("customer", customer);
			//request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);*/
			HttpSession session = request.getSession(true);			
			session.setAttribute("customer", customer);
			RequestDispatcher rd = request.getRequestDispatcher("access_user_fs_mapping_details");
			rd.forward(request,response);


		}else{
			request.setAttribute("invalid","Invalid User name or password.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
			//pw.print("FAILURE");
		}		
	}

}
