/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao.impl;

import com.dany.plo.dao.CisDao;
import com.dany.plo.entitas.Cis;
import com.dany.plo.exception.ArsipException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dany Candra
 */
public class CisDaoImpl implements CisDao {

    private Connection connection;

    public CisDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Cis cis) throws ArsipException {
        final String INSERT = "INSERT INTO CIS "
                + "(ID_CIS, CIF, CIF_CIS, NO_PINJAMAN, TANGGAL_REALISASI,TANGGAL_MULAI,TANGGAL_SELESAI,JUMLAH_PERTANGGUNGAN) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, cis.getIdCis());
            statement.setString(2, cis.getDebitur().getCif());
            statement.setString(3, cis.getCifCis());
            statement.setString(4, cis.getNoPinjam());
            statement.setDate(5, new Date(cis.getTanggalRealisasi().getTime()));
            statement.setDate(6, new Date(cis.getTanggalMulai().getTime()));
            statement.setDate(7, new Date(cis.getTanggalSelesai().getTime()));
            statement.setDouble(8, cis.getJumlahPertanggungan());
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
    public void update(Cis cis) throws ArsipException {
        final String UPDATE = "UPDATE CIS SET "
                + " CIF=?, CIF_CIS=?, NO_PINJAMAN=?, TANGGAL_REALISASI=?,TANGGAL_MULAI=?,TANGGAL_SELESAI=?,JUMLAH_PERTANGGUNGAN=? "
                + "WHERE ID_CIS=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);

            statement.setString(1, cis.getDebitur().getCif());
            statement.setString(2, cis.getCifCis());
            statement.setString(3, cis.getNoPinjam());
            statement.setDate(4, new Date(cis.getTanggalRealisasi().getTime()));
            statement.setDate(5, new Date(cis.getTanggalMulai().getTime()));
            statement.setDate(6, new Date(cis.getTanggalSelesai().getTime()));
            statement.setDouble(7, cis.getJumlahPertanggungan());
            statement.setString(8, cis.getIdCis());
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

}
