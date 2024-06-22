package hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_con {

	  private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
	    private static final String USER = "root"; 
	    private static final String PASSWORD = "adi@7654"; 

	    public static Connection getConnection() throws SQLException {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Connected to database.");
	        } catch (SQLException e) {
	            System.out.println("Error connecting to database: " + e.getMessage());
	        }
	        return conn;
	    }

	    public static void closeConnection(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.close();
	                System.out.println("Connection closed.");
	            } catch (SQLException e) {
	                System.out.println("Error closing connection: " + e.getMessage());
	            }
	        }
	    }
	}

