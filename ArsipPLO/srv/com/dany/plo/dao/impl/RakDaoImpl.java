/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao.impl;

import com.dany.plo.entitas.Rak;
import com.dany.plo.dao.RakDao;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.GenerateAutoId;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Dany Candra
 */
public class RakDaoImpl implements RakDao {

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(RakDaoImpl.class);

    private Connection connection;

    public RakDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertRak(Rak rak) throws ArsipException {

        final String INSERT = "INSERT INTO RAK (ID_RAK,NAMA_RAK,QUOTA) VALUES (?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, rak.getIdRak());
            statement.setInt(2, rak.getNamaRak());
            statement.setInt(3, rak.getQuota());
            statement.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }

    }

    @Override
    public List<Rak> getAllRak() throws ArsipException {

        final String SELECT_ALL = "SELECT * FROM RAK";

        List<Rak> list = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery(SELECT_ALL);
            while (set.next()) {
                Rak rak = new Rak();
                rak.setIdRak(set.getString("ID_RAK"));
                rak.setNamaRak(set.getInt("NAMA_RAK"));
                rak.setQuota(set.getInt("QUOTA"));
                list.add(rak);
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }

        return list;
    }

    @Override
    public Rak getRak(String idRak) throws ArsipException {
        final String SELECT = "SELECT * FROM RAK WHERE ID_RAK=?";

        Rak rak = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, idRak);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                rak = new Rak();
                rak.setIdRak(set.getString("ID_RAK"));
                rak.setNamaRak(set.getInt("NAMA_RAK"));
                rak.setQuota(set.getInt("QUOTA"));
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }

        return rak;
    }

    @Override
    public int getRakAkhir() throws ArsipException {
        int rakAkhir = 0;
        final String SELECT = "SELECT COUNT(id_rak) FROM RAK";

        Statement statement = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_SCROLL_INSENSITIVE);
            ResultSet resultSet = statement.executeQuery(SELECT);
            if (resultSet.next()) {
                rakAkhir = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }
        return rakAkhir;
    }

    @Override
    public int getQuotaRakAkhir() throws ArsipException {
        int rakAkhir = 0;
        final String SELECT = "SELECT * FROM RAK";

        Statement statement = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_SCROLL_INSENSITIVE);
            ResultSet resultSet = statement.executeQuery(SELECT);
            if (resultSet.last()) {
                rakAkhir = resultSet.getInt("QUOTA");
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }
        return rakAkhir;
    }

    @Override
    public Rak getRak(int namaRak) throws ArsipException {
        final String SELECT = "SELECT * FROM RAK WHERE NAMA_RAK=?";

        Rak rak = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, namaRak);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                rak = new Rak();
                rak.setIdRak(set.getString("ID_RAK"));
                rak.setNamaRak(set.getInt("NAMA_RAK"));
                rak.setQuota(set.getInt("QUOTA"));
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }

        return rak;
    }

    @Override
    public void updateQuotaRak(int namaRak, int quotaBaru) throws ArsipException {
        final String INSERT = "UPDATE RAK SET QUOTA=? WHERE NAMA_RAK=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, quotaBaru);
            statement.setInt(2, namaRak);

            statement.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }
    }

    @Override
    public void insertRakViaLoop(Rak rak) throws ArsipException {
        final String INSERT = "INSERT INTO RAK (ID_RAK,NAMA_RAK,QUOTA) VALUES (?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, GenerateAutoId.generateAutoId());
            statement.setInt(2, rak.getNamaRak());
            statement.setInt(3, rak.getQuota());
            statement.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }
        }
    }

}
