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
    private Pejabat pejabatPenerima;
    private Dus dus;
    private Date tanggalKembali;
    private User userPengembali;
    private Pejabat pejabatPengembali;
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

    public Pejabat getPejabatPenerima() {
        return pejabatPenerima;
    }

    public void setPejabatPenerima(Pejabat pejabatPenerima) {
        this.pejabatPenerima = pejabatPenerima;
    }

    public Pejabat getPejabatPengembali() {
        return pejabatPengembali;
    }

    public void setPejabatPengembali(Pejabat pejabatPengembali) {
        this.pejabatPengembali = pejabatPengembali;
    }

    public Dus getDus() {
        return dus;
    }

    public void setDus(Dus dus) {
        this.dus = dus;
    }
    
    

}
