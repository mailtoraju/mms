package com.cusat.dbconn;
import java.sql.*;
public class Test {
	public static void main(String []arg)	
	{
		String query="select * from personalinformation";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/messmanagement","root","root");
			System.out.println("Connection established");
			Statement stmt=con.createStatement();
			System.out.println("Statement Created.");
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				System.out.println("Name : "+rs.getString(1)+" Mobile : "+rs.getString(2)+" Email : "+rs.getString(3));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
