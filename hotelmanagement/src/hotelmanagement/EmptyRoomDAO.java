package hotelmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmptyRoomDAO {

    public void addEmptyRoom(int roomNumber) throws SQLException {
        Connection conn = database_con.getConnection();
        String sql = "INSERT INTO empty_rooms (room_number) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, roomNumber);
        statement.executeUpdate();
        conn.close();
    }

    public void displayAllEmptyRooms() throws SQLException {
        Connection conn = database_con.getConnection();
        String sql = "SELECT * FROM empty_rooms";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Room Number: " + resultSet.getInt("room_number"));
            System.out.println();
        }
        conn.close();
    }
}