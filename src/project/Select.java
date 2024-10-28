package project;

import java.sql.*;
import javax.swing.JOptionPane;

public class Select {

    public static ResultSet getData(String query) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;  // Returning the ResultSet, caller is responsible for closing it.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    // Utility method to close resources to prevent memory leaks
    public static void closeResources(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
        }
    }
}
