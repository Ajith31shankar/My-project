package Travelmng;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import TravelMng1.Myconnection;

interface CutomerInfo {
	
	Scanner sc=new Scanner(System.in);
	
	
	default void signin(String username,String password) throws SQLException, FileNotFoundException, IOException
	{
	}
	
	
	default void signup() throws SQLException, FileNotFoundException, IOException
	{
		/*get customer firstname,lastname,emailid,phoneno,username,password */
		
		
		System.out.println("Enter first name");
		String fname=sc.next();
		System.out.println("Enter last name");
		String lname=sc.next();
		System.out.println("Enter email id");
		String email=sc.next();
		System.out.println("Enter phoneno");
		String phno=sc.next();
		System.out.println("Enter username");
		String uname=sc.next();
		System.out.println("Enter password");
		String pswd=sc.next();
		insertData(fname, lname, email, phno, uname, pswd);
		
	}
	default void insertData(String fname,String lname,String email,String phno,String uname,String pswd) throws SQLException, FileNotFoundException, IOException
	{
		Connection con=Myconnection.getMyconnection() ;
		PreparedStatement prst=con.prepareStatement("insert into customer (firstname,lastname,email,phoneno,username,password1)values(?,?,?,?,?,?) ");
		
		
		prst.setString(1,fname);
		prst.setString(2,lname);
		prst.setString(3,email);
		prst.setString(4,phno);
		prst.setString(5,uname);
		prst.setString(6,pswd);
		int n=prst.executeUpdate();
		System.out.println(n+"record updated");
		
		Booking b=new Booking();
		b.display();
		
	}
	


}
