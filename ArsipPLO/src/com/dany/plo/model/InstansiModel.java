/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.entitas.Instansi;
import com.dany.plo.dao.InstansiDao;
import com.dany.plo.dao.impl.InstansiDaoImpl;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class InstansiModel {
    
    private String idInstans;
    @TableColumn(name = "NAMA INSTANSI", number = 1, size = 40)
    private String namaInstansi;
    @TableColumn(name = "ALAMAT", number = 2, size = 62)
    private String alamat;
    @TableColumn(name = "TELEPON", number = 25)
    private String telepon;
    
    public InstansiModel() {
    }
    
    public InstansiModel(String idInstans, String namaInstansi, String alamat, String telepon) {
        this.idInstans = idInstans;
        this.namaInstansi = namaInstansi;
        this.alamat = alamat;
        this.telepon = telepon;
    }
    
    public String getIdInstans() {
        return idInstans;
    }
    
    public void setIdInstans(String idInstans) {
        this.idInstans = idInstans;
    }
    
    public String getNamaInstansi() {
        return namaInstansi;
    }
    
    public void setNamaInstansi(String namaInstansi) {
        this.namaInstansi = namaInstansi;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getTelepon() {
        return telepon;
    }
    
    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    public void save(Instansi instansi) {
        
    }
    
    public List<InstansiModel> load(int skip, int max) throws ArsipException {
        List<InstansiModel> list = new ArrayList<>();
        
        InstansiDao dao = new InstansiDaoImpl(DatabaseUtilities.getConnection());
        List<Instansi> listTmp = dao.getInstansi(skip, max);
        for (Instansi instansi : listTmp) {
            InstansiModel model = new InstansiModel();
            model.setIdInstans(instansi.getIdInstans());
            model.setAlamat(instansi.getAlamat());
            model.setNamaInstansi(instansi.getNamaInstansi());
            model.setTelepon(instansi.getTelepon());
            list.add(model);
        }
        return list;
    }
    
    public Long getLongList() throws ArsipException {
        Long longList = 0L;
        InstansiDao dao = new InstansiDaoImpl(DatabaseUtilities.getConnection());
        longList = dao.count();
        return longList;
    }
    
    public void insert() throws ArsipException {
        Instansi instansi = new Instansi();
        instansi.setIdInstans(idInstans);
        instansi.setAlamat(alamat);
        instansi.setNamaInstansi(namaInstansi);
        instansi.setTelepon(telepon);
        
        InstansiDao dao = new InstansiDaoImpl(DatabaseUtilities.getConnection());
        dao.insertInstansi(instansi);
    }
    
    public void update() throws ArsipException {
        Instansi instansi = new Instansi();
        instansi.setIdInstans(idInstans);
        instansi.setAlamat(alamat);
        instansi.setNamaInstansi(namaInstansi);
        instansi.setTelepon(telepon);
        
        InstansiDao dao = new InstansiDaoImpl(DatabaseUtilities.getConnection());
        dao.updateInstansi(instansi);
    }
    
    public boolean isDelete() throws ArsipException {
        InstansiDao dao = new InstansiDaoImpl(DatabaseUtilities.getConnection());
        boolean result = dao.canDelete(idInstans);
        return result;
    }
    
    public void delete() throws ArsipException {
        InstansiDao dao = new InstansiDaoImpl(DatabaseUtilities.getConnection());
        dao.delete(idInstans);
    }
}
