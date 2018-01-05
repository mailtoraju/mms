package com.cusat.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	private static final String MM_DD_YYYY = "MM/dd/yyyy";  

	public static Date getDate(String strDate) throws ParseException{
		DateFormat  formater= new SimpleDateFormat(MM_DD_YYYY);
		Date date = formater.parse(strDate);
		return date;
		
	}
}
