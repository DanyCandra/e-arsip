/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view;

/**
 *
 * @author Dany Candra
 */
public class PanelLokasi extends javax.swing.JPanel {

    /**
     * Creates new form PanelInstansi
     */
    public PanelLokasi() {
        initComponents();

    }
    
    public void initForm(){
        jTabbedPane1.setSelectedIndex(0);
        panelDusAuto.initForm();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelDusAuto = new com.dany.plo.view.PanelLokasiDus();
        panelLokasiLantai = new com.dany.plo.view.PanelLokasiLantai();
        panelLokasiRak = new com.dany.plo.view.PanelLokasiRak();

        panelGradient1.setColorBottom(new java.awt.Color(0, 153, 153));
        panelGradient1.setColorTop(new java.awt.Color(0, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dany/plo/view/resource/LOGO BANK JATENG 128.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelWhite1.setForeground(new java.awt.Color(0, 0, 0));
        labelWhite1.setText("Pengaturan Lokasi Arsip");
        labelWhite1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWhite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addTab("Tambah Dus", panelDusAuto);
        jTabbedPane1.addTab("Lokasi Penyimpanan", panelLokasiLantai);
        jTabbedPane1.addTab("Rak Penyimpanan", panelLokasiRak);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        int x = jTabbedPane1.getSelectedIndex();
        if (x == 0) {
            panelDusAuto.initForm();
        } else if (x == 1) {
             panelLokasiLantai.reload();
        }else if(x==2){
            panelLokasiRak.reload();
            panelLokasiRak.resetTable();
        }

    }//GEN-LAST:event_jTabbedPane1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.dany.plo.view.resource.LabelWhite labelWhite1;
    private com.dany.plo.view.PanelLokasiDus panelDusAuto;
    private com.dany.plo.view.resource.PanelGradient panelGradient1;
    private com.dany.plo.view.PanelLokasiLantai panelLokasiLantai;
    private com.dany.plo.view.PanelLokasiRak panelLokasiRak;
    // End of variables declaration//GEN-END:variables
}
