/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view;

import com.dany.plo.controller.InstansiController;
import com.dany.plo.controller.UserController;
import com.dany.plo.model.InstansiModel;
import com.dany.plo.model.UserModel;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.JPagination;
import com.stripbandunk.jwidget.model.DynamicTableModel;

/**
 *
 * @author Dany Candra
 */
public class PanelUser extends javax.swing.JPanel {

    private DynamicTableModel<UserModel> tableModel;
    private UserModel userModel;
    private UserController userController;
    private final int PAGE_SIZE = 5;

    /**
     * Creates new form PanelInstansi
     */
    public PanelUser() {
        userModel = new UserModel();
        userController = new UserController();
        userController.setUserModel(userModel);
        
        initComponents();
        
        tableModel = new DynamicTableModel<>(UserModel.class);
        tableUser.setDynamicModel(tableModel);

    }

    public DynamicTableModel<UserModel> getTableModel() {
        return tableModel;
    }

    public JPagination getjPagination() {
        return jPagination;
    }

    public JDynamicTable getTableUser() {
        return tableUser;
    }

    public void reload() {
        userController.reload(PAGE_SIZE, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new com.dany.plo.view.resource.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        labelWhite1 = new com.dany.plo.view.resource.LabelWhite();
        panelCrud1 = new com.dany.plo.view.resource.PanelCrud();
        jPagination = new com.stripbandunk.jwidget.JPagination();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new com.stripbandunk.jwidget.JDynamicTable();

        panelGradient1.setColorBottom(new java.awt.Color(0, 153, 153));
        panelGradient1.setColorTop(new java.awt.Color(0, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dany/plo/view/resource/LOGO BANK JATENG 128.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelWhite1.setForeground(new java.awt.Color(0, 0, 0));
        labelWhite1.setText("Daftar User");
        labelWhite1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWhite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelWhite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        panelCrud1.addCrudListener(new com.dany.plo.view.resource.CrudListener() {
            public void hapus(com.dany.plo.view.resource.CrudEvent evt) {
                panelCrud1Hapus(evt);
            }
            public void ubah(com.dany.plo.view.resource.CrudEvent evt) {
                panelCrud1Ubah(evt);
            }
            public void segarkan(com.dany.plo.view.resource.CrudEvent evt) {
                panelCrud1Segarkan(evt);
            }
            public void tambah(com.dany.plo.view.resource.CrudEvent evt) {
                panelCrud1Tambah(evt);
            }
        });

        jPagination.addPaginationListener(new com.stripbandunk.jwidget.listener.PaginationListener() {
            public void onPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
                jPaginationOnPageChange(evt);
            }
        });

        jScrollPane1.setViewportView(tableUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCrud1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPagination, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCrud1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPaginationOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {//GEN-FIRST:event_jPaginationOnPageChange
        // TODO add your handling code here:
        final int skip = (evt.getCurrentPage() - 1) * evt.getPageSize();
        final int max = evt.getPageSize();
        userController.onPageChange(skip, max, this);
    }//GEN-LAST:event_jPaginationOnPageChange

    private void panelCrud1Hapus(com.dany.plo.view.resource.CrudEvent evt) {//GEN-FIRST:event_panelCrud1Hapus
        // TODO add your handling code here:
        userController.crudDelete(this);
    }//GEN-LAST:event_panelCrud1Hapus

    private void panelCrud1Segarkan(com.dany.plo.view.resource.CrudEvent evt) {//GEN-FIRST:event_panelCrud1Segarkan
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_panelCrud1Segarkan

    private void panelCrud1Tambah(com.dany.plo.view.resource.CrudEvent evt) {//GEN-FIRST:event_panelCrud1Tambah
        // TODO add your handling code here:
        userController.crudInsret(this);
        reload();
    }//GEN-LAST:event_panelCrud1Tambah

    private void panelCrud1Ubah(com.dany.plo.view.resource.CrudEvent evt) {//GEN-FIRST:event_panelCrud1Ubah
        // TODO add your handling code here:
        userController.crudUpdate(this);
        reload();
    }//GEN-LAST:event_panelCrud1Ubah


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.stripbandunk.jwidget.JPagination jPagination;
    private javax.swing.JScrollPane jScrollPane1;
    private com.dany.plo.view.resource.LabelWhite labelWhite1;
    private com.dany.plo.view.resource.PanelCrud panelCrud1;
    private com.dany.plo.view.resource.PanelGradient panelGradient1;
    private com.stripbandunk.jwidget.JDynamicTable tableUser;
    // End of variables declaration//GEN-END:variables
}