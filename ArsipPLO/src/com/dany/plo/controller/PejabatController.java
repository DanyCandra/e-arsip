/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.PejabatModel;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.PanelPejabat;
import com.dany.plo.view.dialog.DialogPejabat;
import com.dany.plo.view.validator.ValidatorNotNull;
import com.dany.plo.view.validator.ValidatorTextLimit;
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
public class PejabatController {

    private PejabatModel pejabatModel;

    public void setPejabatModel(PejabatModel pejabatModel) {
        this.pejabatModel = pejabatModel;
    }

    public void reload(int pageSize, PanelPejabat view) {
        new SwingWorker<List<PejabatModel>, Object>() {

            @Override
            protected List<PejabatModel> doInBackground() throws Exception {
                List<PejabatModel> select = pejabatModel.load(0, pageSize);
                return select;

            }

            @Override
            protected void done() {
                try {
                    int totalItem = pejabatModel.getLongList().intValue();
                    DefaultPaginationModel paginationModel = new DefaultPaginationModel(pageSize, totalItem);
                    view.getjPagination().setModel(paginationModel);
                    view.getTableModel().clear();
                    for (PejabatModel pejabatModel : get()) {
                        view.getTableModel().add(pejabatModel);
                    }
                } catch (ArsipException | InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PejabatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void onPageChange(int skip, int max, PanelPejabat view) {
        new SwingWorker<List<PejabatModel>, Object>() {

            @Override
            protected List<PejabatModel> doInBackground() throws Exception {
                List<PejabatModel> select = pejabatModel.load(skip, max);
                return select;
            }

            @Override
            protected void done() {
                try {
                    view.getTableModel().clear();
                    for (PejabatModel pejabatModel : get()) {
                        view.getTableModel().add(pejabatModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PejabatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void crudInsret(PanelPejabat view) {

        DialogPejabat dialogPejabat = new DialogPejabat();
        dialogPejabat.setLocationRelativeTo(view);
        dialogPejabat.tambah();
        dialogPejabat.getTextNamaPejabat().setFocusable(true);
        dialogPejabat.setVisible(true);

    }

    public void crudUpdate(PanelPejabat view) {

        if (view.getTablePejabat().getSelectedRow() != -1 && view.getTablePejabat().getSelectedRowCount() == 1) {
            int index = view.getTablePejabat().getSelectedRow();
            pejabatModel = view.getTableModel().get(view.getTablePejabat().convertRowIndexToModel(index));

            DialogPejabat dialogPejabat = new DialogPejabat();
            dialogPejabat.setLocationRelativeTo(view);
            dialogPejabat.update(pejabatModel);
            dialogPejabat.getTextNamaPejabat().setFocusable(true);
            dialogPejabat.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(view, "Silahkan pilih data yang akan di ubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void crudDelete(PanelPejabat view) {

        if (view.getTablePejabat().getSelectedRow() != -1 && view.getTablePejabat().getSelectedRowCount() == 1) {
            int index = view.getTablePejabat().getSelectedRow();
            pejabatModel = view.getTableModel().get(view.getTablePejabat().convertRowIndexToModel(index));

            if (JOptionPane.showConfirmDialog(view,
                    "Apakah Anda yakin akan menghapus data?", "Konfirmasi Hapus Data",
                    JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                try {
                    if (pejabatModel.isDelete()) {
                        pejabatModel.delete();
                        JOptionPane.showMessageDialog(view, "Data berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(view, "Maaf, data yang telah digunakan tidak dapat dihapus", "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ArsipException ex) {
                    JOptionPane.showMessageDialog(view, new Object[]{"Gagal Terhubung Dengan Database", ex.getMessage()}, "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(view, "Silahkan pilih data yang akan di ubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void save(DialogPejabat view) {
        String namaPejabat = view.getTextNamaPejabat().getText().toUpperCase();
        String jabatan = view.getTextJabatan().getText().toUpperCase();

        if (ValidatorNotNull.isNotNull(namaPejabat, view, "Nama Pejabat") == true
                && ValidatorNotNull.isNotNull(jabatan, view, "Alamat") == true
                && ValidatorTextLimit.isLimit(namaPejabat, 50, view,"Nama Pejabat")
                && ValidatorTextLimit.isLimit(jabatan, 30, view,"Jabatan")) {

            pejabatModel.setNamaPejabat(namaPejabat);
            pejabatModel.setJabatan(jabatan);

            try {
                if (view.isUpdate() == false) {
                    pejabatModel.setIdPejabat(GenerateAutoId.generateAutoId());
                    pejabatModel.insert();
                    JOptionPane.showMessageDialog(view, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else if (view.isUpdate() == true) {
                    pejabatModel.setIdPejabat(view.getTmpId());
                    pejabatModel.update();
                    JOptionPane.showMessageDialog(view, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }

                view.dispose();
            } catch (ArsipException ex) {
                Logger.getLogger(PejabatController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, new Object[]{"Gagal Terhubung Dengan Database", ex.getMessage()}, "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
