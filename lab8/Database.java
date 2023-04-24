package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "stefan1044";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection(){
        return connection;
    }
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void closeConnection() {
        try{
            connection.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
