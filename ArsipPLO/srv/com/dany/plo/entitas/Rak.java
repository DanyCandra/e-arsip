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
public class Rak {

    private String idRak;
    private int namaRak;
    private int quota;

    public Rak() {
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

}
