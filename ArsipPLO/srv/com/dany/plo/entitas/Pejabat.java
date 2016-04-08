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
public class Pejabat {
    
    private String idPejabat;
    private String namaPejabat;
    private String jabatan;

    public Pejabat() {
    }

    public Pejabat(String idPejabat, String namaPejabat, String jabatan) {
        this.idPejabat = idPejabat;
        this.namaPejabat = namaPejabat;
        this.jabatan = jabatan;
    }

    public String getIdPejabat() {
        return idPejabat;
    }

    public void setIdPejabat(String idPejabat) {
        this.idPejabat = idPejabat;
    }

    public String getNamaPejabat() {
        return namaPejabat;
    }

    public void setNamaPejabat(String namaPejabat) {
        this.namaPejabat = namaPejabat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    
    
}
