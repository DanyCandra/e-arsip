/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view;

import com.dany.plo.controller.RakController;
import com.dany.plo.model.RakModel;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;

/**
 *
 * @author Dany Candra
 */
public class PanelLokasiRak extends javax.swing.JPanel {

    private DynamicTableModel<RakModel> tableModel;
    private RakModel rakModel;
    private RakController rakController;

    /**
     * Creates new form PanelRak
     */
    public PanelLokasiRak() {
        rakModel = new RakModel();
        rakController = new RakController();
        tableModel = new DynamicTableModel<>(RakModel.class);

        initComponents();

        tableRak.setDynamicModel(tableModel);
        rakController.setRakModel(rakModel);
    }

    public DynamicTableModel<RakModel> getTableModel() {
        return tableModel;
    }

    public JDynamicTable getTableRak() {
        return tableRak;
    }

    public void reload() {
        rakController.reload(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRak = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel1 = new javax.swing.JPanel();
        buttonSegarkan = new javax.swing.JButton();

        jScrollPane1.setViewportView(tableRak);

        buttonSegarkan.setText("SEGARKAN");
        buttonSegarkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSegarkanActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSegarkan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSegarkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSegarkanActionPerformed
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_buttonSegarkanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSegarkan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.stripbandunk.jwidget.JDynamicTable tableRak;
    // End of variables declaration//GEN-END:variables
}