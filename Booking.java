package Travelmng;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import TravelMng1.Myconnection;

public class Booking extends TravelInfo implements CutomerInfo {

	int ex_c;
	Scanner sc = new Scanner(System.in);

	public Booking() throws FileNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void signin(String username, String password) throws SQLException, FileNotFoundException, IOException {
		Connection con = Myconnection.getMyconnection();
		PreparedStatement prst = con.prepareStatement("select * from customer where username = ? and password1= ?");
		prst.setString(1, username);
		prst.setString(2, password);
		ResultSet rs = prst.executeQuery();

		try{
		if (rs.next()) {
			String username1 = username;
			String password1 = password;
			System.out.println("Hello...! Have a Grate Ride...!");
			prst=con.prepareStatement("select starting_point,destination_point from businfo");
			rs=prst.executeQuery();
			System.out.println("Service Locations are :-");
			while(rs.next())
			{
				
				System.out.println(rs.getString(1)+ " to "+rs.getString(2));
			}
			System.out.println("Enter Starting Point :");
			String st = sc.next();
			System.out.println("Enter Destination Point :");
			String dt = sc.next();
			getBus(st, dt, username1, password1);

		}
		else{
			System.out.println("User id and password not present");
			System.out.println("Enter vaild username and password");
			System.out.println("do you have to create acoount press 1 or press 0 ");
			int up = sc.nextInt();
			if (up == 1) {
				signup();
			} else {
				System.out.println("Thank you for visiting!");
			}
			
		}
		}catch(Exception e) {
			
		}

	}

	public void getBus(String St, String dt, String username, String password) throws SQLException {

		prst = con.prepareStatement("select * from businfo where starting_point=? and destination_point=? ");
		prst.setString(1, St);
		prst.setString(2, dt);
		rs = prst.executeQuery();

		if (rs.next()) {
			System.out.println("Select !");
			System.out.println("Single   : 1");
			System.out.println("Double   : 2");
			System.out.println("For more : 3 ");
			int num = sc.nextInt();
			switch (num) {
			case 1:

				prst = con.prepareStatement(
						"select firstname,lastname,email,phoneno from customer where username = ? and password1= ?");
				prst.setString(1, username);
				prst.setString(2, password);
				rs = prst.executeQuery();
				while (rs.next()) {
					System.out.println("------------------------------------------");
					System.out.println("Date:-   " + LocalDate.now());
					System.out.println("Name     :" + rs.getString(1) + "" + rs.getString(2));
					System.out.println("Email Id :" + rs.getString(3));
					System.out.println("Phone No :" + rs.getString(4));
					System.out.println("------------------------------------------");
				}

				prst = con.prepareStatement(
						"select bus_no,starting_point,destination_point,total_km,time,price from businfo where starting_point=? and destination_point=? ");
				prst.setString(1, St);
				prst.setString(2, dt);
				rs = prst.executeQuery();
				while (rs.next()) {
					System.out.println("Bus No         : " + rs.getString(1));
					System.out.println("Starting Point : " + rs.getString(2));
					System.out.println("Ending Point   : " + rs.getString(3));
					System.out.println("Time Duration  : " + rs.getString(5));
					System.out.println("Total Km       : " + rs.getInt(4) + "km");
					System.out.println("Seats          : " + "1");
					System.out.println("------------------------------------------");
					System.out.println("Price          : " + rs.getInt(6)+"/-");
					System.out.println("------------------------------------------");
				}

				break;
			case 2:
				prst = con.prepareStatement(
						"select firstname,lastname,email,phoneno from customer where username = ? and password1= ?");
				prst.setString(1, username);
				prst.setString(2, password);
				rs = prst.executeQuery();
				while (rs.next()) {
					System.out.println("------------------------------------------");
					System.out.println("Date:-   " + LocalDate.now());
					System.out.println("Name     :" + rs.getString(1) + "" + rs.getString(2));
					System.out.println("Email Id :" + rs.getString(3));
					System.out.println("Phone No :" + rs.getString(4));
					System.out.println("------------------------------------------");
				}

				prst = con.prepareStatement(
						"select bus_no,starting_point,destination_point,total_km,time,price from businfo where starting_point=? and destination_point=? ");
				prst.setString(1, St);
				prst.setString(2, dt);
				rs = prst.executeQuery();
				while (rs.next()) {
					System.out.println("Bus No         : " + rs.getString(1));
					System.out.println("Starting Point : " + rs.getString(2));
					System.out.println("Destination    : " + rs.getString(3));
					System.out.println("Time Duration  : " + rs.getString(5));
					System.out.println("Total Km       : " + rs.getInt(4));
					System.out.println("Seats          : " + "2");
					int price = rs.getInt(6);
					System.out.println("------------------------------------------");
					System.out.println("Price          : " + price + "x2 = " + price * 2+"/-");
					System.out.println("------------------------------------------");
				}

				break;
			case 3:
				System.out.println("Enter how many member");
				int n = sc.nextInt();
				prst = con.prepareStatement(
						"select firstname,lastname,email,phoneno from customer where username = ? and password1= ?");
				prst.setString(1, username);
				prst.setString(2, password);
				rs = prst.executeQuery();
				while (rs.next()) {
					System.out.println("------------------------------------------");
					System.out.println("Date:-   " + LocalDate.now());
					System.out.println("Name     :" + rs.getString(1) + "" + rs.getString(2));
					System.out.println("Email Id :" + rs.getString(3));
					System.out.println("Phone No :" + rs.getString(4));
					System.out.println("------------------------------------------");
				}

				prst = con.prepareStatement(
						"select bus_no,starting_point,destination_point,total_km,time,price from businfo where starting_point=? and destination_point=? ");
				prst.setString(1, St);
				prst.setString(2, dt);
				rs = prst.executeQuery();
				while (rs.next()) {
					System.out.println("Bus No         : " + rs.getString(1));
					System.out.println("Starting Point : " + rs.getString(2));
					System.out.println("Destination    : " + rs.getString(3));
					System.out.println("Time Duration  : " + rs.getString(5));
					System.out.println("Total Km       : " + rs.getInt(4));
					System.out.println("Seats          : " + n);
					int price = rs.getInt(6);
					System.out.println("------------------------------------------");
					System.out.println("Price          : " + price + "x" + n + " = " + price * n+"/-");
					System.out.println("------------------------------------------");
				}

				break;

			default:
				break;
			}
		} else {
			System.out.println("Sorry ! for inconvenience...");
			System.out.println("Service not available for this location");
		}
	}
	public void display() throws FileNotFoundException, SQLException, IOException{
		
		System.out.println("Sign In :    1");
		System.out.println("Sign Up :    2");
		int key = sc.nextInt();
		switch (key) {
		case 1:
			System.out.println("Enter Username:-");
			String user = sc.next();
			System.out.println("Enter Password:-");
			String pass = sc.next();
			signin(user, pass);
			break;
		case 2:
			signup();

			break;

		default:
			System.out.println("Please! Enter Correct option!");
			break;
		}
	}
	
		
	

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		Booking info = new Booking();
		System.out.println(
				"---------------------------------------WELCOME!-----------------------------------------------");
		System.out.println(
				"                               TRAVEL MANAGMENT SYSTEM                                        ");
		info.display();
		
	}
}
