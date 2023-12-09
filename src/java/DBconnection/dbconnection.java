/*
connects to database flight_tic
 */
package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class dbconnection {
    public static Connection getConnectToflight_tic() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=null;
        String url="jdbc:mysql://localhost:3306/";
        String dbName="flight_tic";
        String userName="root";
        String password="root123";
        con=DriverManager.getConnection(url+dbName,userName,password);
        return con;
    }
    
}
