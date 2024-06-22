package hotelmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO {

    public void addRoom(int roomNumber, String roomType) throws SQLException {
        Connection conn = database_con.getConnection();
        String sql = "INSERT INTO rooms (room_number, room_type) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, roomNumber);
        statement.setString(2, roomType);
        statement.executeUpdate();
        conn.close();
    }

    public void displayAllRooms() throws SQLException {
        Connection conn = database_con.getConnection();
        String sql = "SELECT * FROM rooms";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Room Number: " + resultSet.getInt("room_number"));
            System.out.println("Room Type: " + resultSet.getString("room_type"));
            System.out.println();
        }
        conn.close();
    }
}
