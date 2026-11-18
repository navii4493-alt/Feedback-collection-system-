import java.sql.*;

public class FeedbackService {

    public void addFeedback(String name, String event,
                            int rating, String comments) {

        String sql = "INSERT INTO feedback " +
            "(student_name,event_name,rating,comments) VALUES(?,?,?,?)";

        try (Connection con = DatabaseConnection.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, event);
            ps.setInt(3, rating);
            ps.setString(4, comments);

            ps.executeUpdate();
            System.out.println("Feedback submitted successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewFeedback() {
        String sql = "SELECT * FROM feedback";

        try (Connection con = DatabaseConnection.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("\nStudent: " +
                    rs.getString("student_name"));
                System.out.println("Event: " +
                    rs.getString("event_name"));
                System.out.println("Rating: " +
                    rs.getInt("rating"));
                System.out.println("Comments: " +
                    rs.getString("comments"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void summary() {
        String sql = "SELECT COUNT(*), AVG(rating) FROM feedback";

        try (Connection con = DatabaseConnection.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Total Feedback: " +
                    rs.getInt(1));
                System.out.println("Average Rating: " +
                    rs.getDouble(2));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}