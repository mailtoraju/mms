package com.cusat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cusat.dbconn.DatabaseConnection;
import com.cusat.model.Customer;
import com.cusat.model.CustomerFsMappingView;

public class CustomerDao {
	
	public Customer customerProfile(Customer customer){
		Connection con = DatabaseConnection.getConnectivity();
	     String query = "select * from personalinformation where email_id = ? and password = ? and valid=?";
	     try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customer.getPersonalInformation().getEmail());
			ps.setString(2, customer.getPersonalInformation().getPassword());
			ps.setInt(3, 1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				//User user=new User();
				//personal details
				 customer.getPersonalInformation().setName(rs.getString("name"));
				 customer.getPersonalInformation().setMobile(rs.getString("mobile"));
				 customer.getPersonalInformation().setEmail(rs.getString("email"));
				 customer.getPersonalInformation().setPassword(rs.getString("password"));
				 customer.getPersonalInformation().setAddress(rs.getString("address"));
				
			}else{
				customer=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	
	public boolean customerLogin(Customer customer){		 
		   Connection con = DatabaseConnection.getConnectivity();
		   String query = "select * from personalinformation where email = ? and password = ? and valid=?";
		   boolean isValid=false;
		   try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customer.getPersonalInformation().getEmail());
			ps.setString(2, customer.getPersonalInformation().getPassword());
			ps.setInt(3, 1);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				customer.getPersonalInformation().setName(rs.getString("name"));
				isValid=true;				
			}
			} 
		   	catch (SQLException e)
		   	{
		   		e.printStackTrace();
		   	}
		   	return isValid;
	   }	   	  	
	   
	   public static ArrayList<Customer> customerFsMapping(Customer customer)	   
	   {
		   //customer="anil@gmail.com";
		   float price=0f;
		   ArrayList<Customer> al=new ArrayList<Customer>();
		  //CustomerFsMappingView cv=new CustomerFsMappingView();
		   String query="select * from userFsMapping where email=? limit 1,10";
		   Connection con=DatabaseConnection.getConnectivity();
		   int i=0;
		   try {
			PreparedStatement stmt=con.prepareStatement(query);
			//stmt.setString(1,"anil@gmail.com");//customer.getPersonalInformation().getEmail();
			stmt.setString(1,customer.getPersonalInformation().getEmail());
			ResultSet rs=stmt.executeQuery();			
			if(null!=rs)
			{
				while(rs.next())
				{
					CustomerFsMappingView cv=new CustomerFsMappingView();
					Customer cust=new Customer();
					cv.setFoodId(rs.getInt(2));
					cv.setIsAvailability(rs.getBoolean(3));
					cv.setPrice(rs.getFloat(4));
					cv.setDate(rs.getDate(5));
					cust.setCustomerFsMappingView(cv);
					al.add(cust);															
				}
			}
			else
				customer=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			  		 
		   return al;
		   
	   }
	   public Customer customerPaymentService(Customer customer)
	   {
		   Connection con = DatabaseConnection.getConnectivity();
		     String query = "select * from payment where email = ?";
		     PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(query);
				stmt.setString(1,customer.getPayment().getEmail());
								ResultSet rs=stmt.executeQuery();
				if(rs.next())
				{
					customer.getPayment().setDue(rs.getFloat("due"));
					customer.getPayment().setPaid(rs.getFloat("paid"));					
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}		     
		    return customer;
		     
	   }
	   public void customerFoodEntery(Customer customer)
	   {
		   Connection con = DatabaseConnection.getConnectivity();
		   try {
			   con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into userfsmapping values(?,?,?,?,?);");
			
			
			ps.setString(1,customer.getCustomerFSMapping().getEmail());
			ps.setInt(2,1);
			ps.setInt(3,customer.getCustomerFSMapping().getbAvailability());
			ps.setFloat(4,customer.getCustomerFSMapping().getBreakFastPrice());
			ps.setDate(5,new java.sql.Date(customer.getCustomerFSMapping().getDate().getTime()));
			ps.addBatch();
			
			ps.setString(1,customer.getCustomerFSMapping().getEmail());
			ps.setInt(2,2);
			ps.setInt(3,customer.getCustomerFSMapping().getlAvailability());
			ps.setFloat(3,customer.getCustomerFSMapping().getLunchPrice());
			ps.setDate(5,new java.sql.Date(customer.getCustomerFSMapping().getDate().getTime()));
			ps.addBatch();
			
			ps.setString(1,customer.getCustomerFSMapping().getEmail());
			ps.setInt(2,3);
			ps.setInt(3,customer.getCustomerFSMapping().getdAvailability());
			ps.setFloat(4,customer.getCustomerFSMapping().getDinnerPrice());
			ps.setDate(5,new java.sql.Date(customer.getCustomerFSMapping().getDate().getTime()));
			ps.addBatch();
			
			ps.setString(1,customer.getCustomerFSMapping().getEmail());
			ps.setInt(2,4);
			ps.setInt(3,customer.getCustomerFSMapping().geteAvailability());
			ps.setFloat(4,customer.getCustomerFSMapping().getExtra());
			ps.setDate(5,new java.sql.Date(customer.getCustomerFSMapping().getDate().getTime()));
			ps.addBatch();
			
			ps.executeBatch();
			con.commit();
			System.out.println("Record Successfully stored");
			
			
			
		} 
		catch (SQLException e)
		{			
			e.printStackTrace();
		}		
	}	  
}