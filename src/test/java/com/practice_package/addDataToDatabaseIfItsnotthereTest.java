package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class addDataToDatabaseIfItsnotthereTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println("enter the employee name");
		Scanner s=new Scanner(System.in);
		String n=s.next();
		  Driver driver=new  Driver();
		  DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52","root","Naradamuni@2");
		Statement state = con.createStatement();
		String query= "select name from emp_ifo;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;	
		while(result.next())
		{
			String name = result.getString(1);
			if(name.equalsIgnoreCase(n)) 
			{
				System.out.println(""+n+" is already added");
				flag=true;
				break;
			}
		}
			if(!flag) {
				Random r=new Random();
			int age = r.nextInt(100);
						String query1 ="insert into emp_ifo values('"+n+"',"+age+");";
						int result1 = state.executeUpdate(query1);
						if(result1==1) {
							System.out.println(""+n+" is added successfully");	
						}
						else {
							System.out.println(""+n+" is not added successfully");
						}
			}
			con.close();  
	}
}
