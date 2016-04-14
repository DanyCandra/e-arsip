/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Instansi;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface InstansiDao {

    public void insertInstansi(Instansi instansi) throws ArsipException;

    public void updateInstansi(Instansi instansi) throws ArsipException;

    public List<Instansi> getInstansi(int skip, int max) throws ArsipException;

    public List<Instansi> getInstansi() throws ArsipException;
    
     public Instansi getInstansi(String idInstansi) throws ArsipException;

    public boolean canDelete(String idInstansi) throws ArsipException;

    public void delete(String idInstansi) throws ArsipException;

    public Long count() throws ArsipException;

}
