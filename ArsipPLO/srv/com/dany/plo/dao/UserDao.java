/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.dao;

import com.dany.plo.entitas.User;
import com.dany.plo.exception.ArsipException;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public interface UserDao {

    public void insertUser(User user) throws ArsipException;

    public void updateUser(User user) throws ArsipException;

    public List<User> getUser(int skip, int max) throws ArsipException;

    public boolean canDelete(String idUser) throws ArsipException;

    public void delete(String idUser) throws ArsipException;

    public User getUser(String username, String password) throws ArsipException;
    
    public User getUser(String idUser) throws ArsipException;

    public Long count() throws ArsipException;
}
