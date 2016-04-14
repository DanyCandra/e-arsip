/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.view;

import com.dany.plo.controller.PenerimaanController;
import com.dany.plo.model.CisModel;
import com.dany.plo.model.DebiturModel;
import com.dany.plo.model.DusModel;
import com.dany.plo.model.InstansiModel;
import com.dany.plo.model.PejabatModel;
import com.dany.plo.model.PengarsipanModel;
import com.dany.plo.model.UserModel;
import com.dany.plo.view.resource.render.list.DusListCellRender;
import com.dany.plo.view.resource.render.list.InstansiComboBoxModel;
import com.dany.plo.view.resource.render.list.InstansiListCellRender;
import com.dany.plo.view.resource.render.list.PejabatListCellRender;
import com.toedter.calendar.JDateChooser;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Dany Candra
 */
public class PanelPenerimaanBerkas extends javax.swing.JPanel {

    private InstansiComboBoxModel comboInstansiModel;
    private DefaultComboBoxModel<DusModel> comboDusModel;
    private DefaultComboBoxModel<PejabatModel> comboPejabatModel;
    private PejabatModel pejabatModel;
    private PengarsipanModel pengarsipanModel;
    private DebiturModel debiturModel;
    private CisModel cisModel;
    private DusModel dusModel;
    private UserModel userModel;
    private InstansiModel instansiModel;

    private PenerimaanController penerimaanController;

    private boolean update;
    private boolean newDebitur;

    /**
     * Creates new form PanelPenerimaan
     */
    public PanelPenerimaanBerkas() {
        
        userModel = new UserModel();
        instansiModel = new InstansiModel();
        pejabatModel = new PejabatModel();
        debiturModel = new DebiturModel();
        cisModel = new CisModel();
        dusModel = new DusModel();
        pengarsipanModel = new PengarsipanModel();

        penerimaanController = new PenerimaanController();
        penerimaanController.setUserModel(userModel);
        penerimaanController.setInstansiModel(instansiModel);
        penerimaanController.setPejabatModel(pejabatModel);
        penerimaanController.setDebiturModel(debiturModel);
        penerimaanController.setCisModel(cisModel);
        penerimaanController.setDusModel(dusModel);
        penerimaanController.setPengarsipanModel(pengarsipanModel);

        initComponents();

        dateChooserTangalLahir.setLocale(new Locale("in_ID"));
        dateChooserTangalLahir.setDateFormatString("dd/MM/yyyy");

        dateChooserRealisasi.setLocale(new Locale("in_ID"));
        dateChooserRealisasi.setDateFormatString("dd/MM/yyyy");

        dateChooserAkhir.setLocale(new Locale("in_ID"));
        dateChooserAkhir.setDateFormatString("dd/MM/yyyy");

        dateChooserAwal.setLocale(new Locale("in_ID"));
        dateChooserAwal.setDateFormatString("dd/MM/yyyy");

        comboInstansiModel = new InstansiComboBoxModel();
        comboInstansi.setModel(comboInstansiModel);
        comboInstansi.setRenderer(new InstansiListCellRender());

        comboDusModel = new DefaultComboBoxModel<>();
        comboDus.setModel(comboDusModel);
        comboDus.setRenderer(new DusListCellRender());

        comboPejabatModel = new DefaultComboBoxModel<>();
        comboPejabat.setModel(comboPejabatModel);
        comboPejabat.setRenderer(new PejabatListCellRender());
        
        initForm();

    }

    public DefaultComboBoxModel<InstansiModel> getComboInstansiModel() {
        return comboInstansiModel;
    }

    public JComboBox getComboInstansi() {
        return comboInstansi;
    }

    public JComboBox getComboPinjaman() {
        return comboPinjaman;
    }

    public DefaultComboBoxModel<DusModel> getComboDusModel() {
        return comboDusModel;
    }

    public JComboBox getComboDus() {
        return comboDus;
    }

    public JDateChooser getDateChooserAkhir() {
        return dateChooserAkhir;
    }

    public JDateChooser getDateChooserAwal() {
        return dateChooserAwal;
    }

    public JDateChooser getDateChooserRealisasi() {
        return dateChooserRealisasi;
    }

    public JDateChooser getDateChooserTangalLahir() {
        return dateChooserTangalLahir;
    }

    public JTextField getTextAlamat() {
        return textAlamat;
    }

    public JTextField getTextCIF() {
        return textCIF;
    }

    public JTextField getTextIjazah() {
        return textIjazah;
    }

    public JTextField getTextKarip() {
        return textKarip;
    }

    public JTextField getTextKecamatan() {
        return textKecamatan;
    }

    public JTextField getTextKelurahan() {
        return textKelurahan;
    }

    public JTextField getTextLainnya() {
        return textLainnya;
    }

    public JTextField getTextNIK() {
        return textNIK;
    }

    public JTextField getTextNama() {
        return textNama;
    }

    public JTextField getTextNilaiPertanggungan() {
        return textNilaiPertanggungan;
    }

    public JTextField getTextNomorPinjaman() {
        return textNomorPinjaman;
    }

    public JTextField getTextPinjamanKe() {
        return textPinjamanKe;
    }

    public JTextField getTextSHM() {
        return textSHM;
    }

    public JTextField getTextSHT() {
        return textSHT;
    }

    public JTextField getTextSkCpns() {
        return textSkCpns;
    }

    public JTextField getTextSkPengangkatan() {
        return textSkPengangkatan;
    }

    public JTextField getTextSkPensiun() {
        return textSkPensiun;
    }

    public JTextField getTextSkTerakhir() {
        return textSkTerakhir;
    }

    public JTextField getTextTaspen() {
        return textTaspen;
    }

    public JTextField getTextTelepon() {
        return textTelepon;
    }

    public JTextField getTextTempatLahir() {
        return textTempatLahir;
    }

    public boolean isUpdate() {
        return update;
    }

    public boolean isNewDebitur() {
        return newDebitur;
    }

    public void setNewDebitur(boolean newDebitur) {
        this.newDebitur = newDebitur;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public DefaultComboBoxModel<PejabatModel> getComboPejabatModel() {
        return comboPejabatModel;
    }

    public JComboBox getComboPejabat() {
        return comboPejabat;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public final void initForm() {
        newDebitur = true;
        penerimaanController.loadCombobox(this);
        penerimaanController.loadDusCombobox(this);
        penerimaanController.loadPejabatCombobox(this);
    }

    public void initInput() {
        newDebitur = true;
        comboDus.setSelectedIndex(0);
        comboInstansi.setSelectedIndex(0);
        comboPejabat.setSelectedIndex(0);
        comboPinjaman.setSelectedIndex(0);

        penerimaanController.clearInput(this);
        penerimaanController.setEnableInput(this, false);
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
        jLabel30 = new javax.swing.JLabel();
        labelWhite1 = new com.dany.plo.view.resource.LabelWhite();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textCIF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textKelurahan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textKecamatan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textTempatLahir = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textTelepon = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textNIK = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboInstansi = new javax.swing.JComboBox();
        labelIconReflection1 = new com.dany.plo.view.resource.LabelIconReflection();
        buttonNextPinjam = new javax.swing.JButton();
        dateChooserTangalLahir = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        comboPinjaman = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        textNomorPinjaman = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textPinjamanKe = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textNilaiPertanggungan = new javax.swing.JTextField();
        buttonDataBerkas = new javax.swing.JButton();
        dateChooserRealisasi = new com.toedter.calendar.JDateChooser();
        dateChooserAwal = new com.toedter.calendar.JDateChooser();
        dateChooserAkhir = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        textSkCpns = new javax.swing.JTextField();
        textSkPengangkatan = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        textSkTerakhir = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        textTaspen = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        textSkPensiun = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        textKarip = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        textSHM = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        textSHT = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        textIjazah = new javax.swing.JTextField();
        textLainnya = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        buttonSimpan = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        comboDus = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        comboPejabat = new javax.swing.JComboBox();

        panelGradient1.setColorBottom(new java.awt.Color(0, 153, 153));
        panelGradient1.setColorTop(new java.awt.Color(0, 204, 204));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dany/plo/view/resource/LOGO BANK JATENG 128.png"))); // NOI18N
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelWhite1.setForeground(new java.awt.Color(0, 0, 0));
        labelWhite1.setText("Penerimaan Berkas Kredit");
        labelWhite1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWhite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
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
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Debitur"));

        jLabel1.setText("CIF");

        textCIF.setText("1");
        textCIF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCIFKeyReleased(evt);
            }
        });

        jLabel2.setText("NAMA");

        textNama.setText("da");
        textNama.setEnabled(false);

        jLabel3.setText("ALAMAT");

        textAlamat.setText("d");
        textAlamat.setEnabled(false);

        jLabel5.setText("KELURAHAN");

        textKelurahan.setText("d");
        textKelurahan.setEnabled(false);

        jLabel7.setText("KECAMATAN");

        textKecamatan.setText("d");
        textKecamatan.setEnabled(false);

        jLabel8.setText("TEMPAT LAHIR");

        textTempatLahir.setText("da");
        textTempatLahir.setEnabled(false);

        jLabel10.setText("TELEPON");

        textTelepon.setText("0");
        textTelepon.setEnabled(false);

        jLabel11.setText("NIK");

        textNIK.setText("1");
        textNIK.setEnabled(false);

        jLabel12.setText("TANGGAL LAHIR");

        jLabel9.setText("INSTANSI");

        comboInstansi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboInstansi.setEnabled(false);

        labelIconReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dany/plo/view/resource/LOGO BANK JATENG 128.png"))); // NOI18N

        buttonNextPinjam.setText("Selanjutnya");
        buttonNextPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPinjamActionPerformed(evt);
            }
        });

        dateChooserTangalLahir.setDate(new java.util.Date());
        dateChooserTangalLahir.setDateFormatString("MMMM dd, yyyy");
        dateChooserTangalLahir.setEnabled(false);

        jButton1.setText("Cek");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(textKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textKecamatan))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(textAlamat)
                                        .addGap(163, 163, 163)))
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textTelepon)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(comboInstansi, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(textTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateChooserTangalLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                    .addComponent(textNama))
                                .addGap(87, 87, 87))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNIK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(labelIconReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonNextPinjam)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(textNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserTangalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(textTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))))
                    .addComponent(labelIconReflection1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(textKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboInstansi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(buttonNextPinjam)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Data Debitur", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Pinjaman"));

        jLabel13.setText("JENIS PINJAMAN");

        comboPinjaman.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PLO", "KWU" }));
        comboPinjaman.setEnabled(false);

        jLabel14.setText("NO PINJAMAN");

        textNomorPinjaman.setText("1");
        textNomorPinjaman.setEnabled(false);

        jLabel15.setText("PINJAMAN KE ");

        textPinjamanKe.setText("1");
        textPinjamanKe.setEnabled(false);

        jLabel16.setText("TANGGAL REALISASI");

        jLabel17.setText("JWK AWAL");

        jLabel18.setText("JWK AKHIR");

        jLabel19.setText("NILAI PERTANGGUNGAN");

        textNilaiPertanggungan.setText("1");
        textNilaiPertanggungan.setEnabled(false);

        buttonDataBerkas.setText("Selanjutnya");
        buttonDataBerkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataBerkasActionPerformed(evt);
            }
        });

        dateChooserRealisasi.setDate(new java.util.Date());
        dateChooserRealisasi.setEnabled(false);

        dateChooserAwal.setDate(new java.util.Date());
        dateChooserAwal.setEnabled(false);

        dateChooserAkhir.setDate(new java.util.Date());
        dateChooserAkhir.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dateChooserRealisasi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooserAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboPinjaman, 0, 516, Short.MAX_VALUE)
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNomorPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPinjamanKe, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNilaiPertanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDataBerkas)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textNomorPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(textPinjamanKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18))
                            .addComponent(dateChooserRealisasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooserAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(textNilaiPertanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(buttonDataBerkas))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dateChooserAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Data Pinjaman", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Berkas"));

        jLabel20.setText("SK CPNS");

        textSkCpns.setText("1");
        textSkCpns.setEnabled(false);

        textSkPengangkatan.setText("1");
        textSkPengangkatan.setEnabled(false);

        jLabel21.setText("SK PENGANGKATAN");

        textSkTerakhir.setEnabled(false);

        jLabel22.setText("SK TERKAHIR");

        textTaspen.setEnabled(false);

        jLabel23.setText("TASEPEN");

        textSkPensiun.setEnabled(false);

        jLabel24.setText("SK PENSIUN");

        textKarip.setEnabled(false);

        jLabel25.setText("KARIP");

        textSHM.setEnabled(false);

        jLabel26.setText("SHM");

        jLabel27.setText("SHT");

        textSHT.setEnabled(false);

        jLabel28.setText("IJAZAH");

        textIjazah.setEnabled(false);

        textLainnya.setEnabled(false);

        jLabel29.setText("LAINNYA");

        buttonSimpan.setText("SIMPAN");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonBatal.setText("BATAL");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pilih Dus Penyimpanan"));

        jLabel31.setText("PILIH DUS");

        comboDus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDus.setEnabled(false);

        jLabel32.setText("PEJABAT");

        comboPejabat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPejabat.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(102, 102, 102)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboDus, 0, 241, Short.MAX_VALUE)
                    .addComponent(comboPejabat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(comboDus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(comboPejabat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textSkPensiun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(textSkTerakhir, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSkPengangkatan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSkCpns, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTaspen, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textSHT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(textSHM, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textKarip, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLainnya)
                            .addComponent(textIjazah))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(textKarip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(textSHM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(textSHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(textIjazah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(textLainnya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(textSkCpns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(textSkPengangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(textSkTerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(textTaspen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(textSkPensiun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonBatal))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Data Berkas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNextPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPinjamActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_buttonNextPinjamActionPerformed

    private void buttonDataBerkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataBerkasActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);

    }//GEN-LAST:event_buttonDataBerkasActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        penerimaanController.save(this);
        initInput();
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:
        initInput();
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        penerimaanController.setParameterDebitur(this);
        textNIK.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textCIFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCIFKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            penerimaanController.setParameterDebitur(this);
            textNIK.requestFocus();
        }

    }//GEN-LAST:event_textCIFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonDataBerkas;
    private javax.swing.JButton buttonNextPinjam;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox comboDus;
    private javax.swing.JComboBox comboInstansi;
    private javax.swing.JComboBox comboPejabat;
    private javax.swing.JComboBox comboPinjaman;
    private com.toedter.calendar.JDateChooser dateChooserAkhir;
    private com.toedter.calendar.JDateChooser dateChooserAwal;
    private com.toedter.calendar.JDateChooser dateChooserRealisasi;
    private com.toedter.calendar.JDateChooser dateChooserTangalLahir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.dany.plo.view.resource.LabelIconReflection labelIconReflection1;
    private com.dany.plo.view.resource.LabelWhite labelWhite1;
    private com.dany.plo.view.resource.PanelGradient panelGradient1;
    private javax.swing.JTextField textAlamat;
    private javax.swing.JTextField textCIF;
    private javax.swing.JTextField textIjazah;
    private javax.swing.JTextField textKarip;
    private javax.swing.JTextField textKecamatan;
    private javax.swing.JTextField textKelurahan;
    private javax.swing.JTextField textLainnya;
    private javax.swing.JTextField textNIK;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNilaiPertanggungan;
    private javax.swing.JTextField textNomorPinjaman;
    private javax.swing.JTextField textPinjamanKe;
    private javax.swing.JTextField textSHM;
    private javax.swing.JTextField textSHT;
    private javax.swing.JTextField textSkCpns;
    private javax.swing.JTextField textSkPengangkatan;
    private javax.swing.JTextField textSkPensiun;
    private javax.swing.JTextField textSkTerakhir;
    private javax.swing.JTextField textTaspen;
    private javax.swing.JTextField textTelepon;
    private javax.swing.JTextField textTempatLahir;
    // End of variables declaration//GEN-END:variables
}
