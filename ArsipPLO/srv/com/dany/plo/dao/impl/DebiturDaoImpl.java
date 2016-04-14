/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao.impl;

import com.dany.plo.dao.DebiturDao;
import com.dany.plo.entitas.Debitur;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class DebiturDaoImpl implements DebiturDao {

    private Connection connection;

    public DebiturDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertDebitur(Debitur debitur) throws ArsipException {
        final String INSERT = "INSERT INTO DEBITUR (CIF,NAMA,TEMPAT_LAHIR,TANGGAL_LAHIR,NIK,ALAMAT,KELURAHAN,KECAMATAN,TELEPON,"
                + "SK_CPNS,SK_PENGANGKATAN,SK_TERAKHIR,TASPEN,SK_PENSIUN,KARIP,SHM,SHT,IJAZAH,LAINNYA,ID_INSTANSI) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, debitur.getCif());
            statement.setString(2, debitur.getNama());
            statement.setString(3, debitur.getTempatLahir());
            statement.setDate(4, new Date(debitur.getTanggalLahir().getTime()));
            statement.setString(5, debitur.getNik());
            statement.setString(6, debitur.getAlamat());
            statement.setString(7, debitur.getKelurahan());
            statement.setString(8, debitur.getKecamatan());
            statement.setString(9, debitur.getTelepon());
            statement.setString(10, debitur.getSkCpns());
            statement.setString(11, debitur.getSkPengangkatan());
            statement.setString(12, debitur.getSkTerakhir());
            statement.setString(13, debitur.getTaspen());
            statement.setString(14, debitur.getSkPensiun());
            statement.setString(15, debitur.getKarip());
            statement.setString(16, debitur.getShm());
            statement.setString(17, debitur.getSht());
            statement.setString(18, debitur.getIjazah());
            statement.setString(19, debitur.getLainnya());
            statement.setString(20, debitur.getInstansi().getIdInstans());
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
    public void updateDebitur(Debitur debitur) throws ArsipException {
        final String UPDATE = "UPDATE  DEBITUR "
                + "SET NAMA=?,TEMPAT_LAHIR=?,TANGGAL_LAHIR=?,NIK=?,ALAMAT=?,KELURAHAN=?,KECAMATAN=?,TELEPON=?, "
                + "SK_CPNS=?,SK_PENGANGKATAN=?,SK_TERAKHIR=?,TASPEN=?,SK_PENSIUN=?,KARIP=?,SHM=?,SHT=?,IJAZAH=?,LAINNYA=?,ID_INSTANSI=? "
                + "WHERE CIF=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);

            statement.setString(1, debitur.getNama());
            statement.setString(2, debitur.getTempatLahir());
            statement.setDate(3, new Date(debitur.getTanggalLahir().getTime()));
            statement.setString(4, debitur.getNik());
            statement.setString(5, debitur.getAlamat());
            statement.setString(6, debitur.getKelurahan());
            statement.setString(7, debitur.getKecamatan());
            statement.setString(8, debitur.getTelepon());
            statement.setString(9, debitur.getSkCpns());
            statement.setString(10, debitur.getSkPengangkatan());
            statement.setString(11, debitur.getSkTerakhir());
            statement.setString(12, debitur.getTaspen());
            statement.setString(13, debitur.getSkPensiun());
            statement.setString(14, debitur.getKarip());
            statement.setString(15, debitur.getShm());
            statement.setString(16, debitur.getSht());
            statement.setString(17, debitur.getIjazah());
            statement.setString(18, debitur.getLainnya());
            statement.setString(19, debitur.getInstansi().getIdInstans());
            statement.setString(20, debitur.getCif());
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
    public Debitur getDebitur(String cif) throws ArsipException {
        final String SELECT = "SELECT * FROM DEBITUR WHERE CIF=?";

        Debitur debitur = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, cif);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                debitur = new Debitur();
                debitur.setCif(set.getString(1));
                debitur.setNama(set.getString(2));
                debitur.setTempatLahir(set.getString(3));
                debitur.setTanggalLahir(set.getDate(4));
                debitur.setNik(set.getString(5));
                debitur.setAlamat(set.getString(6));
                debitur.setKelurahan(set.getString(7));
                debitur.setKecamatan(set.getString(8));
                debitur.setTelepon(set.getString(9));
                debitur.setSkCpns(set.getString(10));
                debitur.setSkPengangkatan(set.getString(11));
                debitur.setSkTerakhir(set.getString(12));
                debitur.setTaspen(set.getString(13));
                debitur.setSkPensiun(set.getString(14));
                debitur.setKarip(set.getString(15));
                debitur.setShm(set.getString(16));
                debitur.setSht(set.getString(17));
                debitur.setIjazah(set.getString(18));
                debitur.setLainnya(set.getString(19));
                debitur.setInstansi(DatabaseUtilities.getInstansiDao().getInstansi(set.getString(20)));
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

        return debitur;
    }

    @Override
    public List<Debitur> getAllDebitur(int skip, int max) throws ArsipException {
        final String SELECT = "SELECT * FROM DEBITUR LIMIT ?,?";
        List<Debitur> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, skip);
            statement.setInt(2, max);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Debitur debitur = new Debitur();
                debitur.setCif(set.getString(1));
                debitur.setNama(set.getString(2));
                debitur.setTempatLahir(set.getString(3));
                debitur.setTanggalLahir(set.getDate(4));
                debitur.setNik(set.getString(5));
                debitur.setAlamat(set.getString(6));
                debitur.setKelurahan(set.getString(7));
                debitur.setKecamatan(set.getString(8));
                debitur.setTelepon(set.getString(9));
                debitur.setSkCpns(set.getString(10));
                debitur.setSkPengangkatan(set.getString(11));
                debitur.setSkTerakhir(set.getString(12));
                debitur.setTaspen(set.getString(13));
                debitur.setSkPensiun(set.getString(14));
                debitur.setKarip(set.getString(15));
                debitur.setShm(set.getString(16));
                debitur.setSht(set.getString(17));
                debitur.setIjazah(set.getString(18));
                debitur.setLainnya(set.getString(19));
                debitur.setInstansi(DatabaseUtilities.getInstansiDao().getInstansi(set.getString(20)));
                list.add(debitur);
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
    public List<Debitur> getAllDebitur(String nama) throws ArsipException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
