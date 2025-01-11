package Jframe;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    static Connection con = null;
    
    public static Connection getConnection(){      
        try {
            // load Driver class.
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library_ms", "root", "");       
        } catch (Exception e) {
            e.printStackTrace();
        }
    return con;
    }   
}
