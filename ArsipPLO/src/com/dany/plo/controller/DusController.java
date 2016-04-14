/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.DusModel;
import com.dany.plo.model.LantaiModel;
import com.dany.plo.view.PanelLokasiDus;
import com.dany.plo.view.validator.ValidatorNotNull;
import com.dany.plo.view.validator.ValidatorNumber;
import com.stripbandunk.jwidget.model.DefaultPaginationModel;
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
public class DusController {

    private DusModel dusModel;
    private LantaiModel lantaiModel;

    public void setDusModel(DusModel dusModel) {
        this.dusModel = dusModel;
    }

    public void setLantaiModel(LantaiModel lantaiModel) {
        this.lantaiModel = lantaiModel;
    }

    public void loadComboBox(PanelLokasiDus view) {
        new SwingWorker<List<LantaiModel>, Object>() {
            @Override
            protected List<LantaiModel> doInBackground() throws Exception {
                List<LantaiModel> list = lantaiModel.load();
                return list;
            }

            @Override
            protected void done() {
                try {
                    view.getComboBoxModel().removeAllElements();
                    for (LantaiModel lantaiModel : get()) {
                        view.getComboBoxModel().addElement(lantaiModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(DusController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    public void reload(int pageSize, PanelLokasiDus view) {
        new SwingWorker<List<DusModel>, Object>() {

            @Override
            protected List<DusModel> doInBackground() throws Exception {
                List<DusModel> select = dusModel.load(0, pageSize);
                return select;
            }

            @Override
            protected void done() {
                try {
                    int totalItem = dusModel.getLongList();
                    DefaultPaginationModel paginationModel = new DefaultPaginationModel(pageSize, totalItem);
                    view.getjPagination().setModel(paginationModel);
                    view.getTableModel().clear();
                    for (DusModel dusModel1 : get()) {
                        view.getTableModel().add(dusModel1);
                    }
                } catch (ArsipException | InterruptedException | ExecutionException ex) {
                    Logger.getLogger(InstansiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();

    }

    public void onPageChange(int skip, int max, PanelLokasiDus view) {
        new SwingWorker<List<DusModel>, Object>() {
            @Override
            protected List<DusModel> doInBackground() throws Exception {
                List<DusModel> select = dusModel.load(skip, max);
                return select;
            }

            @Override
            protected void done() {
                try {
                    view.getTableModel().clear();
                    for (DusModel dusModel1 : get()) {
                        view.getTableModel().add(dusModel1);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(InstansiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    public void insertAuto(PanelLokasiDus view) {
        String tmpJumlah = view.getTextJumlahDus().getText();
        LantaiModel lantaiTmp = (LantaiModel) view.getComboBoxLokasi().getSelectedItem();
        if (ValidatorNotNull.isNotNull(tmpJumlah, view, "Jumlah Dus")  && ValidatorNumber.isNumber(tmpJumlah, view, "Jumlah Dus") ) {

            if (JOptionPane.showConfirmDialog(view, "Anda akan menambah dus sebanyak " + tmpJumlah + "dus ", "Perhatian", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                int jumlah = Integer.parseInt(tmpJumlah);
                try {
                    dusModel.insertDus(jumlah, lantaiTmp);
                } catch (ArsipException ex) {
                    JOptionPane.showMessageDialog(view, new Object[]{"Gagal Terhubung Dengan Database", ex.getMessage()}, "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DusController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        cancel(view);
    }

    public void cancel(PanelLokasiDus view) {
        view.getTextJumlahDus().setText("");
    }
}
