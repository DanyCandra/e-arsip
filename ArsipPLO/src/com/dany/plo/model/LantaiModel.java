/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.LantaiDao;
import com.dany.plo.dao.impl.LantaiDaoImpl;
import com.dany.plo.entitas.Lantai;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.dany.plo.view.resource.render.table.LantaiRender;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class LantaiModel {
    
    private String idLantai;
    
    @TableColumn(name = "Lantai", number = 1, size = 110, renderer = LantaiRender.class)
    private String namaLantai;
    
    public LantaiModel() {
    }
    
    public LantaiModel(String idLantai, String namaLantai) {
        this.idLantai = idLantai;
        this.namaLantai = namaLantai;
    }
    
    public String getIdLantai() {
        return idLantai;
    }
    
    public void setIdLantai(String idLantai) {
        this.idLantai = idLantai;
    }
    
    public String getNamaLantai() {
        return namaLantai;
    }
    
    public void setNamaLantai(String namaLantai) {
        this.namaLantai = namaLantai;
    }
    
    public List<LantaiModel> load() throws ArsipException {
        List<LantaiModel> list = new ArrayList<>();
        
        LantaiDao dao = DatabaseUtilities.getLantaiDao();
        List<Lantai> listTmp = dao.getAllLantai();
        for (Lantai lantai : listTmp) {
            LantaiModel model = new LantaiModel();
            model.setIdLantai(lantai.getIdLantai());
            model.setNamaLantai(lantai.getNamaLantai());
            list.add(model);
        }
        return list;
    }
    
    public void insert() throws ArsipException {
        Lantai lantai = new Lantai();
        lantai.setIdLantai(idLantai);
        lantai.setNamaLantai(namaLantai);
        
        LantaiDao dao = DatabaseUtilities.getLantaiDao();
        dao.insertLantai(lantai);
    }
    
    public void update() throws ArsipException {
        Lantai lantai = new Lantai();
        lantai.setIdLantai(idLantai);
        lantai.setNamaLantai(namaLantai);
        
        LantaiDao dao = DatabaseUtilities.getLantaiDao();
        dao.updateLantai(lantai);
    }
    
    public boolean isDelete() throws ArsipException {
        LantaiDao dao = DatabaseUtilities.getLantaiDao();
        boolean result = dao.canDelete(idLantai);
        return result;
    }
    
    public void delete() throws ArsipException {
        LantaiDao dao = DatabaseUtilities.getLantaiDao();
        dao.delete(idLantai);
    }
    
    public LantaiModel getLantaiModel(String idLantai) throws ArsipException {
        LantaiModel model = new LantaiModel();
        LantaiDao dao = DatabaseUtilities.getLantaiDao();
        Lantai lantai = dao.getLantai(idLantai);
        
        model.setIdLantai(lantai.getIdLantai());
        model.setNamaLantai(lantai.getNamaLantai());
        
        return model;
    }
    
    public Lantai getLantaiFromModel(LantaiModel model){
        Lantai lantai=new Lantai();
        lantai.setIdLantai(model.getIdLantai());
        lantai.setNamaLantai(model.getNamaLantai());
        return lantai;
    }
    
}
