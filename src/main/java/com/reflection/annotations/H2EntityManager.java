package com.reflection.annotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2EntityManager<T>  extends EntityManagerImpl<T>{
    public Connection buildConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:h2:value", "sa", "");
    }

}
