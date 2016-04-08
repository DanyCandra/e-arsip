/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.UserModel;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.PanelUser;
import com.dany.plo.view.dialog.DialogUser;
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
public class UserController {

    private UserModel userModel;

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void reload(int pageSize, PanelUser view) {
        new SwingWorker<List<UserModel>, Object>() {

            @Override
            protected List<UserModel> doInBackground() throws Exception {
                List<UserModel> select = userModel.load(0, pageSize);
                return select;

            }

            @Override
            protected void done() {
                try {
                    int totalItem = userModel.getLongList().intValue();
                    DefaultPaginationModel paginationModel = new DefaultPaginationModel(pageSize, totalItem);
                    view.getjPagination().setModel(paginationModel);
                    view.getTableModel().clear();
                    for (UserModel userModel : get()) {
                        view.getTableModel().add(userModel);
                    }
                } catch (ArsipException | InterruptedException | ExecutionException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void onPageChange(int skip, int max, PanelUser view) {
        new SwingWorker<List<UserModel>, Object>() {

            @Override
            protected List<UserModel> doInBackground() throws Exception {
                List<UserModel> select = userModel.load(skip, max);
                return select;
            }

            @Override
            protected void done() {
                try {
                    view.getTableModel().clear();
                    for (UserModel userModel : get()) {
                        view.getTableModel().add(userModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }

    public void crudInsret(PanelUser view) {

        DialogUser dialogUser = new DialogUser();
        dialogUser.setLocationRelativeTo(view);
        dialogUser.tambah();
        dialogUser.getTextUserName().setFocusable(true);
        dialogUser.setVisible(true);

    }

    public void crudUpdate(PanelUser view) {

        if (view.getTableUser().getSelectedRow() != -1 && view.getTableUser().getSelectedRowCount() == 1) {
            int index = view.getTableUser().getSelectedRow();
            userModel = view.getTableModel().get(view.getTableUser().convertRowIndexToModel(index));

            DialogUser dialogUser = new DialogUser();
            dialogUser.setLocationRelativeTo(view);
            dialogUser.update(userModel);
            dialogUser.getTextUserName().setFocusable(true);
            dialogUser.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(view, "Silahkan pilih data yang akan di ubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void crudDelete(PanelUser view) {

        if (view.getTableUser().getSelectedRow() != -1 && view.getTableUser().getSelectedRowCount() == 1) {
            int index = view.getTableUser().getSelectedRow();
            userModel = view.getTableModel().get(view.getTableUser().convertRowIndexToModel(index));

            if (JOptionPane.showConfirmDialog(view,
                    "Apakah Anda yakin akan menghapus data?", "Konfirmasi Hapus Data",
                    JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                try {
                    if (userModel.isDelete()) {
                        userModel.delete();
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

    public void save(DialogUser view) {
        String username = view.getTextUserName().getText().toUpperCase();
        String password = view.getTextPassword().getText().toUpperCase();
        String nama = view.getTextNama().getText().toUpperCase();

        if (ValidatorNotNull.isNotNull(username, view, "Nama User") == true
                && ValidatorNotNull.isNotNull(password, view, "Alamat") == true
                && ValidatorNotNull.isNotNull(nama, view, "Telepon") == true
                && ValidatorTextLimit.isLimit(username, 20, view)
                && ValidatorTextLimit.isLimit(password, 20, view)
                && ValidatorTextLimit.isLimit(nama, 20, view)) {

            userModel.setUserName(username);
            userModel.setPassword(password);
            userModel.setNama(nama);

            try {
                if (view.isUpdate() == false) {
                    userModel.setIdUser(GenerateAutoId.generateAutoId());
                    userModel.insert();
                    JOptionPane.showMessageDialog(view, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else if (view.isUpdate() == true) {
                    userModel.setIdUser(view.getTmpId());
                    userModel.update();
                    JOptionPane.showMessageDialog(view, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }

                view.dispose();
            } catch (ArsipException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, new Object[]{"Gagal Terhubung Dengan Database", ex.getMessage()}, "Telah Terjadi Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
