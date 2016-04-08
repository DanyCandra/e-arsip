/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.RakModel;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.PanelLokasiRak;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Dany Candra
 */
public class RakController {

    private RakModel rakModel;

    public void setRakModel(RakModel rakModel) {
        this.rakModel = rakModel;
    }

    public void reload(PanelLokasiRak view) {
        new SwingWorker<List<RakModel>, Object>() {

            @Override
            protected List<RakModel> doInBackground() throws Exception {
                List<RakModel> select = rakModel.load();
                return select;

            }

            @Override
            protected void done() {
                try {
                    view.getTableModel().clear();
                    for (RakModel rakModel : get()) {
                        view.getTableModel().add(rakModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(RakController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void crudInsret(PanelLokasiRak view) {
        if (JOptionPane.showConfirmDialog(view,
                "Nama Rak akan digenerate otomatis, tekan OK untuk melanjutkan?", "Perhatian",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                rakModel.insert();
            } catch (ArsipException ex) {
                Logger.getLogger(RakController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
