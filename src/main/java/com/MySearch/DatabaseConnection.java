package com.MySearch;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection connection = null;

    public static Connection getConnection() throws Exception {
        if(connection!=null) return connection;
        String user = "root";
        String password = "6954yes@pars";
        String db = "searchEngineApp";

        return getConnection(user,password,db);
    }

    private static Connection getConnection(String user, String password, String db) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+password);
        return connection;
    }
}
