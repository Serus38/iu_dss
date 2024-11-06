package com.mycompany.iu_dss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    
    private static final String URL = "jdbc:mysql://localhost:3306/iu_funcionarios";
    private static final String USER = "root";
    private static final String PASSWORD = "kaneki2238";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD); 
    }
}
