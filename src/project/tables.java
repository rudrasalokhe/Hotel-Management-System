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

            // Drop the 'room' table if it exists
            st.executeUpdate("DROP TABLE IF EXISTS room");

            // Create 'room' table
            String sqlRoom = "CREATE TABLE IF NOT EXISTS room (" +
                             "roomNo VARCHAR(10), " +
                             "roomType VARCHAR(200), " +
                             "bed VARCHAR(200), " +
                             "price INT, " +
                             "status VARCHAR(20), " +
                             "booked BOOLEAN DEFAULT FALSE" +
                             ")";
            st.executeUpdate(sqlRoom);

            // Create 'customer' table
            String sqlCustomer = "CREATE TABLE IF NOT EXISTS customer (" +
                                 "id INT, " +
                                 "name VARCHAR(200), " +
                                 "mobileNumber VARCHAR(10), " +
                                 "aadharcard VARCHAR(20), " +
                                 "gender VARCHAR(50), " +
                                 "email VARCHAR(50),"+ 
                                 "address VARCHAR(500), " +
                                 "checkin VARCHAR(50), " +
                                 "roomNo VARCHAR(10), " +
                                 "bed VARCHAR(200), " +
                                 "roomType VARCHAR(20), " +
                                 "pricePerDay INT(10), " +
                                 "numberOfDaysStay INT(10), " +
                                 "totalAmount VARCHAR(200), " +
                                 "checkout VARCHAR(50)" +
                                 ")";
            st.executeUpdate(sqlCustomer);

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
