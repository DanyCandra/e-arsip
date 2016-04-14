/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.controller;

import com.dany.plo.exception.ArsipException;
import com.dany.plo.model.CisModel;
import com.dany.plo.model.DebiturModel;
import com.dany.plo.model.DusModel;
import com.dany.plo.model.InstansiModel;
import com.dany.plo.model.PejabatModel;
import com.dany.plo.model.PengarsipanModel;
import com.dany.plo.model.UserModel;
import com.dany.plo.utilities.GenerateAutoId;
import com.dany.plo.view.PanelPenerimaanBerkas;
import com.dany.plo.view.validator.ValidatorNotNull;
import com.dany.plo.view.validator.ValidatorNumber;
import com.dany.plo.view.validator.ValidatorTextLimit;
import com.dany.plo.view.validator.ValidatorTextMinimum;
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
public class PenerimaanController {
    
    private PengarsipanModel pengarsipanModel;
    private DebiturModel debiturModel;
    private PejabatModel pejabatModel;
    private CisModel cisModel;
    private DusModel dusModel;
    private UserModel userModel;
    private InstansiModel instansiModel;
    
    public void setPejabatModel(PejabatModel pejabatModel) {
        this.pejabatModel = pejabatModel;
    }
    
    public void setInstansiModel(InstansiModel instansiModel) {
        this.instansiModel = instansiModel;
    }
    
    public void setPengarsipanModel(PengarsipanModel pengarsipanModel) {
        this.pengarsipanModel = pengarsipanModel;
    }
    
    public void setDebiturModel(DebiturModel debiturModel) {
        this.debiturModel = debiturModel;
    }
    
    public void setCisModel(CisModel cisModel) {
        this.cisModel = cisModel;
    }
    
    public void setDusModel(DusModel dusModel) {
        this.dusModel = dusModel;
    }
    
    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
    
    public void loadCombobox(PanelPenerimaanBerkas view) {
        new SwingWorker<List<InstansiModel>, Object>() {
            @Override
            protected List<InstansiModel> doInBackground() throws Exception {
                List<InstansiModel> list = instansiModel.loadComboInstansi();
                return list;
            }
            
            @Override
            protected void done() {
                try {
                    view.getComboInstansiModel().removeAllElements();
                    for (InstansiModel instansiModel : get()) {
                        view.getComboInstansiModel().addElement(instansiModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(DusController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
        
    }
    
    public void loadDusCombobox(PanelPenerimaanBerkas view) {
        
        new SwingWorker<List<DusModel>, Object>() {
            @Override
            protected List<DusModel> doInBackground() throws Exception {
                List<DusModel> list = dusModel.loadComdoDus();
                return list;
            }
            
            @Override
            protected void done() {
                try {
                    view.getComboDusModel().removeAllElements();
                    for (DusModel instansiModel : get()) {
                        view.getComboDusModel().addElement(instansiModel);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(DusController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
        
    }
    
    public void loadPejabatCombobox(PanelPenerimaanBerkas view) {
        
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
    
    public void save(PanelPenerimaanBerkas view) {
        
        if (JOptionPane.showConfirmDialog(view, "Apakah anda data yang anda masukan sudah benar dan yakin akan menyimpan data ?", "Pesan Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                
                getParameterDebitur(view);
                getParamerterCis(view);
                getParameterDus(view);
                getParameterArsip(view);
                
                if (view.isNewDebitur() == true) {
                    debiturModel.insertDebitur();
                    
                } else if (view.isNewDebitur() == false) {
                    debiturModel.updateDebitur();
                }
                pengarsipanModel.saveAsPenerimaan();
                dusModel.updateStokPenerimaan();
                cisModel.insertCis();
                
                JOptionPane.showMessageDialog(view, "Data Berhasil Diinput", "Pesan Informasi", JOptionPane.INFORMATION_MESSAGE);
                clearInput(view);
                if (JOptionPane.showConfirmDialog(view, "Apakah anda akan mencetak tanda terima transaksi", "Pesan Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    
                }
                clearInput(view);
                setEnableInput(view, false);
            } catch (ArsipException ex) {
                Logger.getLogger(PenerimaanController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, new Object[]{"Terlah Terjadi Erro Pada Databaser", ex.getMessage()}, "Pesan Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            clearInput(view);
            setEnableInput(view, false);
        }
    }
    
    public void setParameterDebitur(PanelPenerimaanBerkas view) {
        String cif = view.getTextCIF().getText();
        if ((ValidatorNotNull.isNotNull(cif, view, "CIF") && ValidatorTextMinimum.isLimit(cif, 6, view, "CIF"))) {
            try {
                debiturModel.getByCif(cif);
                
                if (debiturModel.getNama() != null) {
                    view.getTextCIF().setText(cif);
                    view.getTextNama().setText(debiturModel.getNama());
                    view.getTextTempatLahir().setText(debiturModel.getTempatLahir());
                    view.getDateChooserTangalLahir().setDate(debiturModel.getTanggalLahir());
                    view.getTextNIK().setText(debiturModel.getNik());
                    view.getTextAlamat().setText(debiturModel.getAlamat());
                    view.getTextKelurahan().setText(debiturModel.getKelurahan());
                    view.getTextKecamatan().setText(debiturModel.getKecamatan());
                    view.getTextTelepon().setText(debiturModel.getTelepon());
                    view.getTextSkCpns().setText(debiturModel.getSkCpns());
                    view.getTextSkPengangkatan().setText(debiturModel.getSkPengangkatan());
                    view.getTextSkTerakhir().setText(debiturModel.getSkTerakhir());
                    view.getTextTaspen().setText(debiturModel.getTaspen());
                    view.getTextSkPensiun().setText(debiturModel.getSkPensiun());
                    view.getTextKarip().setText(debiturModel.getKarip());
                    view.getTextSHM().setText(debiturModel.getShm());
                    view.getTextSHT().setText(debiturModel.getSht());
                    view.getTextIjazah().setText(debiturModel.getIjazah());
                    view.getTextLainnya().setText(debiturModel.getLainnya());
                    InstansiModel model = debiturModel.getInstansi();
                    view.getComboInstansi().setSelectedItem(model);
                    
                    view.setNewDebitur(false);
                    JOptionPane.showMessageDialog(view, "Data debitur sudah tersedia silahkan sesuaikan dengan data terbaru", "Pesan Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else if (debiturModel.getNama() == null) {
                    view.setNewDebitur(true);
                    JOptionPane.showMessageDialog(view, "Data debitur belum tersedia silahkan isi data", "Pesan Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (ArsipException ex) {
                Logger.getLogger(PenerimaanController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, new Object[]{"Terlah Terjadi Erro Pada Databaser", ex.getMessage()}, "Pesan Error", JOptionPane.ERROR_MESSAGE);
            }
            setEnableInput(view, true);
            
        }
        
    }
    
    public void getParameterDebitur(PanelPenerimaanBerkas view) {
        String cif = view.getTextCIF().getText();
        String nama = view.getTextNama().getText();
        String tempatLahir = view.getTextTempatLahir().getText();
        Date tanggalLahir = view.getDateChooserTangalLahir().getDate();
        String nik = view.getTextNIK().getText();
        String alamat = view.getTextAlamat().getText();
        String kelurahan = view.getTextKelurahan().getText();
        String kecamatan = view.getTextKecamatan().getText();
        String telepon = view.getTextTelepon().getText();
        String skCpns = view.getTextSkCpns().getText();
        String skPengangkatan = view.getTextSkPengangkatan().getText();
        String skTerakhir = view.getTextSkTerakhir().getText();
        String taspen = view.getTextTaspen().getText();
        String skPensiun = view.getTextSkPensiun().getText();
        String karip = view.getTextKarip().getText();
        String shm = view.getTextSHM().getText();
        String sht = view.getTextSHT().getText();
        String ijazah = view.getTextIjazah().getText();
        String lainnya = view.getTextLainnya().getText();
        instansiModel = (InstansiModel) view.getComboInstansi().getSelectedItem();
        
        if (ValidatorNotNull.isNotNull(cif, view, "CIF") == true
                && ValidatorNotNull.isNotNull(nama, view, "Nama") == true
                && ValidatorNotNull.isNotNull(tempatLahir, view, "Tempat Lahir") == true
                && ValidatorNotNull.isNotNull(nik, view, "NIK") == true
                && ValidatorNotNull.isNotNull(alamat, view, "Alamat") == true
                && ValidatorNotNull.isNotNull(telepon, view, "Telepon") == true
                && ValidatorTextLimit.isLimit(skTerakhir, 50, view, "Sk Terkahir") == true
                && ValidatorTextLimit.isLimit(taspen, 50, view, "Taspen") == true
                && ValidatorTextLimit.isLimit(skPensiun, 50, view, "Sk Pensiun") == true
                && ValidatorTextLimit.isLimit(karip, 50, view, "Karip") == true
                && ValidatorTextLimit.isLimit(shm, 50, view, "SHM") == true
                && ValidatorTextLimit.isLimit(sht, 50, view, "SHT") == true
                && ValidatorTextLimit.isLimit(ijazah, 50, view, "Ijazah") == true
                && ValidatorTextLimit.isLimit(lainnya, 50, view, "Lainnya") == true
                && ValidatorTextLimit.isLimit(cif, 10, view, "CIF") == true
                && ValidatorTextLimit.isLimit(nama, 50, view, "Nama") == true
                && ValidatorTextLimit.isLimit(alamat, 50, view, "Alamat") == true
                && ValidatorTextLimit.isLimit(kelurahan, 30, view, "Kelurahan") == true
                && ValidatorTextLimit.isLimit(kecamatan, 30, view, "Kecamatan") == true
                && ValidatorTextLimit.isLimit(telepon, 12, view, "Telepon") == true
                && ValidatorTextLimit.isLimit(skCpns, 50, view, "Sk CPNS") == true
                && ValidatorTextLimit.isLimit(skPengangkatan, 50, view, "Sk Pengangkatan") == true) {
            
            debiturModel.setCif(cif);
            debiturModel.setNama(nama);
            debiturModel.setTempatLahir(tempatLahir);
            debiturModel.setTanggalLahir(tanggalLahir);
            debiturModel.setNik(nik);
            debiturModel.setAlamat(alamat);
            debiturModel.setKelurahan(kelurahan);
            debiturModel.setKecamatan(kecamatan);
            debiturModel.setTelepon(telepon);
            debiturModel.setSkCpns(skCpns);
            debiturModel.setSkPengangkatan(skPengangkatan);
            debiturModel.setSkTerakhir(skTerakhir);
            debiturModel.setTaspen(taspen);
            debiturModel.setSkPensiun(skPensiun);
            debiturModel.setKarip(karip);
            debiturModel.setShm(shm);
            debiturModel.setSht(sht);
            debiturModel.setIjazah(ijazah);
            debiturModel.setLainnya(lainnya);
            debiturModel.setInstansi(instansiModel);
        }
        
    }
    
    public void getParamerterCis(PanelPenerimaanBerkas view) {
        String noPinjaman = view.getTextNomorPinjaman().getText();
        Date tanggalRealisasi = view.getDateChooserRealisasi().getDate();
        Date tanggalMulai = view.getDateChooserAwal().getDate();
        Date tanggalSelesai = view.getDateChooserAkhir().getDate();
        String tmpJumalhPertanggungan = view.getTextNilaiPertanggungan().getText();
        String pinjamanke = view.getTextPinjamanKe().getText();
        String jenisPinjaman = view.getComboPinjaman().getSelectedItem().toString();
        
        if (tanggalMulai == null || tanggalRealisasi == null || tanggalSelesai == null) {
            JOptionPane.showMessageDialog(view, "Silahkan input tanggal dengan benar", "Pesan Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else if (ValidatorNotNull.isNotNull(noPinjaman, view, "Nomor Pinjam")
                && ValidatorNotNull.isNotNull(pinjamanke, view, "Urutan Pinjaman")
                && ValidatorNotNull.isNotNull(tmpJumalhPertanggungan, view, "Jumlah Pertanggungan")
                && ValidatorNumber.isNumber(tmpJumalhPertanggungan, view, "Jumlah Pertanggungan")
                && ValidatorNumber.isNumber(pinjamanke, view, "Urutan Pinjaman")) {
            
            cisModel.setIdCis(GenerateAutoId.generateAutoId());
            cisModel.setDebiturModel(debiturModel);
            cisModel.setNoPinjam(noPinjaman);
            cisModel.setCifCis(debiturModel.getCif().concat(jenisPinjaman).concat(pinjamanke));
            cisModel.setTanggalRealisasi(tanggalRealisasi);
            cisModel.setTanggalMulai(tanggalMulai);
            cisModel.setTanggalSelesai(tanggalSelesai);
            cisModel.setJumlahPertanggungan(Double.parseDouble(tmpJumalhPertanggungan));
        }
    }
    
    public void getParameterDus(PanelPenerimaanBerkas view) {
        dusModel = (DusModel) view.getComboDus().getSelectedItem();
        
    }
    
    public void getParameterArsip(PanelPenerimaanBerkas view) {
        //User Default selagi belum ada login
        pengarsipanModel.setIdArsip(GenerateAutoId.generateAutoId());
        pengarsipanModel.setDebiturModel(debiturModel);
        pengarsipanModel.setTanggalTerima(new Date());
        pengarsipanModel.setDus(dusModel);
        pengarsipanModel.setUserPenerima(userModel.getDummyUser());
        pengarsipanModel.setPejabatPenerima((PejabatModel) view.getComboPejabat().getSelectedItem());
        pengarsipanModel.setStatusArsip("1");
        
    }
    
    public void clearInput(PanelPenerimaanBerkas view) {
        view.getTextCIF().setText("");
        view.getTextNama().setText("");
        view.getTextTempatLahir().setText("");
        view.getDateChooserTangalLahir().setDate(null);
        view.getTextNIK().setText("");
        view.getTextAlamat().setText("");
        view.getTextKelurahan().setText("");
        view.getTextKecamatan().setText("");
        view.getTextTelepon().setText("");
        view.getTextSkCpns().setText("");
        view.getTextSkPengangkatan().setText("");
        view.getTextSkTerakhir().setText("");
        view.getTextTaspen().setText("");
        view.getTextSkPensiun().setText("");
        view.getTextKarip().setText("");
        view.getTextSHM().setText("");
        view.getTextSHT().setText("");
        view.getTextIjazah().setText("");
        view.getTextLainnya().setText("");
        view.getComboInstansi().setSelectedIndex(0);
        
        view.getTextNomorPinjaman().setText("");
        view.getDateChooserRealisasi().setDate(null);
        view.getDateChooserAwal().setDate(null);
        view.getDateChooserAkhir().setDate(null);
        view.getTextNilaiPertanggungan().setText("");
        view.getTextPinjamanKe().setText("");
        view.getComboPinjaman().setSelectedIndex(0);
        view.getComboPejabat().setSelectedIndex(0);
        
        view.getjTabbedPane1().setSelectedIndex(0);
    }
    
    public void setEnableInput(PanelPenerimaanBerkas view, boolean value) {
        view.getTextNama().setEnabled(value);
        view.getTextTempatLahir().setEnabled(value);
        view.getDateChooserTangalLahir().setEnabled(value);
        view.getTextNIK().setEnabled(value);
        view.getTextAlamat().setEnabled(value);
        view.getTextKelurahan().setEnabled(value);
        view.getTextKecamatan().setEnabled(value);
        view.getTextTelepon().setEnabled(value);
        view.getTextSkCpns().setEnabled(value);
        view.getTextSkPengangkatan().setEnabled(value);
        view.getTextSkTerakhir().setEnabled(value);
        view.getTextTaspen().setEnabled(value);
        view.getTextSkPensiun().setEnabled(value);
        view.getTextKarip().setEnabled(value);
        view.getTextSHM().setEnabled(value);
        view.getTextSHT().setEnabled(value);
        view.getTextIjazah().setEnabled(value);
        view.getTextLainnya().setEnabled(value);
        view.getComboInstansi().setEnabled(value);
        
        view.getTextNomorPinjaman().setEnabled(value);
        view.getDateChooserRealisasi().setEnabled(value);
        view.getDateChooserAwal().setEnabled(value);
        view.getDateChooserAkhir().setEnabled(value);
        view.getTextNilaiPertanggungan().setEnabled(value);
        view.getTextPinjamanKe().setEnabled(value);
        view.getComboPinjaman().setEnabled(value);
        view.getComboDus().setEnabled(value);
        view.getComboPejabat().setEnabled(value);
        
    }
    
}
