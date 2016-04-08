/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.utilities;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class DatabaseUtilities {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            Properties properties = new Properties();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream("database.properties");
                properties.load(inputStream);

                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser(properties.getProperty("username"));
                dataSource.setPassword(properties.getProperty("password"));
                dataSource.setServerName(properties.getProperty("host"));
                dataSource.setPort(Integer.valueOf(properties.getProperty("port")));
                dataSource.setDatabaseName(properties.getProperty("database"));
                connection = dataSource.getConnection();
                inputStream.close();
            } catch (SQLException | IOException ex) {
                Logger.getLogger(DatabaseUtilities.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(DatabaseUtilities.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return connection;
    }

}
