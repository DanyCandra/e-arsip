/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.exception.ArsipException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class QuotaModel {

    private int quotaRak;
    private int quotaDus;

    public QuotaModel() {
    }

    public QuotaModel(int quotaRak, int quotaDus) {
        this.quotaRak = quotaRak;
        this.quotaDus = quotaDus;
    }

    public int getQuotaRak() {
        return quotaRak;
    }

    public void setQuotaRak(int quotaRak) {
        this.quotaRak = quotaRak;
    }

    public int getQuotaDus() {
        return quotaDus;
    }

    public void setQuotaDus(int quotaDus) {
        this.quotaDus = quotaDus;
    }

    public void settingQuota() throws ArsipException {
        try {
            FileOutputStream outputStream = new FileOutputStream("quota.properties");
            Properties properties = new Properties();
            properties.setProperty("rak", quotaRak + "");
            properties.setProperty("dus", quotaDus + "");
            properties.store(outputStream, "");
        } catch (IOException ex) {
            Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArsipException(ex.getMessage());
        }
    }

    public void load() throws ArsipException {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("quota.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            setQuotaDus(Integer.valueOf(properties.getProperty("dus")));
            setQuotaRak(Integer.valueOf(properties.getProperty("rak")));
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArsipException(ex.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(QuotaModel.class.getName()).log(Level.SEVERE, null, ex);
                throw new ArsipException(ex.getMessage());
            }
        }

    }

}
