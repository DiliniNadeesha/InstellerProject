package lk.insteller.ems.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Using Singleton Design Pattern
public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPDB","root","1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static DBConnection getInstance(){
        return (dbConnection == null)? dbConnection = new DBConnection(): dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }

//    private static DBConnection dbConnection;
//    private Connection connection;
//
//    private DBConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPDB", "root", "1234");
//    }
//
//    public static DBConnection getInstance() throws Exception {
//
//        if (dbConnection==null){
//            dbConnection = new DBConnection();
//        }
//        return dbConnection;
//    }
//
//    public Connection getConnection(){
//        return connection;
//    }
}
