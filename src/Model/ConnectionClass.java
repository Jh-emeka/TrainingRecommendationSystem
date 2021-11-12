package Model;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionClass {

    public static final String DB_URL = "jdbc:sqlite:files\\Training Sessions.db";
    public static final String DB_USERNAME = "";
    public static final String DB_PASSWORD = "";


    public static java.sql.Connection getConnection() throws SQLException {
        java.sql.Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        System.out.println("Connection to SQLite has been established.");
        return conn;
    }

}

