package com.hillel.filmlibrary.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectorDB {
    
    public static Connection getConnection() throws SQLException, NamingException {
        DataSource ds = (DataSource)(new InitialContext().lookup("java:comp/env/jdbc/FLSource"));
        return ds.getConnection();
    }

}
