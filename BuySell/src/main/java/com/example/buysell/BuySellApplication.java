package com.example.buysell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SpringBootApplication
public class BuySellApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuySellApplication.class, args);
    }


    public class MySQLJDBCExample {

        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/shopsell";
            String username = "root";
            String password = "ivandubinin";

            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to MySQL database!");
            } catch (SQLException e) {
                throw new RuntimeException("Cannot connect to the database!", e);
            }
        }
    }

}
