package Travelmng;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getConnection {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement prst;
		ResultSet rs;
		
		con=Myconnection.getMyconnection();

	}

}
