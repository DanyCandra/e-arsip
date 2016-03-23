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
public class Lokasi {

    private String idLokasi;
    private String namaLokasi;
    private Lantai lantai;
    private Rak rak;
    private Dus dus;
    private int quota;

    public Lokasi() {
    }

    public String getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(String idLokasi) {
        this.idLokasi = idLokasi;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public Lantai getLantai() {
        return lantai;
    }

    public void setLantai(Lantai lantai) {
        this.lantai = lantai;
    }

    public Rak getRak() {
        return rak;
    }

    public void setRak(Rak rak) {
        this.rak = rak;
    }

    public Dus getDus() {
        return dus;
    }

    public void setDus(Dus dus) {
        this.dus = dus;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

}
