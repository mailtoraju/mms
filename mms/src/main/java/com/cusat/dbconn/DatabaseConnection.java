package com.cusat.dbconn;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	static Properties properties = new Properties();
	
	private static Connection con = null;
	
		
	static {
		try{
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream("db.properties") ;
			properties.load(resourceStream);
			
			
			Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
			System.out.println("Driver loaded");
		} catch (Exception e){
			
			System.out.println("Class not loaded "+e);
		}	
	}
	public static Connection getConnectivity(){
		try {
			if(null==con){			
				con = DriverManager.getConnection(properties.getProperty("DB_URL"), 
						properties.getProperty("DB_USERNAME"),
						properties.getProperty("DB_PASSWORD"));
			}
			System.out.println("connection successful"); 
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database." +e);
		}
		System.out.println(con +"-------------------"+con.hashCode());
		return con;
	}
	public static void closeConnectivity() {
		try{
			con.close();
		}catch(SQLException e){
			System.out.println("Connection not closed "+ e);
		}
		
	}
	public static void main(String args[]){
		getConnectivity();
	}
}
