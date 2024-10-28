package project;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rudra
 */
public class tables {
    public static void main(String args[]) {
    Connection con = null;
    Statement st = null;
    try {
        con = ConnectionProvider.getCon();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Failed to establish a database connection.");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Database connection established successfully.");
        }

        st = con.createStatement();

        // Drop the 'room' table if it exists, to recreate it with the correct schema
        st.executeUpdate("DROP TABLE IF EXISTS room");

        // SQL statement for creating the 'room' table with the 'booked' column
        String sqlRoom = "CREATE TABLE IF NOT EXISTS room ("
                + "roomNo VARCHAR(10), "
                + "roomType VARCHAR(200), "
                + "bed VARCHAR(200), "
                + "price INT, "
                + "status VARCHAR(20), "
                + "booked BOOLEAN DEFAULT FALSE)";
        st.executeUpdate(sqlRoom);

        JOptionPane.showMessageDialog(null, "Tables created successfully");

    } catch (SQLException sqlEx) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + sqlEx.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException closeEx) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + closeEx.getMessage());
        }
    }
}
}
