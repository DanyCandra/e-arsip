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
public class Pengarsipan {
    
    private String idArsip;
    private Debitur debitur;
    private Date tanggalTerima;
    private User userPenerima;
    private Lokasi lokasi;
    private Date tanggalKembali;
    private User userPengembali;
    private String statusArsip;
    private String statusKembali;

    public Pengarsipan() {
    }

    public String getIdArsip() {
        return idArsip;
    }

    public void setIdArsip(String idArsip) {
        this.idArsip = idArsip;
    }

    public Debitur getDebitur() {
        return debitur;
    }

    public void setDebitur(Debitur debitur) {
        this.debitur = debitur;
    }

    public Date getTanggalTerima() {
        return tanggalTerima;
    }

    public void setTanggalTerima(Date tanggalTerima) {
        this.tanggalTerima = tanggalTerima;
    }

    public User getUserPenerima() {
        return userPenerima;
    }

    public void setUserPenerima(User userPenerima) {
        this.userPenerima = userPenerima;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public User getUserPengembali() {
        return userPengembali;
    }

    public void setUserPengembali(User userPengembali) {
        this.userPengembali = userPengembali;
    }

    public String getStatusArsip() {
        return statusArsip;
    }

    public void setStatusArsip(String statusArsip) {
        this.statusArsip = statusArsip;
    }

    public String getStatusKembali() {
        return statusKembali;
    }

    public void setStatusKembali(String statusKembali) {
        this.statusKembali = statusKembali;
    }
    
    
}
