/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Pejabat;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface PejabatDao {

    public void insertPejabat(Pejabat pejabat) throws ArsipException;

    public void updatePejabat(Pejabat pejabat) throws ArsipException;

    public List<Pejabat> getPejabat(int skip, int max) throws ArsipException;
    
    public Pejabat getPejabat(String id) throws ArsipException;

    public List<Pejabat> getPejabat() throws ArsipException;

    public boolean canDelete(String idPejabat) throws ArsipException;

    public void delete(String idPejabat) throws ArsipException;

    public Long count() throws ArsipException;
}
