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
public class PengembalianController {

    private PengarsipanModel pengarsipanModel;
    private PejabatModel pejabatModel;
    private DusModel dusModel;

    public void setPengarsipanModel(PengarsipanModel pengarsipanModel) {
        this.pengarsipanModel = pengarsipanModel;
    }

    public void setPejabatModel(PejabatModel pejabatModel) {
        this.pejabatModel = pejabatModel;
    }

    public void setDusModel(DusModel dusModel) {
        this.dusModel = dusModel;
    }

    public void reload(int pageSize, PanelPengembalian view) {
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

    public void search(String cif, PanelPengembalian view) {
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

    public void loadPejabatCombobox(DialogPengembalian view) {

        new SwingWorker<List<PejabatModel>, Object>() {
            @Override
            protected List<PejabatModel> doInBackground() throws Exception {
                List<PejabatModel> list = pejabatModel.loadCombo();
                return list;
            }

            @Override
            protected void done() {
                try {
                    view.getComboPejabatModel().removeAllElements();
                    for (PejabatModel model : get()) {
                        view.getComboPejabatModel().addElement(model);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(DusController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    public void crudUpdate(PanelPengembalian view) {

        if (view.getTablePengembalianBerkas().getSelectedRow() != -1 && view.getTablePengembalianBerkas().getSelectedRowCount() == 1) {

            int index = view.getTablePengembalianBerkas().getSelectedRow();
            pengarsipanModel = view.getTableModel().get(view.getTablePengembalianBerkas().convertRowIndexToModel(index));
    
            

            DialogPengembalian dialogPengembalian = new DialogPengembalian();
            dialogPengembalian.setLocationRelativeTo(view);
            dialogPengembalian.update(pengarsipanModel);
            dialogPengembalian.getComboPejabat().setFocusable(true);
            dialogPengembalian.setDusModel(pengarsipanModel.getDus());
            dialogPengembalian.loadCombo();
            dialogPengembalian.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(view, "Silahkan pilih data yang akan di ubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void savePengembalian(DialogPengembalian view) {
        try {
            
            String alasan = view.getComboAlasan().getSelectedIndex() + "";
            pengarsipanModel.setIdArsip(view.getTmpId());
            pengarsipanModel.setTanggalKembali(new Date());
            pengarsipanModel.setPejabatPengembali((PejabatModel) view.getComboPejabat().getSelectedItem());
            pengarsipanModel.setUserPengembali(new UserModel().getDummyUser());
            pengarsipanModel.setStatusArsip("0");
            pengarsipanModel.setStatusKembali(alasan);
            pengarsipanModel.saveAsPengembalian();
            
            dusModel=view.getDusModel();
            dusModel.updateStokPengembalian();
            
            JOptionPane.showMessageDialog(view, "Data Berhasil Diinput", "Pesan Informasi", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            if (JOptionPane.showConfirmDialog(view, "Apakah anda akan mencetak tanda terima transaksi", "Pesan Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                
            }
        } catch (ArsipException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
