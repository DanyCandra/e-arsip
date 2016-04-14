/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.DusModel;
import com.dany.plo.model.PejabatModel;
import com.dany.plo.model.PengarsipanModel;
import com.dany.plo.model.UserModel;
import com.dany.plo.view.PanelPencarianBerkas;
import com.dany.plo.view.PanelPengembalian;
import com.dany.plo.view.dialog.DialogPengembalian;
import com.stripbandunk.jwidget.model.DefaultPaginationModel;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Dany Candra
 */
public class PencarianController {

    private PengarsipanModel pengarsipanModel;


    public void setPengarsipanModel(PengarsipanModel pengarsipanModel) {
        this.pengarsipanModel = pengarsipanModel;
    }

    public void reload(int pageSize, PanelPencarianBerkas view) {
        new SwingWorker<List<PengarsipanModel>, Object>() {

            @Override
            protected List<PengarsipanModel> doInBackground() throws Exception {
                List<PengarsipanModel> select = pengarsipanModel.getDaftarBerkasTersedia(0, pageSize);
                return select;

            }

            @Override
            protected void done() {
                try {
                    int totalItem = pengarsipanModel.getCountBerkasTersedia();
                    DefaultPaginationModel paginationModel = new DefaultPaginationModel(pageSize, totalItem);
                    view.getjPagination().setModel(paginationModel);
                    view.getTableModel().clear();
                    for (PengarsipanModel model : get()) {
                        view.getTableModel().add(model);

                    }
                } catch (ArsipException | InterruptedException | ExecutionException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void search(String cif, PanelPencarianBerkas view) {
        new SwingWorker<List<PengarsipanModel>, Object>() {

            @Override
            protected List<PengarsipanModel> doInBackground() throws Exception {
                List<PengarsipanModel> select = pengarsipanModel.searchDaftarBerkasTersedia(cif);
                return select;

            }

            @Override
            protected void done() {
                try {

                    view.getTableModel().clear();
                    for (PengarsipanModel model : get()) {
                        view.getTableModel().add(model);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

}
