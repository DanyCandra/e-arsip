/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.utilities;

import com.dany.plo.dao.CisDao;
import com.dany.plo.dao.DebiturDao;
import com.dany.plo.dao.DusDao;
import com.dany.plo.dao.InstansiDao;
import com.dany.plo.dao.LantaiDao;
import com.dany.plo.dao.PejabatDao;
import com.dany.plo.dao.PengarsipanDao;
import com.dany.plo.dao.RakDao;
import com.dany.plo.dao.UserDao;
import com.dany.plo.dao.impl.CisDaoImpl;
import com.dany.plo.dao.impl.DebiturDaoImpl;
import com.dany.plo.dao.impl.DusDaoImpl;
import com.dany.plo.dao.impl.InstansiDaoImpl;
import com.dany.plo.dao.impl.LantaiDaoImpl;
import com.dany.plo.dao.impl.PejabatDaoImpl;
import com.dany.plo.dao.impl.PengarsipanDaoImpl;
import com.dany.plo.dao.impl.RakDaoImpl;
import com.dany.plo.dao.impl.UserDaoImpl;
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

    private static CisDao cisDao;
    private static DebiturDao debiturDao;
    private static DusDao dusDao;
    private static InstansiDao instansiDao;
    private static LantaiDao lantaiDao;
    private static PejabatDao pejabatDao;
    private static PengarsipanDao pengarsipanDao;
    private static RakDao rakDao;
    private static UserDao userDao;

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

    public static CisDao getCisDao() {
        if (cisDao == null) {
            cisDao = new CisDaoImpl(getConnection());
        }
        return cisDao;
    }

    public static DebiturDao getDebiturDao() {
        if (debiturDao == null) {
            debiturDao = new DebiturDaoImpl(getConnection());
        }
        return debiturDao;
    }

    public static DusDao getDusDao() {
        if (dusDao == null) {
            dusDao = new DusDaoImpl(getConnection());
        }
        return dusDao;
    }

    public static InstansiDao getInstansiDao() {
        if (instansiDao == null) {
            instansiDao = new InstansiDaoImpl(getConnection());
        }
        return instansiDao;
    }

    public static LantaiDao getLantaiDao() {
        if (lantaiDao == null) {
            lantaiDao = new LantaiDaoImpl(getConnection());
        }
        return lantaiDao;
    }

    public static PejabatDao getPejabatDao() {
        if (pejabatDao == null) {
            pejabatDao = new PejabatDaoImpl(getConnection());
        }
        return pejabatDao;
    }

    public static PengarsipanDao getPengarsipanDao() {
        if (pengarsipanDao == null) {
            pengarsipanDao = new PengarsipanDaoImpl(getConnection());
        }
        return pengarsipanDao;
    }

    public static RakDao getRakDao() {
        if (rakDao == null) {
            rakDao = new RakDaoImpl(getConnection());
        }
        return rakDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl(getConnection());
        }
        return userDao;
    }

}
