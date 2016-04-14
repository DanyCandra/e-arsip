/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.Cis;
import com.dany.plo.exception.ArsipException;

/**
 *
 * @author Dany Candra
 */
public interface CisDao {

    public void insert(Cis cis) throws ArsipException;

    public void update(Cis cis) throws ArsipException;

}
