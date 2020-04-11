package com.reflection.annotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Provider {
    @Provides
    public Connection buildConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:h2:/Users/alexandrelloret/Documents/Java/practice/demo/db-files/db", "sa", "");
    }
}
