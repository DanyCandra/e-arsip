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
public class Dus {

    private String idDus;
    private String namaDus;
    private Lantai lantai;
    private Rak rak;
    private int quota;

    public Dus() {
    }

    public String getIdDus() {
        return idDus;
    }

    public void setIdDus(String idDus) {
        this.idDus = idDus;
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

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getNamaDus() {
        return namaDus;
    }

    public void setNamaDus(String namaDus) {
        this.namaDus = namaDus;
    }

}
