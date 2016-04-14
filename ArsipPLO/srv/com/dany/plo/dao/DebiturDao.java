/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Debitur;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface DebiturDao {

    public void insertDebitur(Debitur debitur) throws ArsipException;

    public void updateDebitur(Debitur debitur) throws ArsipException;

    public Debitur getDebitur(String cif) throws ArsipException;

    public List<Debitur> getAllDebitur(int skip, int max) throws ArsipException;

    public List<Debitur> getAllDebitur(String nama) throws ArsipException;

}
