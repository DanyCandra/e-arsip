/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.CisDao;
import com.dany.plo.dao.impl.CisDaoImpl;
import com.dany.plo.dao.impl.DebiturDaoImpl;
import com.dany.plo.entitas.Cis;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import java.util.Date;

/**
 *
 * @author Dany Candra
 */
public class CisModel {

    private String idCis;
    private DebiturModel debiturModel;
    private String cifCis;
    private String noPinjam;
    private Date tanggalRealisasi;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private double jumlahPertanggungan;

    public CisModel() {
    }

    public CisModel(String idCis, DebiturModel debiturModel, String cifCis, String noPinjam, Date tanggalRealisasi, Date tanggalMulai, Date tanggalSelesai, double jumlahPertanggungan) {
        this.idCis = idCis;
        this.debiturModel = debiturModel;
        this.cifCis = cifCis;
        this.noPinjam = noPinjam;
        this.tanggalRealisasi = tanggalRealisasi;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.jumlahPertanggungan = jumlahPertanggungan;
    }

    public String getIdCis() {
        return idCis;
    }

    public void setIdCis(String idCis) {
        this.idCis = idCis;
    }

    public DebiturModel getDebiturModel() {
        return debiturModel;
    }

    public void setDebiturModel(DebiturModel debiturModel) {
        this.debiturModel = debiturModel;
    }

    public String getCifCis() {
        return cifCis;
    }

    public void setCifCis(String cifCis) {
        this.cifCis = cifCis;
    }

    public String getNoPinjam() {
        return noPinjam;
    }

    public void setNoPinjam(String noPinjam) {
        this.noPinjam = noPinjam;
    }

    public Date getTanggalRealisasi() {
        return tanggalRealisasi;
    }

    public void setTanggalRealisasi(Date tanggalRealisasi) {
        this.tanggalRealisasi = tanggalRealisasi;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public double getJumlahPertanggungan() {
        return jumlahPertanggungan;
    }

    public void setJumlahPertanggungan(double jumlahPertanggungan) {
        this.jumlahPertanggungan = jumlahPertanggungan;
    }

    public void insertCis() throws ArsipException {

        Cis cis = new Cis();
        cis.setIdCis(idCis);
        cis.setDebitur(new DebiturModel().getDebiturFromModel(debiturModel));
        cis.setCifCis(cifCis);
        cis.setNoPinjam(noPinjam);
        cis.setTanggalRealisasi(tanggalRealisasi);
        cis.setTanggalMulai(tanggalMulai);
        cis.setTanggalSelesai(tanggalSelesai);
        cis.setJumlahPertanggungan(jumlahPertanggungan);

        CisDao dao = DatabaseUtilities.getCisDao();
        dao.insert(cis);
    }

}
