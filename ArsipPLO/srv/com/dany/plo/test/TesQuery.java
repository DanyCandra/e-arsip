/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dany.plo.test;

import com.dany.plo.dao.UserDao;
import com.dany.plo.dao.impl.UserDaoImpl;
import com.dany.plo.entitas.User;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class TesQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArsipException {
        // TODO code application logic here
        UserDao doo=new UserDaoImpl(DatabaseUtilities.getConnection());
        List<User> list=doo.getUser(0, 10);
        for (User user : list) {
            System.out.println(user.getNama());
        }
    }
    
}
