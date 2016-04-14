/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.LantaiModel;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.PanelLokasiLantai;
import com.dany.plo.view.dialog.DialogLantai;
import com.dany.plo.view.validator.ValidatorNotNull;
import com.dany.plo.view.validator.ValidatorTextLimit;
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
public class LantaiController {

    private LantaiModel lantaiModel;

    public void setLantaiModel(LantaiModel lantaiModel) {
        this.lantaiModel = lantaiModel;
    }

    public void reload(PanelLokasiLantai view) {
        new SwingWorker<List<LantaiModel>, Object>() {

            @Override
            protected List<LantaiModel> doInBackground() throws Exception {
                List<LantaiModel> select = lantaiModel.load();
                return select;

            }

            @Override
            protected void done() {
                try {
                    view.getTableModel().clear();
                    for (LantaiModel lantaiModel : get()) {
                        view.getTableModel().add(lantaiModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(LantaiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    

    public void crudInsret(PanelLokasiLantai view) {

        DialogLantai dialogLantai = new DialogLantai();
        dialogLantai.setLocationRelativeTo(view);
        dialogLantai.tambah();
        dialogLantai.getTextNamaLantai().setFocusable(true);
        dialogLantai.setVisible(true);

    }

    public void crudUpdate(PanelLokasiLantai view) {

        if (view.getTableLantai().getSelectedRow() != -1 && view.getTableLantai().getSelectedRowCount() == 1) {
            int index = view.getTableLantai().getSelectedRow();
            lantaiModel = view.getTableModel().get(view.getTableLantai().convertRowIndexToModel(index));

            DialogLantai dialogLantai = new DialogLantai();
            dialogLantai.setLocationRelativeTo(view);
            dialogLantai.update(lantaiModel);
            dialogLantai.getTextNamaLantai().setFocusable(true);
            dialogLantai.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(view, "Silahkan pilih data yang akan di ubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void crudDelete(PanelLokasiLantai view) {

        if (view.getTableLantai().getSelectedRow() != -1 && view.getTableLantai().getSelectedRowCount() == 1) {
            int index = view.getTableLantai().getSelectedRow();
            lantaiModel = view.getTableModel().get(view.getTableLantai().convertRowIndexToModel(index));

            if (JOptionPane.showConfirmDialog(view,
                    "Apakah Anda yakin akan menghapus data?", "Konfirmasi Hapus Data",
                    JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                try {
                    if (lantaiModel.isDelete()) {
                        lantaiModel.delete();
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

    public void save(DialogLantai view) {
        String namaLantai = view.getTextNamaLantai().getText().toUpperCase();

        if (ValidatorNotNull.isNotNull(namaLantai, view, "Nama Lokasi") == true
                && ValidatorTextLimit.isLimit(namaLantai, 50, view,"Nama Lokasi")) {

            lantaiModel.setNamaLantai(namaLantai);

            try {
                if (view.isUpdate() == false) {
                    lantaiModel.setIdLantai(GenerateAutoId.generateAutoId());
                    lantaiModel.insert();
                    JOptionPane.showMessageDialog(view, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else if (view.isUpdate() == true) {
                    lantaiModel.setIdLantai(view.getTmpId());
                    lantaiModel.update();
                    JOptionPane.showMessageDialog(view, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }

                view.dispose();
            } catch (ArsipException ex) {
                Logger.getLogger(LantaiController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, new Object[]{"Gagal Terhubung Dengan Database", ex.getMessage()}, "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
