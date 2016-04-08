/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Lantai;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface LantaiDao {

    public void insertLantai(Lantai lantai) throws ArsipException;

    public void updateLantai(Lantai lantai) throws ArsipException;

    public void delete(String idLantai) throws ArsipException;

    public boolean canDelete(String idLantai) throws ArsipException;

    public List<Lantai> getAllLantai() throws ArsipException;

    public Lantai getLantai(String idLantai) throws ArsipException;
}
