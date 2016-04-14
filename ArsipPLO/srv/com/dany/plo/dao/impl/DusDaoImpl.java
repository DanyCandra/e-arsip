/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao.impl;

import com.dany.plo.entitas.Dus;
import com.dany.plo.dao.DusDao;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class DusDaoImpl implements DusDao {

    private Connection connection;

    public DusDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertDus(Dus dus) throws ArsipException {
        final String INSERT_DUS = "INSERT INTO DUS (ID_DUS, NAMA_DUS, ID_LANTAI, ID_RAK, QUOTA) "
                + "VALUES (?,?,?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_DUS);

            statement.setString(1, dus.getIdDus());
            statement.setString(2, dus.getNamaDus());
            statement.setString(3, dus.getLantai().getIdLantai());
            statement.setString(4, dus.getRak().getIdRak());
            statement.setInt(5, dus.getQuota());
            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public void updateDus(Dus dus) throws ArsipException {
        final String INSERT_DUS = "UPDATE DUS  SET NAMA_DUS=?, ID_LANTAI=?, ID_RAK=?, QUOTA=? "
                + "WHERE ID_DUS=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_DUS);

            statement.setString(1, dus.getNamaDus());
            statement.setString(2, dus.getLantai().getIdLantai());
            statement.setString(3, dus.getRak().getIdRak());
            statement.setInt(4, dus.getQuota());
            statement.setString(5, dus.getIdDus());
            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public List<Dus> getAllDus() throws ArsipException {
        final String SELECT_ALL = "SELECT * FROM DUS";

        List<Dus> list = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery(SELECT_ALL);
            while (set.next()) {
                Dus dus = new Dus();
                dus.setIdDus(set.getString("ID_DUS"));
                dus.setNamaDus(set.getString("NAMA_DUS"));
                dus.setLantai(DatabaseUtilities.getLantaiDao().getLantai(set.getString("ID_LANTAI")));
                dus.setRak(DatabaseUtilities.getRakDao().getRak(set.getString("ID_RAK")));
                dus.setQuota(set.getInt("QUOTA"));
                list.add(dus);
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }

        return list;
    }

    @Override
    public int getDusAkhir() throws ArsipException {
        int dusAkhir = 0;
        final String SELECT = "SELECT COUNT(id_dus) FROM DUS";

        Statement statement = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_SCROLL_INSENSITIVE);
            ResultSet resultSet = statement.executeQuery(SELECT);
            if (resultSet.next()) {
                int tmp = resultSet.getInt(1);
                dusAkhir = tmp;
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }
        return dusAkhir;
    }

    @Override
    public List<Dus> getAllDus(int skip, int max) throws ArsipException {
        final String SELECT_ALL = "SELECT * FROM DUS LIMIT ?,?";

        List<Dus> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            statement.setInt(1, skip);
            statement.setInt(2, max);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Dus dus = new Dus();
                dus.setIdDus(set.getString("ID_DUS"));
                dus.setNamaDus(set.getString("NAMA_DUS"));
                dus.setLantai(DatabaseUtilities.getLantaiDao().getLantai(set.getString("ID_LANTAI")));
                dus.setRak(DatabaseUtilities.getRakDao().getRak(set.getString("ID_RAK")));
                dus.setQuota(set.getInt("QUOTA"));
                list.add(dus);
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }

        return list;
    }

    @Override
    public List<Dus> getAllDus(String idRak) throws ArsipException {
        final String SELECT_ALL = "SELECT * FROM DUS WHERE ID_RAK=?";

        List<Dus> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            statement.setString(1, idRak);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Dus dus = new Dus();
                dus.setIdDus(set.getString("ID_DUS"));
                dus.setNamaDus(set.getString("NAMA_DUS"));
                dus.setLantai(DatabaseUtilities.getLantaiDao().getLantai(set.getString("ID_LANTAI")));
                dus.setRak(DatabaseUtilities.getRakDao().getRak(set.getString("ID_RAK")));
                dus.setQuota(set.getInt("QUOTA"));
                list.add(dus);
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }

        return list;
    }

    @Override
    public List<Dus> getDusEmpety() throws ArsipException {
        final String SELECT_ALL = "SELECT * FROM DUS WHERE QUOTA > 0";

        List<Dus> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Dus dus = new Dus();
                dus.setIdDus(set.getString("ID_DUS"));
                dus.setNamaDus(set.getString("NAMA_DUS"));
                dus.setLantai(DatabaseUtilities.getLantaiDao().getLantai(set.getString("ID_LANTAI")));
                dus.setRak(DatabaseUtilities.getRakDao().getRak(set.getString("ID_RAK")));
                dus.setQuota(set.getInt("QUOTA"));
                list.add(dus);
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }

        return list;
    }

    @Override
    public Dus getDus(String id) throws ArsipException {
        final String SELECT_ALL = "SELECT * FROM DUS WHERE ID_DUS=?";

        Dus dus = new Dus();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            statement.setString(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                dus = new Dus();
                dus.setIdDus(set.getString("ID_DUS"));
                dus.setNamaDus(set.getString("NAMA_DUS"));
                dus.setLantai(new LantaiDaoImpl(connection).getLantai(set.getString("ID_LANTAI")));
                dus.setRak(new RakDaoImpl(connection).getRak(set.getString("ID_RAK")));
                dus.setQuota(set.getInt("QUOTA"));
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {

                }
            }
        }

        return dus;
    }

}
