package ru.itis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "976017";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ja";
    //language=SQL
    private static final String SQL_SELECT_ALL_FROM_DRIVER = "select * from driver";
    
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);
        
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + " ");
            System.out.print(resultSet.getString("first_name") + " ");
            System.out.print(resultSet.getString("last_name") + " ");
            System.out.println(resultSet.getInt("age") + " ");
        }
    }
}
