package Travelmng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Myconnection {
	static Connection con;
	
	public static Connection getMyconnection() throws FileNotFoundException, IOException, SQLException
	{
		if(con==null)
		{
			Properties p= new Properties();
			p.load(new FileInputStream(new File("C:\\Users\\Admin\\workspace\\TravelManagmentSystem\\src\\TravelMng1\\db.properties")));
			String url=p.getProperty("url");
			String user=p.getProperty("user");
			String password=p.getProperty("password");
			
			con=DriverManager.getConnection(url,user,password);
			
			return con;
		}
			else
			{
				return con;
			}
			       
			
		}
	}


