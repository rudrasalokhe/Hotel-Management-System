package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Rudra
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
            // Corrected to 'Class' with an uppercase 'C'
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","23192319rudrasalokhe@#");
            return con;
        }
        catch(ClassNotFoundException | SQLException e){
            return null;
        }
}
}
