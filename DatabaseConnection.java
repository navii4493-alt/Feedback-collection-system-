
import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/feedback_db",
                "root",
                "YOUR_PASSWORD"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
