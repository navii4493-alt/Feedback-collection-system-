
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Event Name: ");
        String event = sc.nextLine();

        System.out.print("Enter Rating (1-5): ");
        int rating = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Comments: ");
        String comments = sc.nextLine();

        String sql = "INSERT INTO feedback " +
          "(student_name,event_name,rating,comments) VALUES (?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return;
            }

            ps.setString(1, name);
            ps.setString(2, event);
            ps.setInt(3, rating);
            ps.setString(4, comments);

            ps.executeUpdate();

            System.out.println("Feedback Submitted Successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
