/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Rak;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface RakDao {

    public void insertRak(Rak rak) throws ArsipException;
    
    public void insertRakViaLoop(Rak rak) throws ArsipException;

    public List<Rak> getAllRak() throws ArsipException;

    public Rak getRak(String idRak) throws ArsipException;
    
    public Rak getRak(int namaRak) throws ArsipException;
    
    public void updateQuotaRak(int namaRak,int quotaBaru)throws ArsipException;
    
    public int getRakAkhir()throws ArsipException;
    
    public int getQuotaRakAkhir()throws ArsipException;
    
}
