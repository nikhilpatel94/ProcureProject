package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class nonselectquery {
	
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		int result=0;
		try {
			
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet152","root","Naradamuni@2");
		Statement state = con.createStatement();
		String query = "insert into emploee_info values('joy','1234567898',26);";
		 result = state.executeUpdate(query);
		if(result==1) {
			System.out.println("data is succesfully added");
			}
		else {
			System.out.println("data is not updated");}
		}
		
		catch (Exception e) {
			}
		finally {
			con.close();
		}
		
	}

}

