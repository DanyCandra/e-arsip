/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.entitas;

/**
 *
 * @author Dany Candra
 */
public class Instansi {

    private String idInstans;
    private String namaInstansi;
    private String alamat;
    private String telepon;

    public Instansi() {
    }

    public Instansi(String idInstans, String namaInstansi, String alamat, String telepon) {
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

}
