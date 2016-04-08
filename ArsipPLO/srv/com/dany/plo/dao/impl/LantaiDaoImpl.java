/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao.impl;

import com.dany.plo.entitas.Lantai;
import com.dany.plo.dao.LantaiDao;
import com.dany.plo.exception.ArsipException;
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
public class LantaiDaoImpl implements LantaiDao {

    private Connection connection;

    public LantaiDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertLantai(Lantai lantai) throws ArsipException {

        final String INSERT = "INSERT INTO LANTAI (ID_LANTAI,NAMA_LANTAI) VALUES (?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, lantai.getIdLantai());
            statement.setString(2, lantai.getNamaLantai());
            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new ArsipException(ex.getMessage());
                }
            }
        }

    }

    @Override
    public List<Lantai> getAllLantai() throws ArsipException {

        final String SELECT_ALL = "SELECT * FROM LANTAI ORDER BY NAMA_LANTAI";

        List<Lantai> list = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery(SELECT_ALL);
            while (set.next()) {
                Lantai lantai = new Lantai();
                lantai.setIdLantai(set.getString("ID_LANTAI"));
                lantai.setNamaLantai(set.getString("NAMA_LANTAI"));
                list.add(lantai);
            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new ArsipException(ex.getMessage());
                }
            }
        }

        return list;
    }

    @Override
    public Lantai getLantai(String idLantai) throws ArsipException {
        final String SELECT = "SELECT * FROM LANTAI WHERE ID_LANTAI=?";

        Lantai lantai = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, idLantai);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                lantai = new Lantai();
                lantai.setIdLantai(set.getString("ID_LANTAI"));
                lantai.setNamaLantai(set.getString("NAMA_LANTAI"));

            }
        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new ArsipException(ex.getMessage());
                }
            }
        }

        return lantai;
    }

    @Override
    public void updateLantai(Lantai lantai) throws ArsipException {
        final String UPDATE = "UPDATE LANTAI SET NAMA_LANTAI=? WHERE ID_LANTAI=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);

            statement.setString(1, lantai.getNamaLantai());
            statement.setString(2, lantai.getIdLantai());

            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new ArsipException(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void delete(String idLantai) throws ArsipException {
        final String DELETE = "DELETE FROM LANTAI WHERE ID_LANTAI=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);

            statement.setString(1, idLantai);

            statement.executeUpdate();

        } catch (SQLException ex) {

            throw new ArsipException(ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    throw new ArsipException(ex.getMessage());
                }
            }
        }
    }

    @Override
    public boolean canDelete(String idLantai) throws ArsipException {
        final String DELETE = "SELECT ID_LANTAI FROM DUS WHERE ID_LANTAI = ? ";
        boolean result = true;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setString(1, idLantai);

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                result = false;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new ArsipException(ex.getMessage());

        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                    throw new ArsipException(ex.getMessage());
                }
            }
            return result;
        }
    }

}
