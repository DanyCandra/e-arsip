/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.RakDao;
import com.dany.plo.dao.impl.RakDaoImpl;
import com.dany.plo.entitas.Rak;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.resource.render.NamaRakRender;
import com.dany.plo.view.resource.render.QuotaRakRender;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Dany Candra
 */
public class RakModel {

    private String idRak;
    @TableColumn(name = "NAMA RAK", number = 1, size = 60,renderer = NamaRakRender.class)
    private int namaRak;
    @TableColumn(name = "QUOTA RAK", number = 2, size = 60,renderer = QuotaRakRender.class)
    private int quota;

    public RakModel() {
    }

    public RakModel(String idRak, int namaRak, int quota) {
        this.idRak = idRak;
        this.namaRak = namaRak;
        this.quota = quota;
    }

    public String getIdRak() {
        return idRak;
    }

    public void setIdRak(String idRak) {
        this.idRak = idRak;
    }

    public int getNamaRak() {
        return namaRak;
    }

    public void setNamaRak(int namaRak) {
        this.namaRak = namaRak;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public List<RakModel> load() throws ArsipException {
        List<RakModel> list = new ArrayList<>();

        RakDao dao = new RakDaoImpl(DatabaseUtilities.getConnection());
        List<Rak> listTmp = dao.getAllRak();
        for (Rak rak : listTmp) {
            RakModel model = new RakModel();
            model.setIdRak(rak.getIdRak());
            model.setNamaRak(rak.getNamaRak());
            model.setQuota(rak.getQuota());
            list.add(model);
        }
        return list;
    }

    public void insert() throws ArsipException {
        Rak rak = new Rak();
        rak.setIdRak(GenerateAutoId.generateAutoId());
        rak.setNamaRak(getRakAkhir());
        rak.setQuota(getQuotaInsret());

        RakDao dao = new RakDaoImpl(DatabaseUtilities.getConnection());
        dao.insertRak(rak);
    }

    public int getRakAkhir() throws ArsipException {
        RakDao dao = new RakDaoImpl(DatabaseUtilities.getConnection());
        return dao.getRakAkhir() + 1;

    }

    public int getQuotaInsret() {
        int quota = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream("quota.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            quota = Integer.valueOf(properties.getProperty("rak"));
        } catch (Exception e) {
        }
        return quota;
    }

}
