package com.scm.genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	
	Connection con=null;
	
	public void connectDB() throws Throwable {
		Driver driver=new  Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(Ipathconstants.DBURL, Ipathconstants.DB_Username, Ipathconstants.DB_Password);
	}

	public String executeandGetData(int colData,String ExpData, String query) throws Throwable{
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String actualprojectname = result.getString(1);
			
			if(actualprojectname.equals(ExpData)) {
				System.out.println("Project got created");
				flag=true;
				return ExpData;
			}
		}
		if(!flag) {
			System.out.println("project is not created");
		}
		return "";
	}
	

		
public void disconnect() throws Throwable {
	con.close();
}
	
}
			
		
		
		
	

