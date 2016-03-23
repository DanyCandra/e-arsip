/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dany.plo.entitas;

import java.util.Date;

/**
 *
 * @author Dany Candra
 */
public class Cis {
    
    private String idCis;
    private Debitur debitur;
    private String cifCis;
    private String noPinjam;
    private Date tanggalRealisasi;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private double jumlahPertanggungan;

    public Cis() {
    }

    public String getIdCis() {
        return idCis;
    }

    public void setIdCis(String idCis) {
        this.idCis = idCis;
    }

    public Debitur getDebitur() {
        return debitur;
    }

    public void setDebitur(Debitur debitur) {
        this.debitur = debitur;
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
    
    
    
}
