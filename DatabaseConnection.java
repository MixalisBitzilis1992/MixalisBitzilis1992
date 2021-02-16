import com.mysql.jdbc.JDBC4Connection;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    private Connection connection;

    public Connection getConn(){
        return this.connection;
    }
    public void setConn(Connection conn){
        this.connection=connection;
    }

    public Connection getConnection() throws Exception {
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/my_personel?autoReconnect=true&useSSL=false", "root", "9K(c6)Eg");
            Statement stmt = connection.createStatement();
            connection.setAutoCommit(false);
            System.out.println("You set up the database connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}


