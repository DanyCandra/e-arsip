/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.QuotaModel;
import com.dany.plo.view.PanelQuota;
import com.dany.plo.view.validator.ValidatorNotNull;
import com.dany.plo.view.validator.ValidatorNumber;
import com.dany.plo.view.validator.ValidatorTextLimit;
import javax.swing.JOptionPane;

/**
 *
 * @author Dany Candra
 */
public class QuotaController {

    private QuotaModel quotaModel;

    public void setQuotaModel(QuotaModel quotaModel) {
        this.quotaModel = quotaModel;
    }

    public void load(PanelQuota quota) {
        try {
            quotaModel.load();
            quota.getTextQuotaDus().setText(quotaModel.getQuotaDus() + "");
            quota.getTextQuotaRak().setText(quotaModel.getQuotaRak() + "");
        } catch (ArsipException ex) {
            JOptionPane.showMessageDialog(quota, new Object[]{"Terjadi Kesalahan Tidak Dapat Memunculkan Data",}, "Pesan Kesalahan", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void simpan(PanelQuota quota){
        if (quota.getButtonSimpan().getText().equals("ATUR")) {
            enalbeInput(true, quota);
            quota.getButtonSimpan().setText("SIMPAN");
        }else if(quota.getButtonSimpan().getText().equals("SIMPAN")){
            settingQuota(quota);
            batal(quota);
        }
    }
    
    public void batal(PanelQuota quota){
        enalbeInput(false, quota);
        quota.getButtonSimpan().setText("ATUR");
    }

    // form properties
    private void enalbeInput(boolean value, PanelQuota quota) {
        quota.getTextQuotaDus().setEnabled(value);
        quota.getTextQuotaRak().setEnabled(value);
    }

    private void settingQuota(PanelQuota quota) {
        String tmpQuotaRak = quota.getTextQuotaRak().getText();
        String tmpQuotaDus = quota.getTextQuotaDus().getText();

        if (ValidatorNotNull.isNotNull(tmpQuotaDus, quota, "Quota Dus") == true
                && ValidatorNotNull.isNotNull(tmpQuotaRak, quota, "Quota Rak") == true
                && ValidatorNumber.isNumber(tmpQuotaDus, quota, "Quota Rak")
                && ValidatorNumber.isNumber(tmpQuotaRak, quota, "Quota Dus")
                && ValidatorTextLimit.isLimit(tmpQuotaDus, 2, quota)
                && ValidatorTextLimit.isLimit(tmpQuotaRak, 2, quota)) {

            quotaModel.setQuotaDus(Integer.valueOf(tmpQuotaDus));
            quotaModel.setQuotaRak(Integer.valueOf(tmpQuotaRak));
            try {
                quotaModel.settingQuota();
                JOptionPane.showMessageDialog(quota, "Data berhasil disimpan", "Pesan Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (ArsipException ex) {
                JOptionPane.showMessageDialog(quota, new Object[]{"Terjadi Kesalahan Tidak Dapat Menyimpan Data", ex.getMessage()}, "Pesan Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
