package com.cms;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mallika
 */

public class Connector {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String DBNAME = "remittance";
    private static Connector connector;
    private static Connection connection;

    private Connector() {
    }

    public synchronized static Connector getInstance() {
        if (connector == null) {
            connector = new Connector();
        }
        return connector;
    }

    public static Connection getConnection() {
        if (connection == null) {
            Connection c = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                c = DriverManager.getConnection(URL + DBNAME, LOGIN, PASSWORD);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return c;
        }
        return connection;
    }
}
