/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view;

import com.dany.plo.entitas.Rak;
import com.dany.plo.dao.RakDao;
import com.dany.plo.dao.impl.RakDaoImpl;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class TestLoopingRak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int dus = 1;
        int rak = 1;
        int sisaQuita = 5;
        int quotaRak = 5;
        int jumlahdus = 41;
        for (int i = 1; i <= jumlahdus; i++) {
            if (sisaQuita != 0 ) {
                if (sisaQuita <= quotaRak) {
                    System.out.println("lokasi :3." + rak + "." + dus);
                    sisaQuita--;
                    //System.out.println("Rak "+rak+"sisa quota "+sisaQuita);
                }
            } else if (sisaQuita == 0) {
                rak++;
                sisaQuita = 5-1;
                System.out.println("lokasi :3." + rak + "." + dus);
               //System.out.println("Rak "+rak+"sisa quota "+sisaQuita);
            }
            dus++;
        }
        
        RakDao dao=new RakDaoImpl(DatabaseUtilities.getConnection());
        try {
            Rak r=dao.getRak(1);
            System.out.println(r.getNamaRak());
        } catch (ArsipException ex) {
            Logger.getLogger(TestLoopingRak.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
