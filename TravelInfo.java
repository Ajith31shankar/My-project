package Travelmng;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import TravelMng1.BusInfo;
import TravelMng1.Myconnection;

public class TravelInfo {

	Connection con;
	PreparedStatement prst;
	ResultSet rs;
	Scanner sc=new Scanner(System.in);
	
	public TravelInfo() throws FileNotFoundException, IOException, SQLException {
		con=Myconnection.getMyconnection();
		System.out.println("Connection Established");
	}
	
	public void setBus() throws SQLException{
		
		System.out.println("How many Information have to insert");
		int n=sc.nextInt();
		int p=0;
		
		
		for(int i=0;i<n;i++){
		System.out.println("Enter Bus No :");
		String Bno=sc.next();
		System.out.println("Enter Start Point :");
		String BSt=sc.next();
		System.out.println("Enter Destination Point :");
		String Bdt=sc.next();
		System.out.println("Enter Capacity");
		int cp=sc.nextInt();
		System.out.println("Enter Total Km :");
		int km=sc.nextInt();
		System.out.println("Enter time duration");
		sc.nextLine();
		String time=sc.next();
		System.out.println("price : ");
		int price=sc.nextInt();
		
		prst=con.prepareStatement("insert into businfo(bus_no,starting_point,destination_point,capacity,total_km,time,price) values(?,?,?,?,?,?,?)");
		
		prst.setString(1, Bno);
		prst.setString(2, BSt);
		prst.setString(3, Bdt);
		prst.setInt(4,cp);
		prst.setInt(5,km);
		prst.setString(6,time);
		prst.setInt(7,price);
		p=prst.executeUpdate();
		}
		
		System.out.println(" vlueas are updated");
		
		
		
		
	}
	
	 public void getBus(String St,String dt,String username,String password) throws SQLException
	 {
		 
	 }
	 public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		TravelInfo info=new TravelInfo();
		info.setBus();
	}
}