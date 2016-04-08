/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.test;

import com.dany.plo.entitas.Dus;
import com.dany.plo.entitas.Lantai;
import com.dany.plo.entitas.Rak;
import com.dany.plo.dao.DusDao;
import com.dany.plo.dao.LantaiDao;
import com.dany.plo.dao.RakDao;
import com.dany.plo.dao.impl.DusDaoImpl;
import com.dany.plo.dao.impl.LantaiDaoImpl;
import com.dany.plo.dao.impl.RakDaoImpl;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.dany.plo.utilities.GenerateAutoId;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class TestLogic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            LantaiDao lantaiDao = new LantaiDaoImpl(DatabaseUtilities.getConnection());
            RakDao rakDao = new RakDaoImpl(DatabaseUtilities.getConnection());
            DusDao dusDao = new DusDaoImpl(DatabaseUtilities.getConnection());
            
            int dus = dusDao.getDusAkhir() + 1;
            System.out.println("Dus Ke " + dus);
            int rak = rakDao.getRakAkhir();
            
            if (rak == 0) {
                rak=1;
                Rak rak1 = new Rak();
                rak1.setIdRak(GenerateAutoId.generateAutoId());
                rak1.setNamaRak(rak);  
                rak1.setQuota(20);
                rakDao.insertRak(rak1);
            }
            System.out.println("Rak ke" + rak);
            int tmpquotaRak = rakDao.getQuotaRakAkhir();
            System.out.println("Sisa Quota Rak Akhir" + tmpquotaRak);
            int quotaRak = 20;
            int jumlahdus =10;
            
            for (int i = 1; i <= jumlahdus; i++) {
                if (tmpquotaRak != 0) {
                    if (tmpquotaRak <= quotaRak) {
                        System.out.println("lokasi :3." + rak + "." + dus);
                         tmpquotaRak=tmpquotaRak-1;
                        
                        Dus d = new Dus();
                        d.setIdDus(GenerateAutoId.generateAutoId());
                        d.setNamaDus("3." + rak + "." + dus);
                        d.setLantai(new Lantai("3", "3"));
                        d.setRak(rakDao.getRak(rak));
                        d.setQuota(10);

                        //insert dus
                        dusDao.insertDus(d);
                        //update rak
                        rakDao.updateQuotaRak(rak, tmpquotaRak);
                        System.out.println("sisa quota rak"+rak+"="+tmpquotaRak);
                    }
                } else if (tmpquotaRak == 0) {
                    rak++;
                    tmpquotaRak = 20 - 1;
                    System.out.println("lokasi :3." + rak + "." + dus);
                    
                    Rak rak1 = new Rak();
                    rak1.setIdRak(GenerateAutoId.generateAutoId());
                    rak1.setNamaRak(rak);
                    rak1.setQuota(tmpquotaRak);
                    rakDao.insertRak(rak1);
                    
                    
                    Dus d = new Dus();
                    d.setIdDus(GenerateAutoId.generateAutoId());
                    d.setNamaDus("3." + rak + "." + dus);
                    d.setLantai(new Lantai("3", "3"));
                    d.setRak(rakDao.getRak(rak));
                     d.setQuota(10);
                    //System.out.println("Rak "+rak+"sisa quota "+sisaQuita);
                    System.out.println("sisa quota rak"+rak+"="+tmpquotaRak);
                }
                dus=dus+1;
            }
        } catch (ArsipException ex) {
            Logger.getLogger(TestLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
