/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Dus;
import com.dany.plo.entitas.Pengarsipan;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface DusDao {

    public void insertDus(Dus dus) throws ArsipException;

    public void updateDus(Dus dus) throws ArsipException;

    public List<Dus> getAllDus() throws ArsipException;

    public List<Dus> getDusEmpety() throws ArsipException;

    public int getDusAkhir() throws ArsipException;

    public List<Dus> getAllDus(int skip, int max) throws ArsipException;

    public List<Dus> getAllDus(String idRak) throws ArsipException;

    public Dus getDus(String id) throws ArsipException;

    
}
