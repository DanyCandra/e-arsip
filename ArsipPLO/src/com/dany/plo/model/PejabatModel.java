/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.PejabatDao;
import com.dany.plo.dao.impl.PejabatDaoImpl;
import com.dany.plo.entitas.Pejabat;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class PejabatModel {

    private String idPejabat;
    @TableColumn(name = "NAMA ", number = 1, size = 60)
    private String namaPejabat;
    @TableColumn(name = "JABATAN", number = 2, size = 60)
    private String jabatan;

    public PejabatModel() {
    }

    public PejabatModel(String idPejabat, String namaPejabat, String jabatan) {
        this.idPejabat = idPejabat;
        this.namaPejabat = namaPejabat;
        this.jabatan = jabatan;
    }

    public String getIdPejabat() {
        return idPejabat;
    }

    public void setIdPejabat(String idPejabat) {
        this.idPejabat = idPejabat;
    }

    public String getNamaPejabat() {
        return namaPejabat;
    }

    public void setNamaPejabat(String namaPejabat) {
        this.namaPejabat = namaPejabat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public List<PejabatModel> load(int skip, int max) throws ArsipException {
        List<PejabatModel> list = new ArrayList<>();

        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        List<Pejabat> listTmp = dao.getPejabat(skip, max);
        for (Pejabat pejabat : listTmp) {
            PejabatModel model = new PejabatModel();
            model.setIdPejabat(pejabat.getIdPejabat());
            model.setNamaPejabat(pejabat.getNamaPejabat());
            model.setJabatan(pejabat.getJabatan());
            list.add(model);
        }
        return list;
    }

    public List<PejabatModel> loadCombo() throws ArsipException {
        List<PejabatModel> list = new ArrayList<>();

        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        List<Pejabat> listTmp = dao.getPejabat();
        for (Pejabat pejabat : listTmp) {
            PejabatModel model = new PejabatModel();
            model.setIdPejabat(pejabat.getIdPejabat());
            model.setNamaPejabat(pejabat.getNamaPejabat());
            model.setJabatan(pejabat.getJabatan());
            list.add(model);
        }
        return list;
    }

    public Long getLongList() throws ArsipException {
        Long longList = 0L;
        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        longList = dao.count();
        return longList;
    }

    public void insert() throws ArsipException {
        Pejabat pejabat = new Pejabat();
        pejabat.setIdPejabat(idPejabat);
        pejabat.setNamaPejabat(namaPejabat);
        pejabat.setJabatan(jabatan);

        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        dao.insertPejabat(pejabat);
    }

    public void update() throws ArsipException {
        Pejabat pejabat = new Pejabat();
        pejabat.setIdPejabat(idPejabat);
        pejabat.setNamaPejabat(namaPejabat);
        pejabat.setJabatan(jabatan);

        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        dao.updatePejabat(pejabat);
    }

    public boolean isDelete() throws ArsipException {
        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        boolean result = dao.canDelete(idPejabat);
        return result;
    }

    public void delete() throws ArsipException {
        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        dao.delete(idPejabat);
    }

    public Pejabat getPejabatFromModel(PejabatModel model) {
        Pejabat pejabat = new Pejabat();
        pejabat.setIdPejabat(model.getIdPejabat());
        pejabat.setJabatan(model.getJabatan());
        pejabat.setNamaPejabat(model.getNamaPejabat());
        return pejabat;
    }

    public PejabatModel getById(String idPejabat) throws ArsipException {
        PejabatDao dao = DatabaseUtilities.getPejabatDao();
        Pejabat pejabat = dao.getPejabat(idPejabat);
        PejabatModel model = null;
        if (pejabat != null) {
            model = new PejabatModel();
            model.setIdPejabat(pejabat.getIdPejabat());
            model.setNamaPejabat(pejabat.getNamaPejabat());
            model.setJabatan(pejabat.getJabatan());
        }
        return model;
    }

}
