/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dany.plo.test;

import com.dany.plo.dao.DusDao;
import com.dany.plo.dao.RakDao;
import com.dany.plo.dao.impl.DusDaoImpl;
import com.dany.plo.dao.impl.RakDaoImpl;
import com.dany.plo.entitas.Dus;
import com.dany.plo.entitas.Rak;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.DusModel;
import com.dany.plo.utilities.DatabaseUtilities;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class Testaja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArsipException {
        // TODO code application logic here
        DusDao dao=new DusDaoImpl(DatabaseUtilities.getConnection());
       // List<Dus> list=dao.getAllDus();
       // for (Dus dus : list) {
          //  System.out.println(dus.getNamaDus());
       // }
        
        RakDao rakDao=new RakDaoImpl(DatabaseUtilities.getConnection());
        Rak rak=rakDao.getRak("1459063875336");
        
        Dus dus=new Dus();
        //dus.set
        
    }
    
}
