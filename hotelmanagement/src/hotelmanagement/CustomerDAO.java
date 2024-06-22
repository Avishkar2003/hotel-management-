package hotelmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    
    public void addCustomer(String name, String contact) throws SQLException {
        Connection conn = database_con.getConnection();
        String sql = "INSERT INTO customers (name, contact) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, contact);
        statement.executeUpdate();
        conn.close();
    }

    public void displayAllCustomers() throws SQLException {
        Connection conn = database_con.getConnection();
        String sql = "SELECT * FROM customers";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Contact: " + resultSet.getString("contact"));
            System.out.println();
        }
        conn.close();
    }
}
