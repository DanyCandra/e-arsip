/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.InstansiModel;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.PanelInstansi;
import com.dany.plo.view.dialog.DialogInstansi;
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
public class InstansiController {

    private InstansiModel instansiModel;

    public void setInstansiModel(InstansiModel instansiModel) {
        this.instansiModel = instansiModel;
    }

    public void reload(int pageSize, PanelInstansi view) {
        new SwingWorker<List<InstansiModel>, Object>() {

            @Override
            protected List<InstansiModel> doInBackground() throws Exception {
                List<InstansiModel> select = instansiModel.load(0, pageSize);
                return select;

            }

            @Override
            protected void done() {
                try {
                    int totalItem = instansiModel.getLongList().intValue();
                    DefaultPaginationModel paginationModel = new DefaultPaginationModel(pageSize, totalItem);
                    view.getjPagination().setModel(paginationModel);
                    view.getTableModel().clear();
                    for (InstansiModel instansiModel : get()) {
                        view.getTableModel().add(instansiModel);
                    }
                } catch (ArsipException | InterruptedException | ExecutionException ex) {
                    Logger.getLogger(InstansiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void onPageChange(int skip, int max, PanelInstansi view) {
        new SwingWorker<List<InstansiModel>, Object>() {

            @Override
            protected List<InstansiModel> doInBackground() throws Exception {
                List<InstansiModel> select = instansiModel.load(skip, max);
                return select;
            }

            @Override
            protected void done() {
                try {
                    view.getTableModel().clear();
                    for (InstansiModel instansiModel : get()) {
                        view.getTableModel().add(instansiModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(InstansiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void crudInsret(PanelInstansi view) {

        DialogInstansi dialogInstansi = new DialogInstansi();
        dialogInstansi.setLocationRelativeTo(view);
        dialogInstansi.tambah();
        dialogInstansi.getTextNamaInstansi().setFocusable(true);
        dialogInstansi.setVisible(true);

    }

    public void crudUpdate(PanelInstansi view) {

        if (view.getTableInstansi().getSelectedRow() != -1 && view.getTableInstansi().getSelectedRowCount() == 1) {
            int index = view.getTableInstansi().getSelectedRow();
            instansiModel = view.getTableModel().get(view.getTableInstansi().convertRowIndexToModel(index));

            DialogInstansi dialogInstansi = new DialogInstansi();
            dialogInstansi.setLocationRelativeTo(view);
            dialogInstansi.update(instansiModel);
            dialogInstansi.getTextNamaInstansi().setFocusable(true);
            dialogInstansi.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(view, "Silahkan pilih data yang akan di ubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void crudDelete(PanelInstansi view) {

        if (view.getTableInstansi().getSelectedRow() != -1 && view.getTableInstansi().getSelectedRowCount() == 1) {
            int index = view.getTableInstansi().getSelectedRow();
            instansiModel = view.getTableModel().get(view.getTableInstansi().convertRowIndexToModel(index));

            if (JOptionPane.showConfirmDialog(view,
                    "Apakah Anda yakin akan menghapus data?", "Konfirmasi Hapus Data",
                    JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                try {
                    if (instansiModel.isDelete()) {
                        instansiModel.delete();
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

    public void save(DialogInstansi view) {
        String namaInstansi = view.getTextNamaInstansi().getText().toUpperCase();
        String alamat = view.getTextAlamat().getText().toUpperCase();
        String telepon = view.getTextTelepon().getText().toUpperCase();

        if (ValidatorNotNull.isNotNull(namaInstansi, view, "Nama Instansi") == true
                && ValidatorNotNull.isNotNull(alamat, view, "Alamat") == true
                && ValidatorNotNull.isNotNull(telepon, view, "Telepon") == true
                && ValidatorTextLimit.isLimit(alamat, 100, view)
                && ValidatorTextLimit.isLimit(telepon, 12, view)
                && ValidatorTextLimit.isLimit(namaInstansi, 20, view)) {

            instansiModel.setNamaInstansi(namaInstansi);
            instansiModel.setAlamat(alamat);
            instansiModel.setTelepon(telepon);

            try {
                if (view.isUpdate() == false) {
                    instansiModel.setIdInstans(GenerateAutoId.generateAutoId());
                    instansiModel.insert();
                    JOptionPane.showMessageDialog(view, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else if (view.isUpdate() == true) {
                    instansiModel.setIdInstans(view.getTmpId());
                    instansiModel.update();
                    JOptionPane.showMessageDialog(view, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }

                view.dispose();
            } catch (ArsipException ex) {
                Logger.getLogger(InstansiController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, new Object[]{"Gagal Terhubung Dengan Database", ex.getMessage()}, "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
