/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Pengarsipan;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface PengarsipanDao {

    public void insertPengarsipan(Pengarsipan pengarsipan) throws ArsipException;

    public void updatePengarsipan(Pengarsipan pengarsipan) throws ArsipException;

    public List<Pengarsipan> getAllDebitur(int skip, int max) throws ArsipException;

    public Long getLongPenerimaan() throws ArsipException;

    public void insertPenerimaan(Pengarsipan pengarsipan) throws ArsipException;

    public void insertPengembalian(Pengarsipan pengarsipan) throws ArsipException;

    public List<Pengarsipan> getDaftarBerkasTersedia(int skip, int max) throws ArsipException;
    
    public List<Pengarsipan> getDaftarBerkasTersedia(String cif) throws ArsipException;

    public Pengarsipan getPengarsipanByCIF(String cif) throws ArsipException;

    public void updatePenerimaan(Pengarsipan pengarsipan) throws ArsipException;

}
