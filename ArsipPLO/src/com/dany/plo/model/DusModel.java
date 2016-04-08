/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.DusDao;
import com.dany.plo.dao.LantaiDao;
import com.dany.plo.dao.RakDao;
import com.dany.plo.dao.impl.DusDaoImpl;
import com.dany.plo.dao.impl.LantaiDaoImpl;
import com.dany.plo.dao.impl.RakDaoImpl;
import com.dany.plo.entitas.Dus;
import com.dany.plo.entitas.Lantai;
import com.dany.plo.entitas.Rak;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.resource.render.LokasiListCellRender;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class DusModel {

    private String idDus;
    @TableColumn(name = "NAMA DUS", number = 1, size = 30)
    private String namaDus;
    @TableColumn(name = "LOKASI", number = 1, size = 30)
    private String lokasi;
    @TableColumn(name = "RAK", number = 1, size = 30)
    private int rak;
    @TableColumn(name = "QUOTA", number = 1, size = 30)
    private int quota;

    public DusModel() {
    }

    public String getIdDus() {
        return idDus;
    }

    public void setIdDus(String idDus) {
        this.idDus = idDus;
    }

    public String getNamaDus() {
        return namaDus;
    }

    public void setNamaDus(String namaDus) {
        this.namaDus = namaDus;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getRak() {
        return rak;
    }

    public void setRak(int rak) {
        this.rak = rak;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public List<DusModel> load(int skip, int max) throws ArsipException {
        List<DusModel> list = new ArrayList<>();

        DusDao dao = new DusDaoImpl(DatabaseUtilities.getConnection());
        List<Dus> listTmp = dao.getAllDus(skip, max);
        for (Dus dus : listTmp) {
            DusModel model = new DusModel();
            model.setIdDus(dus.getIdDus());
            model.setLokasi(dus.getLantai().getNamaLantai());
            model.setRak(dus.getRak().getNamaRak());
            model.setNamaDus(dus.getNamaDus());
            model.setQuota(dus.getQuota());
            list.add(model);
        }

        return list;
    }

    public int getLongList() throws ArsipException {
        int longList = 0;
        DusDao dao = new DusDaoImpl(DatabaseUtilities.getConnection());
        longList = dao.getDusAkhir();
        return longList;
    }

    public void insertDus(int jumlahDus, LantaiModel lantaiInsert) throws ArsipException {
        LantaiDao lantaiDao = new LantaiDaoImpl(DatabaseUtilities.getConnection());
        RakDao rakDao = new RakDaoImpl(DatabaseUtilities.getConnection());
        DusDao dusDao = new DusDaoImpl(DatabaseUtilities.getConnection());

        
        int dus = dusDao.getDusAkhir() + 1;
        int rak = rakDao.getRakAkhir();

        if (rak == 0) {
            rak = 1;
            Rak rak1 = new Rak();
            rak1.setIdRak(GenerateAutoId.generateAutoId());
            rak1.setNamaRak(rak);
            rak1.setQuota(getQuotaRak());
            rakDao.insertRak(rak1);
        }
        int tmpquotaRak = rakDao.getQuotaRakAkhir();
        int quotaRak = getQuotaRak();
        int jumlahdus = jumlahDus;

        for (int i = 1; i <= jumlahdus; i++) {
            if (tmpquotaRak != 0) {
                if (tmpquotaRak <= quotaRak) {
                    tmpquotaRak = tmpquotaRak - 1;

                    Dus d = new Dus();
                    d.setIdDus(GenerateAutoId.generateAutoId());
                    d.setNamaDus(lantaiInsert.getNamaLantai() + "." + rak + "." + dus);
                    d.setLantai(new Lantai(lantaiInsert.getIdLantai(), lantaiInsert.getNamaLantai()));
                    d.setRak(rakDao.getRak(rak));
                    d.setQuota(getQuotaDus());
                    
                    dusDao.insertDus(d);
                    //update rak
                    rakDao.updateQuotaRak(rak, tmpquotaRak);
                }
            } else if (tmpquotaRak == 0) {
                rak++;
                tmpquotaRak = quotaRak - 1;

                Rak rak1 = new Rak();
                rak1.setIdRak(GenerateAutoId.generateAutoId());
                rak1.setNamaRak(rak);
                rak1.setQuota(tmpquotaRak);
                rakDao.insertRak(rak1);

                Dus d = new Dus();
                d.setIdDus(GenerateAutoId.generateAutoId());
                d.setNamaDus(lantaiInsert.getNamaLantai() + "." + rak + "." + dus);
                d.setLantai(new Lantai(lantaiInsert.getIdLantai(), lantaiInsert.getNamaLantai()));
                d.setRak(rakDao.getRak(rak));
                d.setQuota(getQuotaDus());
            }
            dus = dus + 1;
        }
    }

    public int getQuotaRak() throws ArsipException {
        int quota = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("quota.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            quota = Integer.valueOf(properties.getProperty("rak"));
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
                throw new ArsipException(ex.getMessage());
            }
        }
        return quota;
    }

    public int getQuotaDus() throws ArsipException {
        int quota = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("quota.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            quota = Integer.valueOf(properties.getProperty("dus"));
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
                throw new ArsipException(ex.getMessage());
            }
        }
        return quota;
    }

    
}
