package hotelmanagement;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("Hotel Management System");
                System.out.println("1. Add Customer");
                System.out.println("2. Add Room");
                System.out.println("3. Add Empty Room");
                System.out.println("4. Display All Customers");
                System.out.println("5. Display All Rooms");
                System.out.println("6. Display All Empty Rooms");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        addRoom();
                        break;
                    case 3:
                        addEmptyRoom();
                        break;
                    case 4:
                        displayAllCustomers();
                        break;
                    case 5:
                        displayAllRooms();
                        break;
                    case 6:
                        displayAllEmptyRooms();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addCustomer() throws SQLException {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer contact: ");
        String customerContact = scanner.nextLine();

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.addCustomer(customerName, customerContact);
    }

    private static void addRoom() throws SQLException {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter room type: ");
        String roomType = scanner.next();
        scanner.nextLine(); // Consume newline

        RoomDAO roomDAO = new RoomDAO();
        roomDAO.addRoom(roomNumber, roomType);
    }

    private static void addEmptyRoom() throws SQLException {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EmptyRoomDAO emptyRoomDAO = new EmptyRoomDAO();
        emptyRoomDAO.addEmptyRoom(roomNumber);
    }

    private static void displayAllCustomers() throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.displayAllCustomers();
    }

    private static void displayAllRooms() throws SQLException {
        RoomDAO roomDAO = new RoomDAO();
        roomDAO.displayAllRooms();
    }

    private static void displayAllEmptyRooms() throws SQLException {
        EmptyRoomDAO emptyRoomDAO = new EmptyRoomDAO();
        emptyRoomDAO.displayAllEmptyRooms();
    }
}
