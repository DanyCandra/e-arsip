/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao.impl;

import com.dany.plo.dao.PengarsipanDao;
import com.dany.plo.entitas.Pengarsipan;
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
public class PengarsipanDaoImpl implements PengarsipanDao {

    private Connection connection;

    public PengarsipanDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPengarsipan(Pengarsipan pengarsipan) throws ArsipException {
        final String INSERT = "INSERT INTO PENGARSIPAN "
                + "(ID_ARSIP, CIF,TANGGAL_TERIMA, ID_USER_PENERIMA, ID_PEJABAT_PENERIMA,ID_DUS,TANGGAL_KEMBALI,ID_USER_PENGEMBALI,ID_PEJABAT_PENGEMBALI,STATUS_ARSIP,STATUS_KEMBALI) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, pengarsipan.getIdArsip());
            statement.setString(2, pengarsipan.getDebitur().getCif());
            statement.setDate(3, new Date(pengarsipan.getTanggalTerima().getTime()));
            statement.setString(4, pengarsipan.getUserPenerima().getIdUser());
            statement.setString(5, pengarsipan.getPejabatPenerima().getIdPejabat());
            statement.setString(6, pengarsipan.getDus().getIdDus());
            statement.setDate(7, new Date(pengarsipan.getTanggalKembali().getTime()));
            statement.setString(8, pengarsipan.getUserPengembali().getIdUser());
            statement.setString(9, pengarsipan.getPejabatPengembali().getIdPejabat());
            statement.setString(10, pengarsipan.getStatusArsip());
            statement.setString(11, pengarsipan.getStatusKembali());
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
    public void updatePengarsipan(Pengarsipan pengarsipan) throws ArsipException {
        final String UPDATE = "UPDATE PENGARSIPAN SET "
                + "CIF=?,TANGGAL_TERIMA=?, ID_USER_PENERIMA=?, ID_PEJABAT_PENERIMA=?,ID_DUS=?,TANGGAL_KEMBALI=?,ID_USER_PENGEMBALI=?,ID_PEJABAT_PENGEMBALI=?,STATUS_ARSIP=?,STATUS_KEMBALI=? "
                + "WHERE ID_ARSIP=? ";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);

            statement.setString(1, pengarsipan.getDebitur().getCif());
            statement.setDate(2, new Date(pengarsipan.getTanggalTerima().getTime()));
            statement.setString(3, pengarsipan.getUserPenerima().getIdUser());
            statement.setString(4, pengarsipan.getPejabatPenerima().getIdPejabat());
            statement.setString(5, pengarsipan.getDus().getIdDus());
            statement.setDate(6, new Date(pengarsipan.getTanggalKembali().getTime()));
            statement.setString(7, pengarsipan.getUserPengembali().getIdUser());
            statement.setString(8, pengarsipan.getPejabatPengembali().getIdPejabat());
            statement.setString(9, pengarsipan.getStatusArsip());
            statement.setString(10, pengarsipan.getStatusKembali());
            statement.setString(11, pengarsipan.getIdArsip());
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
    public void insertPenerimaan(Pengarsipan pengarsipan) throws ArsipException {
        final String INSERT = "INSERT INTO PENGARSIPAN "
                + "(ID_ARSIP, CIF,TANGGAL_TERIMA, ID_USER_PENERIMA, ID_PEJABAT_PENERIMA,ID_DUS,STATUS_ARSIP) "
                + "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, pengarsipan.getIdArsip());
            statement.setString(2, pengarsipan.getDebitur().getCif());
            statement.setDate(3, new Date(pengarsipan.getTanggalTerima().getTime()));
            statement.setString(4, pengarsipan.getUserPenerima().getIdUser());
            statement.setString(5, pengarsipan.getPejabatPenerima().getIdPejabat());
            statement.setString(6, pengarsipan.getDus().getIdDus());
            statement.setString(7, pengarsipan.getStatusArsip());
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
    public void updatePenerimaan(Pengarsipan pengarsipan) throws ArsipException {
        final String INSERT = "UPDATE PENGARSIPAN SET "
                + "CIF=?,TANGGAL_TERIMA=?, ID_USER_PENERIMA=?, ID_PEJABAT_PENERIMA=?,ID_DUS=?,STATUS_ARSIP=? "
                + "WHERE ID_ARSIP=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setString(1, pengarsipan.getDebitur().getCif());
            statement.setDate(2, new Date(pengarsipan.getTanggalTerima().getTime()));
            statement.setString(3, pengarsipan.getUserPenerima().getIdUser());
            statement.setString(4, pengarsipan.getPejabatPenerima().getIdPejabat());
            statement.setString(5, pengarsipan.getDus().getIdDus());
            statement.setString(6, pengarsipan.getStatusArsip());
            statement.setString(7, pengarsipan.getIdArsip());
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
    public void insertPengembalian(Pengarsipan pengarsipan) throws ArsipException {
        final String INSERT = "UPDATE PENGARSIPAN SET "
                + "TANGGAL_KEMBALI=?,ID_USER_PENGEMBALI=?,ID_PEJABAT_PENGEMBALI=?,STATUS_ARSIP=?,STATUS_KEMBALI=? "
                + "WHERE ID_ARSIP=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);

            statement.setDate(1, new Date(pengarsipan.getTanggalKembali().getTime()));
            statement.setString(2, pengarsipan.getUserPengembali().getIdUser());
            statement.setString(3, pengarsipan.getPejabatPengembali().getIdPejabat());
            statement.setString(4, pengarsipan.getStatusArsip());
            statement.setString(5, pengarsipan.getStatusKembali());
            statement.setString(6, pengarsipan.getIdArsip());
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
    public List<Pengarsipan> getAllDebitur(int skip, int max) throws ArsipException {
        final String SELECT = "SELECT * FROM PENGARSIPAN LIMIT ?,?";
        List<Pengarsipan> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, skip);
            statement.setInt(2, max);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Pengarsipan pengarsipan = new Pengarsipan();
                pengarsipan.setIdArsip(set.getString(1));
                pengarsipan.setDebitur(DatabaseUtilities.getDebiturDao().getDebitur(set.getString(2)));
                pengarsipan.setTanggalTerima(set.getDate(3));
                pengarsipan.setUserPenerima(DatabaseUtilities.getUserDao().getUser(set.getString(4)));
                pengarsipan.setPejabatPenerima(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(5)));
                pengarsipan.setDus(DatabaseUtilities.getDusDao().getDus(set.getString(6)));
                pengarsipan.setTanggalKembali(set.getDate(7));
                pengarsipan.setUserPengembali(DatabaseUtilities.getUserDao().getUser(set.getString(8)));
                pengarsipan.setPejabatPengembali(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(9)));
                pengarsipan.setStatusArsip(set.getString(10));
                pengarsipan.setStatusKembali(set.getString(11));

                list.add(pengarsipan);
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
    public Pengarsipan getPengarsipanByCIF(String cif) throws ArsipException {
        final String SELECT = "SELECT * FROM PENGARSIPAN WHERE CIF=?";
        Pengarsipan pengarsipan = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, cif);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                pengarsipan = new Pengarsipan();
                pengarsipan.setIdArsip(set.getString(1));
                pengarsipan.setDebitur(DatabaseUtilities.getDebiturDao().getDebitur(set.getString(2)));
                pengarsipan.setTanggalTerima(set.getDate(3));
                pengarsipan.setUserPenerima(DatabaseUtilities.getUserDao().getUser(set.getString(4)));
                pengarsipan.setPejabatPenerima(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(5)));
                pengarsipan.setDus(DatabaseUtilities.getDusDao().getDus(set.getString(6)));
                pengarsipan.setTanggalKembali(set.getDate(7));
                pengarsipan.setUserPengembali(DatabaseUtilities.getUserDao().getUser(set.getString(8)));
                pengarsipan.setPejabatPengembali(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(9)));
                pengarsipan.setStatusArsip(set.getString(10));
                pengarsipan.setStatusKembali(set.getString(11));

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

        return pengarsipan;
    }

    @Override
    public List<Pengarsipan> getDaftarBerkasTersedia(int skip, int max) throws ArsipException {
        final String SELECT = "SELECT * FROM PENGARSIPAN WHERE STATUS_ARSIP = 1 LIMIT ?,?";
        List<Pengarsipan> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, skip);
            statement.setInt(2, max);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Pengarsipan pengarsipan = new Pengarsipan();
                pengarsipan.setIdArsip(set.getString(1));
                pengarsipan.setDebitur(DatabaseUtilities.getDebiturDao().getDebitur(set.getString(2)));
                pengarsipan.setTanggalTerima(set.getDate(3));
                pengarsipan.setUserPenerima(DatabaseUtilities.getUserDao().getUser(set.getString(4)));
                pengarsipan.setPejabatPenerima(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(5)));
                pengarsipan.setDus(DatabaseUtilities.getDusDao().getDus(set.getString(6)));
                pengarsipan.setTanggalKembali(set.getDate(7));
                pengarsipan.setUserPengembali(DatabaseUtilities.getUserDao().getUser(set.getString(8)));
                pengarsipan.setPejabatPengembali(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(9)));
                pengarsipan.setStatusArsip(set.getString(10));
                pengarsipan.setStatusKembali(set.getString(11));

                list.add(pengarsipan);
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
    public Long getLongPenerimaan() throws ArsipException {
        final String COUNT_SQL = "SELECT COUNT(ID_ARSIP) as TOTAL FROM PENGARSIPAN WHERE STATUS_ARSIP=1";
        Long total = 0L;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(COUNT_SQL);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                total = set.getLong("TOTAL");
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

            return total;
        }
    }

    @Override
    public List<Pengarsipan> getDaftarBerkasTersedia(String cif) throws ArsipException {
        final String SELECT = "SELECT * FROM PENGARSIPAN WHERE STATUS_ARSIP = 1 AND CIF LIKE ?";
        List<Pengarsipan> list = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, "%" + cif + "%");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Pengarsipan pengarsipan = new Pengarsipan();
                pengarsipan.setIdArsip(set.getString(1));
                pengarsipan.setDebitur(DatabaseUtilities.getDebiturDao().getDebitur(set.getString(2)));
                pengarsipan.setTanggalTerima(set.getDate(3));
                pengarsipan.setUserPenerima(DatabaseUtilities.getUserDao().getUser(set.getString(4)));
                pengarsipan.setPejabatPenerima(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(5)));
                pengarsipan.setDus(DatabaseUtilities.getDusDao().getDus(set.getString(6)));
                pengarsipan.setTanggalKembali(set.getDate(7));
                pengarsipan.setUserPengembali(DatabaseUtilities.getUserDao().getUser(set.getString(8)));
                pengarsipan.setPejabatPengembali(DatabaseUtilities.getPejabatDao().getPejabat(set.getString(9)));
                pengarsipan.setStatusArsip(set.getString(10));
                pengarsipan.setStatusKembali(set.getString(11));

                list.add(pengarsipan);
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

}
