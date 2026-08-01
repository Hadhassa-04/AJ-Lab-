import java.sql.*;

public class UResultSet {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "testuser";
        String password = "testpass";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            Connection con = DriverManager.getConnection(url, user, password);

            // Create updatable and scrollable ResultSet
            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            // Execute query
            ResultSet rs = st.executeQuery("SELECT * FROM Student");

            // -------------------------
            // Delete the last row
            // -------------------------
            rs.last();
            rs.deleteRow();
            System.out.println("Last student record deleted successfully.");

            // -------------------------
            // Insert a new row
            // -------------------------
            rs.moveToInsertRow();
            rs.updateInt("RollNo", 105);
            rs.updateString("Name", "John Doe");
            rs.updateString("Address", "Hyderabad");
            rs.insertRow();
            System.out.println("New student record inserted successfully.");

            // Display updated table
            rs = st.executeQuery("SELECT * FROM Student");

            System.out.println("\nUpdated Student Table:");
            System.out.println("RollNo\tName\t\tAddress");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("RollNo") + "\t" +
                        rs.getString("Name") + "\t\t" +
                        rs.getString("Address"));
            }

            // Close resources
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
