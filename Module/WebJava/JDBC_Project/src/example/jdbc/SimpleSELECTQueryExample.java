package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			// Establish Connection
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zomato", "root", "root");
			System.out.println("Connected");
			
			// Obtain some Statement
			 stmt = con.createStatement();
			
			// Execute SQL Query
			 rs = stmt.executeQuery("select rest_name,rest_branch_count,rest_cuisine from restaurant_master");
			
			// In case obtain ResultSet 
			while(rs.next()) {
				System.out.println("Restaurant name: "+rs.getString(1)+", Rastuant Count: "+rs.getInt(2)+", Restaurant Cuisin: "+rs.getString(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		
	}

}
