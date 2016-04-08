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
public class Lantai {

    private String idLantai;
    private String namaLantai;

    public Lantai() {
    }

    public Lantai(String idLantai, String namaLantai) {
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

}
